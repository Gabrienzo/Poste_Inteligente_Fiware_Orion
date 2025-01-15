#include <WiFi.h>
#include <PubSubClient.h>

// Temporizador e botão
#define timeSeconds 10
#define BUTTON_PIN 18

// LEDs
const int led[3] = {2, 4, 5};

// Sensor de luz (LDR)
const int ldrPin = 19;
int ldrValue = 0;

// Sensor de movimento
const int motionSensor = 21;

// Configuração do Wi-Fi e MQTT
const char* ssid = "nome do wifi";          // Substitua pelo seu SSID
const char* password = "senha do wifi";      // Substitua pela sua senha Wi-Fi
const char* mqtt_server = "10.0.0.151";  // Substitua pelo IP do seu broker MQTT
const char* mqtt_user = "posteESP";   // Usuário MQTT
const char* mqtt_pass = "posteimd";     // Senha MQTT

WiFiClient espClient;
PubSubClient client(espClient);

// Timer: Variáveis auxiliares
unsigned long now = millis();
unsigned long lastTrigger = 0;
unsigned long lastLdrRead = 0; // Temporizador para leitura do LDR
boolean startTimer = false;
boolean motionDetected = false;

// Função para conectar ao Wi-Fi
void setupWiFi() {
  delay(10);
  Serial.println();
  Serial.print("Conectando-se ao Wi-Fi: ");
  Serial.println(ssid);
  
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  
  Serial.println();
  Serial.println("Conectado ao Wi-Fi!");
}

// Função para conectar ao broker MQTT com autenticação
void reconnect() {
  while (!client.connected()) {
    Serial.print("Tentando conectar ao MQTT...");
    if (client.connect("ESP32Client", mqtt_user, mqtt_pass)) {
      Serial.println("Conectado!");
    } else {
      Serial.print("Falhou, rc=");
      Serial.print(client.state());
      Serial.println(" Tentando novamente em 5 segundos...");
      delay(5000);
    }
  }
}

// Liga os LEDs ao detectar movimento
void IRAM_ATTR detectsMovement() {
  if (!motionDetected) {
    Serial.println("Movimento detectado!");
    motionDetected = true;
    // Publicar no tópico de movimento
    client.publish("movimento/status", "detected");
  }

  // Liga os LEDs
  for (int i = 0; i < 3; i++) {
    digitalWrite(led[i], HIGH);
  }

  startTimer = true;
  lastTrigger = millis();
}

void setup() {
  // Porta Serial para depuração
  Serial.begin(115200);

  // Configuração do botão
  pinMode(BUTTON_PIN, INPUT_PULLUP);

  // Configura o sensor de movimento como entrada
  pinMode(motionSensor, INPUT_PULLUP);
  attachInterrupt(digitalPinToInterrupt(motionSensor), detectsMovement, RISING);

  // Configura os LEDs como saída e desliga todos
  for (int i = 0; i < 3; i++) {
    pinMode(led[i], OUTPUT);
    digitalWrite(led[i], LOW);
  }

  // Configuração do Wi-Fi e MQTT
  setupWiFi();
  client.setServer(mqtt_server, 1883);

  Serial.println("Sistema iniciado. Aguardando eventos...");
}

void loop() {
  now = millis();

  // Verifica o botão
  int buttonState = digitalRead(BUTTON_PIN);
  if (buttonState == LOW) { // Botão pressionado
    Serial.println("Botão pressionado!");
    client.publish("botao/status", "pressionado");  // Publica no tópico do botão
    delay(200); // Debounce
  }

  // Lê o valor do sensor de luz (LDR) a cada 10 segundos
  if (now - lastLdrRead >= 10000) {
    ldrValue = analogRead(ldrPin);
    Serial.print("Intensidade de Luz (LDR): ");
    Serial.println(ldrValue);
    
    // Publica o valor da luz no tópico
    client.publish("sensor/luz", String(ldrValue).c_str());

    // Controla os LEDs com base na luz ambiente
    if (!startTimer) { // Apenas controla os LEDs se não houver movimento detectado
      if (ldrValue < 1000) {         // Baixa intensidade de luz
        ligarLeds(1);                // Liga 1 LED
        client.publish("led/potencia", "1");
      } else if (ldrValue < 3000) {  // Intensidade média de luz
        ligarLeds(2);                // Liga 2 LEDs
        client.publish("led/potencia", "2");
      } else {                       // Alta intensidade de luz
        ligarLeds(3);                // Liga 3 LEDs
        client.publish("led/potencia", "3");
      }
    }

    // Atualiza o tempo da última leitura do LDR
    lastLdrRead = now;
  }

  // Reconectar ao broker MQTT se necessário
  if (!client.connected()) {
    reconnect();
  }
  client.loop();

  // Desliga os LEDs após o tempo definido
  if (startTimer && (now - lastTrigger > (timeSeconds * 1000))) {
    if (motionDetected) {
      Serial.println("Movimento parado. Desligando LEDs...");
      motionDetected = false;
      client.publish("movimento/status", "parado"); // Publicar no tópico de movimento
    }

    // Desliga os LEDs
    for (int i = 0; i < 3; i++) {
      digitalWrite(led[i], LOW);
    }

    startTimer = false;
  }

  delay(100); // Pequeno atraso para estabilidade
}

// Função para controlar a quantidade de LEDs ligados
void ligarLeds(int quantidade) {
  for (int i = 0; i < 3; i++) {
    if (i < quantidade) {
      digitalWrite(led[i], HIGH); // Liga os LEDs necessários
    } else {
      digitalWrite(led[i], LOW);  // Desliga os LEDs restantes
    }
  }
}
