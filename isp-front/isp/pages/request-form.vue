<template>
  <v-container>
    <h2>Solicitação de Emergência</h2>
    <v-form>
      <v-text-field label="Nome" v-model="name" required></v-text-field>
      <v-text-field label="Localização" v-model="location" required></v-text-field>
      <v-btn color="red" @click="sendRequest">Enviar Solicitação</v-btn>
    </v-form>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      name: '',
      location: '',
    };
  },
  methods: {
    sendRequest() {
      // Enviar a solicitação para o backend
      alert(`Solicitação de ${this.name} enviada com sucesso!`);
    },
  },
};
</script>
