<script setup>
import { useRouter } from "vue-router";

const router = useRouter();
router.push({ name: 'login-view' });
</script>

<template>
    <div class="box">
        <div class="left-box">
            <el-image style="width: 100%;height: 100%" fit="cover"
                src="https://img1.baidu.com/it/u=4097856652,4033702227&fm=253&fmt=auto&app=120&f=JPEG?w=1422&h=800" />
        </div>
        <div class="welcome-slogan">
            <p>
                <el-text type="primary" style="font-size: var(--el-font-size-large);">
                    欢迎使用校园综合交流平台
                </el-text>
            </p>
            <p>
                <el-text style="color: gainsboro">
                    福州大学至诚学院 2022级软件工程 Horace Leoi
                </el-text>
            </p>
        </div>
        <div class="right-box">
            <RouterView />
        </div>
    </div>
</template>

<style scoped>
.welcome-slogan {
    position: absolute;
    bottom: 30px;
    left: 30px;
    text-shadow: 0 0 10px black;
}

.box {
    width: 100vw;
    height: 100vh;
    overflow: hidden;
    display: flex;
    user-select: none;
}

.left-box {
    flex: 1;
}

.right-box {
    width: 400px;
    z-index: 1;
    background: white;
}
</style>
