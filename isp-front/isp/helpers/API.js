import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:1026/v2/entities/', // Altere para a porta 1026
    headers: {
        'Content-Type': 'application/json',
        'Fiware-Service': 'openiot',
        'Fiware-ClearServicePath': '/',
        'x-api-key': 'group4'
    },
});



export const ligarLuzes = async (value, dispositivo, attrs) => {
    try {
        console.log("data: ", value);
        const data = [
            {
                attrs:{
                    "value": value,
                    "type": "Text"
                }
            }
        ];

        const response = await api.patch(`${dispositivo}/attrs/`, data);
        console.log("responde: ", response);
        return response.data;
    } catch (error) {
        console.error('Erro ao atualizar o atributo no Orion:', error);
        throw error;
    }
};
