<template>
  <v-card>
    <v-card-title>Alertas de Segurança</v-card-title>
    <v-card-text>
      <ul style="padding: 0 1em">
        <li v-for="(alert, index) in alerts" :key="index">{{ alert }}</li>
      </ul>
    </v-card-text>
  </v-card>
</template>

<script>
export default {
  data() {
    return {
      alerts: [
        'Lâmpada apagada no Setor 3',
        'Botão de emergência pressionado no Setor 7',
        'Consumo de energia elevado no Setor 2',
      ],
    }
  },
}
</script>
