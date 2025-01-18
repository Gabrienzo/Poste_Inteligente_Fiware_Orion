<template>
  <v-container>
    <v-main style="display: flex; flex-flow: column; gap: 2em;">
    <h1>Dashboard</h1>
    <LightStatus />
    <EnergyConsumption />
    <Alerts />
    <MapView />
    </v-main>
  </v-container>
</template>

<script>
import LightStatus from '@/components/light-status.vue'
import EnergyConsumption from '@/components/energy-consumption.vue'
import Alerts from '@/components/alerts.vue'
import MapView from '@/components/map-view.vue';

export default {
  components: {
    LightStatus,
    EnergyConsumption,
    Alerts,
    MapView,
  },
}
</script>

<style scoped>
h1 {
  text-align: center;
}
</style>
