<script lang="ts" setup>
import { ref, computed,reactive,getCurrentInstance,onMounted,watch } from "vue"
import {useRoute, useRouter } from "vue-router"
import { ElMessage } from 'element-plus'
import axios from "axios";
const router:any = useRouter()


const blog:any = ref({
    user:{
        avatar:"234324",
        name:"234324",
        info:"234324",
        blogCount:"234324",
        likesCount:"234324",
        collectCount:"444"
    }
})
const userId = ref(sessionStorage.getItem('userid'))
//用户的总文章数
const usertotal = ref(0)
//用户的点赞数
const userlike = ref(0)
//用户的收藏数
const usercollect = ref(0)

async function GetUserBlogInformation(userid){
    axios.get("/api/blog/list?userId="+userid).then(res=>{
        usertotal.value = res.data.data.total
    })
}


//监听nav的变化值获取数据
watch(
  () => userId.value,
    (val, oldVal) => {
      if(userId.value){
        GetUserBlogInformation(userId.value)
      }
    },
    {
        immediate: true,
    }
);
onMounted(()=>{
   
})
</script>

<template>
    <div class="ArticleInformation-card" style="margin-bottom: 10px">
        <div style="display: flex; align-items: center; grid-gap: 10px; margin-bottom: 10px">
            <img :src="blog.user?.avatar" alt="" style="width: 50px; height: 50px; border-radius: 50%">
            <div style="flex: 1;">
                <div style="font-weight: bold; margin-bottom: 5px">{{ blog.user?.name }}</div>
                <div style="color: #666; font-size: 13px" class="line2">{{ blog.user?.info }}</div>
            </div>
        </div>
        <div style="display: flex">
            <div style="flex: 1; text-align: center">
                <div style="margin-bottom: 5px">文章</div>
                <div style="color: #888">{{ usertotal}}</div>
            </div>
            <div style="flex: 1; text-align: center">
                <div style="margin-bottom: 5px">点赞</div>
                <div style="color: #888">{{ blog.user?.likesCount }}</div>
            </div>
            <div style="flex: 1; text-align: center">
                <div style="margin-bottom: 5px">收藏</div>
                <div style="color: #888">{{ blog.user?.collectCount }}</div>
            </div>
        </div>
    </div>
</template>


<style scoped>
.ArticleInformation-card{
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.1);
    margin-bottom: 10px;
}
</style>