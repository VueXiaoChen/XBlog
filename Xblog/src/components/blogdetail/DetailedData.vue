<script lang="ts" setup>
import { ref, computed,reactive,getCurrentInstance,onMounted } from "vue"
import {useRoute, useRouter } from "vue-router"
import { ElMessage } from 'element-plus'
import axios from "axios";
const router:any = useRouter()


const blog = ref({
    userLike:5,
    likesCount:10,
    userCollect:15,
    collectCount:20
})

function setLikes(){

}

function setCollect(){

}

onMounted(()=>{
   
})
</script>

<template>
    <div class="DetailedData-card">
        <span style="margin-right: 20px; cursor: pointer;" @click="setLikes" :class="{ 'active' : blog.userLike }"><el-icon><Camera /></el-icon>{{ blog.likesCount }}</span>
        <span style=" cursor: pointer" @click="setCollect" :class="{ 'active' : blog.userCollect }"><el-icon><Camera /></el-icon> {{ blog.collectCount }}</span>
    </div>
</template>


<style scoped>
.DetailedData-card {
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.1);
    margin-bottom: 10px;
    text-align: center;
    font-size: 20px;
    color: #666;
    margin-bottom: 10px
}
.DetailedData-card .el-icon{
    top:2px;
}
</style>