

<script lang="ts" setup>
import { ref, computed,reactive,getCurrentInstance } from "vue"
import {useRoute, useRouter } from "vue-router"
import { ElMessage } from 'element-plus'
import axios from "axios";
import { Search } from '@element-plus/icons-vue'



const activeIndex=ref(1)
const Searchvalue = ref()
function handleSelect(){

}

</script>

<template>
    <div class="main-header-box">
        <div class="main-header">
            <div class="container">
                <a href="/" class="logo">
                    <img src="//lf3-cdn-tos.bytescm.com/obj/static/xitu_juejin_web/e08da34488b114bd4c665ba2fa520a31.svg"
                        alt="小陈博客" class="logo-img">
                    <img src="//lf3-cdn-tos.bytescm.com/obj/static/xitu_juejin_web/6c61ae65d1c41ae8221a670fa32d05aa.svg"
                        alt="小陈博客" class="mobile">
                </a>
                <div class="nav">
                    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
                        <el-menu-item index="1">测试2</el-menu-item>
                        <el-menu-item index="2">测试3</el-menu-item>
                        <el-menu-item index="3">测试4</el-menu-item>
                        <el-menu-item index="4">测试5</el-menu-item>
                        <el-menu-item index="5">测试6</el-menu-item>
                        <el-menu-item index="6">测试7</el-menu-item>
                        <el-menu-item index="7">测试8</el-menu-item>
                        <el-menu-item index="8">测试9</el-menu-item>
                    </el-menu>
                </div>
                <div class="Search">
                    <el-input v-model="Searchvalue" class="w-50 m-2" size="large" placeholder="Please Input"
                        :prefix-icon="Search" />
                </div>
                <div class="Search-btn">
                    <el-button type="primary">搜索</el-button>
                </div>
                <div class="login-btn">
                    <el-button type="primary">注销</el-button>
                </div>
                
            </div>
        </div>
    </div>
</template>


<style  scoped>
.main-header-box {
    position: relative;
    height: 5rem;
}

.main-header {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    transition: transform .2s;
}

.main-header {
    background: #fff;
    box-shadow: 0 2px 8px;
    color: #909090;
    height: 5rem;
    z-index: 250;
}

.main-header .container {
    margin: auto;
    max-width: 1440px;
}

.container {
    position: relative;
    width: 100%;
    display: flex;
    align-items: center;
    height: 100%;
}

.main-header-box .logo {
    margin-right: 1rem;
    margin-left: 24px;
    display: inline-block;
    height: 22px;
    width: auto;
    /* padding: 1.58rem 0 1.48rem; */
}

.main-header-box a {
    text-decoration: none;
    cursor: pointer;
    color: #909090;
    background-color: transparent;
}

.main-header-box .logo-img {
    display: block;
    width: 107px;
    height: 22px;
}

.main-header-box .mobile {
    display: none;
    width: 31px;
}

.main-header-box img {
    border-style: none;
    overflow-clip-margin: content-box;
    overflow: clip;
}

.main-header-box :deep(.el-sub-menu) {
    display: none;
}

.main-header-box .nav {
    height: 100%;
    flex: 1 0 auto;
    line-height: normal;
}

.main-header-box .el-menu {
    display: flex;
    align-items: center;
    justify-content:space-around;
    position: relative;
    flex-direction: row-reverse;
    height: 100%;
    margin: 0;
}
.main-header-box .el-button{
    margin-left: 20px;
}
</style>