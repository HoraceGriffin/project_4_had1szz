<script setup>
    import { onBeforeMount, ref, watch } from "vue";
    import { getUploadedList, uploadFile } from "@/services/upload.js";
    import { ElMessage } from "element-plus";
    
    const fileList = ref([]);
    const uploadRef = ref();
    const limit = ref(3);
    const uploadDisable = ref(false);
    const uploadedList = ref([])
    
    const doUpload = (param) => {
        const form = new FormData();
        console.log(param);
        form.append("file", param.file);
        uploadFile(form)
            .then(resp => {
                fileList.value = [];
                ElMessage.success("上传成功");
                fetchUploadedImages();
            })
            .catch(err => {
                ElMessage.error(err);
            });
    }
    
    const fetchUploadedImages = () => {
        getUploadedList()
            .then(resp => {
                uploadedList.value = resp;
            })
            .catch(err => {
                ElMessage.error(err);
            });
    }
    
    
    const handleManualUpload = () => {
        if (uploadRef.value) {
            uploadRef.value.submit();
        }
    }
    
    watch(fileList, () => {
        uploadDisable.value = fileList.value.length >= limit;
    });
    
    onBeforeMount(() => {
        fetchUploadedImages();
    });
</script>

<template>
    <div class="upload-wrapper">
        
        <el-card class="upload-card-item">
            <template #header>
                <el-row :gutter="10" style="margin-bottom: 10px;">
                    <el-col :span="2">
                        <el-text size="large" style="font-weight: bold">上传图片</el-text>
                    </el-col>
                    <el-col :span="4">
                        <el-text>已选择 {{ `${ fileList.length } / ${ limit }` }}</el-text>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="4">
                        <el-button type="primary" @click="handleManualUpload">点击上传</el-button>
                    </el-col>
                </el-row>
            </template>
            
            <el-upload
                name="file"
                ref="uploadRef"
                v-model:file-list="fileList"
                class="upload-demo"
                action=""
                :limit="limit"
                :http-request="doUpload"
                list-type="picture-card"
                accept=".jpeg, .png, .jpg, .bmp"
                multipl
                :auto-upload="false"
                :disabled="uploadDisable"
            >
                <el-button type="primary">Click to upload</el-button>
                <template #tip>
                    <div class="el-upload__tip">
                        点击上传图片, 每次最多选择9张图片, 支持(jpg, jpeg, png, bmp)格式
                    </div>
                </template>
            </el-upload>
        </el-card>
        <el-card class="upload-card-item">
            <template #header>
                <el-text size="large" style="font-weight: bold">
                    已上传图片
                </el-text>
            </template>
            <div class="grid-box">
                <div v-for="item in uploadedList">
                    <el-image style="aspect-ratio: 16/9;" :src="`http://localhost:12000/${item}`" fit="contain"/>
                    <el-text>
                        {{ item }}
                    </el-text>
                </div>
            </div>
        </el-card>
    </div>
</template>

<style scoped lang="scss">
    .upload-wrapper {
        
        display: grid;
        grid-template-columns: 1fr;
        row-gap: 20px;
        
        .grid-box {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            column-gap: 30px;
            row-gap: 20px;
        }
        
    }
</style>
