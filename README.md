# Poste Inteligente com Fiware Orion

Este repositório contém a aplicação para o projeto de **Poste Inteligente**, que utiliza Fiware Orion para gerenciamento de dados. O projeto está dividido em três principais componentes:

1. **Docker**: Configuração do ambiente de desenvolvimento e serviços.
2. **Frontend (Nuxt.js)**: Interface para gestão e visualização.
3. **API**: Backend em Spring Boot responsável pela lógica do sistema.

---

## Índice
- [Requisitos](#requisitos)
- [Configuração do Docker](#configuração-do-docker)
- [Executando o Front-End](#executando-o-front-end)
- [Executando a API](#executando-a-api)
- [Considerações Finais](#considerações-finais)

---

## Requisitos
Antes de começar, você precisará ter os seguintes softwares instalados:

- [Docker](https://www.docker.com/)
- [Node.js](https://nodejs.org/) (recomendado: versão LTS)
- [npm](https://www.npmjs.com/) ou [yarn](https://yarnpkg.com/)
- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (para executar a API)
- [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/download/?section=windows) (IDE para API)

---

## Configuração do Docker
1. **Acesse a pasta do projeto `Poste_Inteligente_Fiware_Orion`**
    ```bash
   cd Poste_Inteligente_Fiware_Orion/
   ```
2. **Acesse a pasta `Docker`:**
   ```bash
   cd Docker/
   ```
3. **Inicie os contêineres**
    ```bash
   sudo ./services create
    ```
   ```bash
   sudo ./services start
   ```
4. **Criar entidades através do MQTT**
   ```bash
   mosquitto_pub -h localhost -t "/ul/group4/movement01/attrs" -m "s|1000"
   ```
   ```bash
   mosquitto_pub -h localhost -t "/ul/group4/button01/attrs" -m "s|off"
   ```
   ```bash
   mosquitto_pub -h localhost -t "/ul/group4/sensor01/attrs" -m "l|off"
   ```
   ```bash
   mosquitto_pub -h localhost -t "/ul/group4/led01/attrs" -m "p|off"
   ```
## Executando o Front-End
1. **Entre na pasta da aplicação**
   ```bash
      cd isp-front
   
      cd isp
   ```
2. **Execute o comando instalar as dependências**
   ```bash
      npm install
   ```
3. **Inicie o servidor de desenvolvimento**
   ```bash
      npm run dev
   ```
## Executando a API
1. **Entre na pasta da aplicação**
   ```bash
      cd api-isp
   
      cd isp-api
   
      Clique com o botão direito em um local vazio e escolha abrir com o Intellij
   ```
2. **Dependências**
   ```bash
      Clique no botão do Maven no canto direito da tela para instalar as dependências
   ```
3. **Banco de dados**
   ```bash
      Adapte o application.properties para a configuração do seu banco de dados
   ```
4. **Execute o projeto**
   ```bash
      Clique no botão de run na barra superio para rodar o projeto
   ```

      
   
