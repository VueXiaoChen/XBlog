<script lang="ts" setup>
import { ref, computed,reactive,getCurrentInstance,onMounted } from "vue"
import {useRoute, useRouter } from "vue-router"
import { ElMessage } from 'element-plus'
import axios from "axios";
const router:any = useRouter()


const recommendList = ref(
    [
    {
            id:1,
            title:"我是谁啊，你是谁啊23424324234234234324324324324我是谁啊，你是谁啊23424324234234234324324324324我是谁啊，你是谁啊23424324234234234324324324324",
            readCount:1,
            likesCount:1,
        },
        {
            id:2,
            title:"我是谁啊，你是谁啊23423423424234",
            readCount:1,
            likesCount:1,
        },
        {
            id:3,
            title:"我是谁啊，你是谁啊",
            readCount:1,
            likesCount:1,
        },
        {
            id:4,
            title:"我是谁啊，你是谁啊",
            readCount:1,
            likesCount:1,
        },
    ]
)
onMounted(()=>{
   
})
</script>

<template>
    <div class="Recommend-card" style="margin-bottom: 10px">
        <div
            style="font-weight: bold; font-size: 20px; padding-bottom: 10px; border-bottom: 1px solid #ddd; margin-bottom: 10px">
            相关推荐</div>
        <div>
            <div style="margin-bottom: 15px" v-for="item in recommendList" :key="item.id">
                <a :href="'/front/blogDetail?blogId=' + item.id" target="_blank">
                    <div class="recommend-title line2">{{ item.title }}</div>
                </a>
                <div style="color: #888">
                    <span>阅读</span> <span>{{ item.readCount }}</span>
                    <span style="margin-left: 10px">点赞</span> <span>{{ item.likesCount }}</span>
                </div>
            </div>
        </div>
    </div>
</template>


<style scoped>
.Recommend-card {
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.1);
    margin-bottom: 10px;
}

.recommend-title {
    margin-bottom: 5px;
}

.recommend-title:hover{
    color: #2a60c9;
}

.line2 {
    word-break: break-all;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
    overflow: hidden;
}</style>