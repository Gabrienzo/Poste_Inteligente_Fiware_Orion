<template>
  <v-container>
    <v-row justify="center">
      <v-col cols="12" md="8">
        <h2>Gestão de Iluminação Pública</h2>

        <v-card class="pa-4">
          <v-card-title>Controle de Iluminação</v-card-title>
          <v-card-text>
            <p>As luzes estão: {{ lightsOn ? 'Ligadas' : 'Desligadas' }}</p>
            <v-btn :color="lightsOn ? 'red' : 'accent'" class="ma-2" @click="toggleLights">
              {{ lightsOn ? 'Desligar Luzes' : 'Ligar Luzes' }}
            </v-btn>

            <v-btn color="secondary" class="ma-2" :to="'/dashboard'">
              Ir para o Dashboard
            </v-btn>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { ligarLuzes } from "~/helpers/API.js";

export default {
  data() {
    return {
      lightsOn: false,
    }
  },
  methods: {
    async toggleLights() {
      this.lightsOn = !this.lightsOn;
      try {
        const value = this.lightsOn ? 'on' : 'off';
        const dispositivo = 'Sensor:01';
        const attr = 'Light'
        // Chamando o método para ligar/desligar as luzes via API
        const resultado = await ligarLuzes(value, dispositivo, attr);
        console.log('Resposta da API:', resultado);
      } catch (error) {
        console.error('Erro ao controlar luzes:', error);
      }
    },
  },
}
</script>

<style scoped>
h2 {
  text-align: center;
  margin-bottom: 20px;
}
</style>
