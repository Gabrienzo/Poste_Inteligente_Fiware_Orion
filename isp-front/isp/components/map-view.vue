<template>
  <v-card>
    <v-card-title>Visão do Mapa</v-card-title>
    <v-card-text>
      <LMap
          style="height: 400px; width: 100%"
      :zoom="zoom"
      :center="center"
      :use-global-leaflet="false"
      >
      <LTileLayer
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          attribution="&copy; OpenStreetMap contributors"
      />
      </LMap>
    </v-card-text>
  </v-card>
</template>

<script setup>
const zoom = 13;
const center = [-5.79448, -35.211];
</script>

<style scoped>

</style>
