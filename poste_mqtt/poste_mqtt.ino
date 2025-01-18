#include <WiFi.h>
#include <PubSubClient.h>

// Temporizador e botão
#define timeSeconds 10
#define BUTTON_PIN 14

// LEDs
const int led[3] = {25, 26, 27};

// Sensor de luz (LDR)
const int ldrPin = 32;
int ldrValue = 0;

// Sensor de movimento
const int motionSensor = 12;

// Configuração do Wi-Fi e MQTT
const char* ssid = "nome do wifi";          // Substitua pelo seu SSID
const char* password = "senha";      // Substitua pela sua senha Wi-Fi
const char* mqtt_server = "ip";  // Substitua pelo IP do seu broker MQTT
//const char* mqtt_user = "posteESP";   // Usuário MQTT
//const char* mqtt_pass = "posteimd";     // Senha MQTT

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
    if (client.connect("ESP32Client")) {
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
    client.publish("/ul/group4/movement01/attrs", "m|detected");
  }

  // Liga os LEDs
  digitalWrite(led[0], HIGH);
  digitalWrite(led[1], HIGH);
  digitalWrite(led[2], HIGH);

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
  pinMode(led[0], OUTPUT);
  pinMode(led[1], OUTPUT);
  pinMode(led[2], OUTPUT);
  digitalWrite(led[0], LOW);
  digitalWrite(led[1], LOW);
  digitalWrite(led[2], LOW);

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
    client.publish("/ul/group4/button01/attrs", "b|pressionado");  // Publica no tópico do botão
    delay(200); // Debounce
  }

  /// Lê o valor do sensor de luz (LDR) a cada 5 segundos
  if (now - lastLdrRead >= 5000) {
    ldrValue = analogRead(ldrPin);
    Serial.print("Intensidade de Luz (LDR): ");
    Serial.println(ldrValue);
    client.publish("/ul/group4/sensor01/attrs", "l|" + ldrValue);

    // Controla os LEDs com base na luz ambiente
    if (!startTimer) { // Apenas controla os LEDs se não houver movimento detectado
      if (ldrValue < 500) {         // Baixa intensidade de luz
        digitalWrite(led[0], HIGH);
        digitalWrite(led[1], HIGH);
        digitalWrite(led[2], HIGH);
      } else if (ldrValue < 1000) {  // Intensidade média de luz
        digitalWrite(led[0], HIGH);
        digitalWrite(led[1], HIGH);
        digitalWrite(led[2], LOW);
      } else if (ldrValue < 2000) {                       // Alta intensidade de luz
        digitalWrite(led[0], HIGH);
        digitalWrite(led[1], LOW);
        digitalWrite(led[2], LOW);
      } else {
        digitalWrite(led[0], LOW);
        digitalWrite(led[1], LOW);
        digitalWrite(led[2], LOW);
      }
    }
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
      client.publish("movimento/status", "m|parado"); // Publicar no tópico de movimento
    }

    // Desliga os LEDs
    digitalWrite(led[0], LOW);
    digitalWrite(led[1], LOW);
    digitalWrite(led[2], LOW);

    startTimer = false;
  }

  delay(100); // Pequeno atraso para estabilidade
}

