import { http } from "@/utils/http.js";
import { useUserStore } from "@/stores/useUserStore.js";

export function uploadFile(data) {
    return http({
        url: "/upload",
        method: "post",
        data: data,
        headers: {
            "Content-Type": "multipart/form-data",
        },
    });
}

export function getUploadedList() {
    return http({
        url: "/upload/list",
        method: 'get'
    });
}
