

<script lang="ts" setup>
import { ref, computed,reactive,getCurrentInstance,onMounted} from "vue"
import {useRoute, useRouter } from "vue-router"
import { ElMessage } from 'element-plus'
import axios from "axios";
import Home from "../views/front/Home.vue"

const router:any = useRouter()
const user:any = ref(JSON.parse(localStorage.getItem("xm-user") || '{}')) 
const top= ref('')
const title = ref("")
// console.log(router.currentRoute._value.path);

function goSearch(){

}
function logout(){

}
function updateUser(){

}


onMounted(()=>{
  
   
})


</script>

<template>
  <div>
    <div class="front-notice"><i class="el-icon-bell" style="margin-right: 2px"></i>公告：{{ top }}</div>
    <!--头部-->
    <div class="front-header">
      <div class="front-header-left">
        <img src="../assets/imgs/广告.png" alt="">
        <div class="title">博客论坛平台</div>
      </div>
      <div class="front-header-center">
        <div class="front-header-nav">
          <el-menu :default-active="router.currentRoute._value.path" mode="horizontal" router>
						<el-menu-item index="/front/home">首页</el-menu-item>
						<el-menu-item index="/front/activity">活动中心</el-menu-item>
						<el-menu-item index="/front/person">个人中心</el-menu-item>
          </el-menu>
        </div>
      </div>
      <div>
        <el-input style="width: 260px; margin-right: 10px" placeholder="请输入关键字搜索" v-model="title" clearable></el-input>
        <el-button type="success" @click="goSearch">搜 索</el-button>
      </div>
      <div class="front-header-right">
        <div v-if="!user.username">
          <el-button @click="router.push('/login')">登录</el-button>
          <el-button @click="router.push('/register')">注册</el-button>
        </div>
        <div v-else>
          <el-dropdown>
            <div class="front-header-dropdown">
              <img :src="user.avatar" alt="">
              <div style="margin-left: 10px; color: #fff">
                <span>{{ user.name }}</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
              </div>
            </div>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>
                <div style="text-decoration: none" @click="logout">退出</div>
              </el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </div>
    </div>
    <!--主体-->
    <div class="main-body">
      <router-view ref="child"/>
      <!-- <Home></Home> -->
    </div>
  </div>
</template>


<style scoped>
@import "../assets/css/front.css";
</style>