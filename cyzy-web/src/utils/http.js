import axios from "axios";
import { useUserStore } from "@/stores/useUserStore.js";
import { useRouter } from "vue-router";
import { ElMessage } from "element-plus";


const baseUrl = 'http://localhost:12000';
const router = useRouter();
const userStore = useUserStore();
const axiosInstance = axios.create({
    baseURL: baseUrl,
    timeout: 5000,
    headers: {
        "Authorization": userStore.getToken() | null
    }
});

axiosInstance.interceptors.request.use((req) => {
    req.headers.Authorization = `Bearer ${userStore.getToken()}`;
    return req;
});


axiosInstance.interceptors.response.use((resp) => {
    const data = resp.data;
    if (!data.success) {
        return data;
    }

    if (data.code === 401) {
        router.push('/login');
        return data;
    }

    return data.data;
}, err => {
    ElMessage.error(err);
});

export const http = (options) => {
    return axiosInstance.request({
        ...options
    });
}
