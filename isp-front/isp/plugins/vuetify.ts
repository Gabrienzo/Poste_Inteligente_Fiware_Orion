// plugins/vuetify.js
import '@mdi/font/css/materialdesignicons.css'
import 'vuetify/styles'
import { createVuetify } from 'vuetify'

export default defineNuxtPlugin((app) => {
    const vuetify = createVuetify({
        theme: {
            defaultTheme: 'dark', // Define o tema padrão
            themes: {
                light: {
                    colors: {
                        primary: '#1976D2', // Cor primária
                        secondary: '#424242', // Cor secundária
                        accent: '#82B1FF', // Cor de destaque
                        error: '#FF5252', // Cor de erro
                        info: '#2196F3', // Cor de informações
                        success: '#4CAF50', // Cor de sucesso
                        warning: '#FB8C00', // Cor de aviso
                    },
                },
                dark: {
                    colors: {
                        primary: '#1E1E1E', // Cor primária no tema escuro
                        secondary: '#424242',
                        accent: '#82B1FF',
                        error: '#FF5252',
                        info: '#2196F3',
                        success: '#4CAF50',
                        warning: '#FB8C00',
                    },
                },
            },
        },
    })

    app.vueApp.use(vuetify)
})
