import axios from "axios";
import { competitor } from "../interfaces/competitor-interface";

const api = axios.create({
    baseURL: import.meta.env.VITE_API_URL + '/competitors'
})

export const useApi = () => ({
    getCompetitors: async (): Promise<Array<competitor>> => {
        const response = await api.get('');
        return response.data;
    },
    getWeights: async () => {
        const response = await api.get('/weights');
        return response.data;
    },
    setCompetitor: async (nome: string, provas: number, lumosity: number, keybr: number) => {
        const response = await api.post('/update', {nome, provas, lumosity, keybr});
        return response.data;

    },
    setWeights: async (provas: number, lumosity: number, keybr: number) => {
        const response = await api.post('/weights', {provas, lumosity, keybr});
        return response.data;

    }
});