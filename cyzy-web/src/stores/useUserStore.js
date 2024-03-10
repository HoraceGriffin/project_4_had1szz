import { ref } from "vue";
import { defineStore } from "pinia";

export const useUserStore = defineStore("userStore", () => {
    const TOKEN_STORE_KEY = "__TOKEN__";
    const storeToken = (token) => {
        localStorage.setItem(TOKEN_STORE_KEY, token);
    };

    const removeToken = () => {
        localStorage.removeItem(TOKEN_STORE_KEY);
    };

    const getToken = () => {
        return localStorage.getItem(TOKEN_STORE_KEY);
    };

    return {storeToken, removeToken, getToken};
});
