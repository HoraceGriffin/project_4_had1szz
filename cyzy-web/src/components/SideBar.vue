<script setup>
    import { Document } from "@element-plus/icons-vue";
    import { ref } from "vue";
    import logoSrc from "@/icons/logo.png";
    
    const isCollapse = ref(false);
</script>

<template>
    <el-row justify="center" style="background-color: #545c64">
        <el-col :span="10"/>
        <el-col :span="4" style="padding: 20px 0;">
            <el-avatar :size="50" shape="circle" :src="logoSrc"/>
        </el-col>
        <el-col :span="10"/>
    </el-row>
    <el-menu
        text-color="#fff"
        active-text-color="#ffd04b"
        background-color="#545c64"
        style="border: 0"
        default-active="1"
        class="el-menu-vertical"
        :collapse="isCollapse"
        router
    >
        <el-menu-item index="/upload">
            <el-icon>
                <Document/>
            </el-icon>
            <span>上传文件</span>
        </el-menu-item>
    </el-menu>
</template>

<style scoped>
    .el-menu-vertical {
        padding: 0;
        margin: 0;
        height: 100%;
    }
</style>
