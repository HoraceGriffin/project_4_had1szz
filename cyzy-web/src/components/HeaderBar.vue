<script setup>
import { useDark, useToggle } from '@vueuse/core';
import logoSrc from '@/icons/logo.png';
const isDark = useDark();
const toggleDark = useToggle(isDark);
</script>

<template>
    <div class="outer-wrapper">
        <el-menu style="margin: 10px 0;" mode="horizontal" :ellipsis="false" >
            <div class="flex-grow"></div>
            <el-menu-item index="1">
                <el-popover placement="bottom" width="auto" trigger="hover">
                    <template #reference>
                        设置
                    </template>
                    <el-switch inactive-text="主题切换" v-model="isDark" @change="toggleDark" />
                </el-popover>
            </el-menu-item>
        </el-menu>
    </div>
</template>

<style scoped>
.flex-grow {
    flex-grow: 1;
}
</style>
