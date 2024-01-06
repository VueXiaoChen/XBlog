
<script lang="ts" setup>
import { ref, computed,reactive,getCurrentInstance,onMounted } from "vue"
import {useRoute, useRouter } from "vue-router"
import { ElMessage } from 'element-plus'
import axios from "axios";
const router:any = useRouter()

function refreshTop(){

}

let showList:any = ref(
    [
        {
            id:1,
            index:1,
            title:"woshishui"
        },
        {
            id:2,
            index:2,
            title:"thfghfhfhfghf"
        },
        {
            id:3,
            index:3,
            title:"个人体验绕太阳意图天浴天浴天浴"
        },
        {
            id:4,
            index:4,
            title:"测试的内容看看"
        },
    ]
)

async function GetArticleRanking(){
    await axios.get("/api/blog/readcountlist?readCount=5&page=1&size=20").then(res=>{
    //console.log(res.data.data);
    showList.value= res.data.data.list
    for(let i=0;i<showList.value.length;i++){
        showList.value[i].index=i+1
    }
  })
}

function BlogJump(blogid){
  sessionStorage.setItem("blogid",blogid)
  router.push({name:'BlogDetail'})
}

onMounted(()=>{
    //console.log(leftcard.value.navid);
    GetArticleRanking()
})
</script>

<template>
    <div class="ArticleRanking-card">
        <div style="display: flex; align-items: center; padding-bottom: 10px; border-bottom: 1px solid #ddd">
            <div style="font-size: 20px; flex: 1">文章榜单</div>
            <div style="font-size: 12px; color: #666; cursor: pointer;" @click="refreshTop"><i class="el-icon-refresh"></i>换一换</div>
        </div>
        <div>
            <el-scrollbar height="240px">
            <div v-for="(item,index) in showList" :key="item.id" style="margin: 15px 0" class="line1">
                <div @click="BlogJump(item.id)">
                    <span style="width: 18px; display: inline-block; text-align: right; margin-right: 10px">
                        <span style="color: orangered" v-if="item.index === 1">{{ item.index }} : </span>
                        <span style="color: goldenrod" v-else-if="item.index === 2">{{ item.index }} : </span>
                        <span style="color: dodgerblue" v-else-if="item.index === 3">{{ item.index }} : </span>
                        <span style="color: #666" v-else>{{ item.index }} : </span>
                    </span>
                    <span class="ArticleRanking-title">{{ item.title }} : </span>
                </div>
            </div>
            </el-scrollbar>
        </div>
    </div>
</template>


<style scoped>
.ArticleRanking-card {
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.1);
    margin-bottom: 10px;
    max-height: 310px;
    overflow-y: hidden;
}
.ArticleRanking-card .line1{
    margin: 15px 0px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}
.ArticleRanking-title{
    color: #666;
}
.ArticleRanking-title:hover {
  /* color: #2a60c9; */
  cursor: pointer;
  color: red;
  
}
</style>