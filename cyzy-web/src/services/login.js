import { http } from "@/utils/http.js";

export function doLogin(data) {
    return http({
        method: 'post',
        url: '/users/login',
        data: data
    });
}
