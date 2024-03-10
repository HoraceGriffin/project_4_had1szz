<script setup>
    import HeaderBar from '@/components/HeaderBar.vue';
    import SideBar from "@/components/SideBar.vue";
</script>


<template>
    <el-container style="height: 100vh;">
        <el-aside style="height: 100%; overflow: hidden; border-right: solid 1px var(--el-menu-border-color);">
            <SideBar/>
        </el-aside>
        <el-container class="no-padding">
            <el-header class="header no-padding">
                <HeaderBar/>
            </el-header>
            
            <el-main style="margin: 10px 0;">
                <RouterView style="margin: 0 auto;"/>
            </el-main>
        </el-container>
    </el-container>
</template>



<style scoped>
    .no-padding {
        padding: 0;
    }
    
    .no-margin {
        margin: 0;
    }
</style>
