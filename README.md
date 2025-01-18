# Poste Inteligente com Fiware Orion

Este repositório contém a aplicação para o projeto de **Poste Inteligente**, que utiliza Fiware Orion para gerenciamento de dados. O projeto está dividido em três principais componentes:

1. **Docker**: Configuração do ambiente de desenvolvimento e serviços.
2. **Frontend (Nuxt.js)**: Interface para gestão e visualização.
3. **API**: Backend em Spring Boot responsável pela lógica do sistema.

---

## Índice
- [Requisitos](#requisitos)
- [Configuração do Docker](#configuração-do-docker)
- [Executando o Frontend (Nuxt.js)](#executando-o-frontend-nuxtjs)
- [Executando a API](#executando-a-api)
- [Considerações Finais](#considerações-finais)

---

## Requisitos
Antes de começar, você precisará ter os seguintes softwares instalados:

- [Docker](https://www.docker.com/)
- [Node.js](https://nodejs.org/) (recomendado: versão LTS)
- [npm](https://www.npmjs.com/) ou [yarn](https://yarnpkg.com/)
- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (para executar a API)

---

## Configuração do Docker

1. **Acesse a pasta `Docker`:**
   ```bash
   cd Docker
2. **Inicie os contêineres**
   ```bash
   sudo ./services start
3. **Criar entidades através do MQTT**
   ```bash
   mosquitto_pub -h localhost -t "/ul/group4/movement01/attrs" -m "s|1000"
   ```
    ```bash
   mosquitto_pub -h localhost -t "/ul/group4/button01/attrs" -m "s|of"
   ```
     ```bash
   mosquitto_pub -h localhost -t "/ul/group4/sensor01/attrs" -m "l|off"
   ```
      ```bash
   mosquitto_pub -h localhost -t "/ul/group4/led01/attrs" -m "p|off"
   ```
   
