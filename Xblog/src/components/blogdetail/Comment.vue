<script lang="ts" setup>
import { ref, computed,reactive,getCurrentInstance,onMounted } from "vue"
import {useRoute, useRouter } from "vue-router"
import { ElMessage } from 'element-plus'
import axios from "axios";
const router:any = useRouter()


const commentCount = ref('')
const commentContent = ref('')
function addComment(){

}

onMounted(()=>{
   
})
</script>

<template>
    <!--  评论开始  -->
    <div class="Comment-card">
        <h2 style="margin-bottom: 20px">评论 {{ commentCount }}</h2>
        <div style="margin-bottom: 20px">
            <el-input type="textarea" placeholder="请输入评论内容" v-model="commentContent"></el-input>
            <div style="text-align: right; margin-top: 5px">
                <el-button type="primary" @click="addComment">评 论</el-button>
            </div>
        </div>
    </div>
    <!--  评论结束  -->
</template>


<style scoped>
.Comment-card{
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.1);
    margin-bottom: 10px;
}
</style>