<template>
  <v-card>
    <v-card-title>Consumo de Energia</v-card-title>
    <v-card-text>
      <p>Consumo Atual: {{ consumption }} kWh</p>
    </v-card-text>
  </v-card>
</template>

<script>
export default {
  data() {
    return {
      consumption: 120, // Example value
    }
  },
}
</script>
