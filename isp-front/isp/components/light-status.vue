<template>
  <v-card>
    <v-card-title>Status da Luz</v-card-title>
    <v-card-text>
      <v-switch v-model="lightsOn" :color="lightsOn ? 'accent':''" label="Luzes Ligadas/Desligadas"></v-switch>
      <span>Status: <p class="v-label"> {{ lightsOn ? 'Ligado' : 'Desligado' }}</p></span>
    </v-card-text>
  </v-card>
</template>

<script>
export default {
  data() {
    return {
      lightsOn: false,
    }
  },
}
</script>
