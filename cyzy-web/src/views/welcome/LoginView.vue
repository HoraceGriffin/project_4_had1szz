<template>
    <div class="login-wrapper">
        <div style="margin-top: 150px">
            <el-image :src="logoSrc" />
        </div>
        <div style="margin-top: 50px">
            <el-form :model="form" :rules="rules" ref="formRef">
                <el-form-item prop="username">
                    <el-input v-model="form.username" maxlength="10" placeholder="用户名 / 邮箱" :prefix-icon="User" />
                </el-form-item>
                <el-form-item prop="password">
                    <el-input v-model="form.password" type="password" maxlength="20" placeholder="密码"
                        :prefix-icon="Lock" />
                </el-form-item>
                <el-row>
                    <el-col :span="24" style="text-align: left">
                        <el-link type="primary">忘记密码?</el-link>
                    </el-col>
                </el-row>
            </el-form>

            <div style="margin-top: 40px">
                <el-button type="primary" style="width: 100%" plain @click="login(formRef)">立即登录</el-button>
            </div>
            <el-divider content-position="center">
                <el-text type="info">没有账号</el-text>
            </el-divider>
            <div>
                <el-button type="warning" style="width: 100%" plain>立即注册</el-button>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref } from "vue";
import { User, Lock } from "@element-plus/icons-vue";
import logoSrc from '@/icons/logo.png'
import { doLogin } from "@/services/login.js";
import { ElMessage } from "element-plus";
import { useUserStore } from "@/stores/useUserStore.js";
import { useRouter } from "vue-router";

const form = ref({
    username: '',
    password: ''
});
const formRef = ref();
const rules = {
    username: [
        { required: true, message: '请输入用户名', trigger: 'blur' }
    ],
    password: [
        { required: true, message: '请输入密码', trigger: 'blur' }
    ]
}

const userStore = useUserStore();
const router = useRouter();
const login = (formRef) => {
    if (!formRef) return;
    formRef.validate((valid, fields) => {
        if (valid) {
            doLogin(form.value)
                .then(resp => {
                    userStore.storeToken(resp.token);
                    router.push('/index');
                })
                .catch(err => {
                    ElMessage.error(err);
                });
        } else {
            ElMessage.warning("请输入完整表单");
        }
    });
}
</script>

<style scoped>
.login-wrapper {
    text-align: center;
    margin: 0 20px;
}
</style>
