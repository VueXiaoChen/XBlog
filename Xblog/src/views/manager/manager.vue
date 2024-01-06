<script lang="ts" setup>
import { ref, computed } from "vue"
import {useRoute, useRouter } from "vue-router"

const router:any = useRouter()

let user:any =  ref(JSON.parse(localStorage.getItem('xm-user') || '{}'))


function updateUser(){
    user.value = JSON.parse(localStorage.getItem('xm-user') || '{}')
}

function goToPerson(){
    if(user.role==='ADMIN'){
        router.push({ path: "/adminPerson" })
    }
}

function logout(){
    localStorage.removeItem('xm-user')
    router.push({ path: "/login" })
}
</script>

<template>
    <div class="manager-container">
        <!--  头部  -->
        <div class="manager-header">
            <div class="manager-header-left">
                <img src="../assets/imgs/logo.png" />
                <div class="title">后台管理系统</div>
            </div>

            <div class="manager-header-center">
                <el-breadcrumb separator-class="el-icon-arrow-right">
                    <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
                    <!-- <el-breadcrumb-item :to="{ path: router.currentRoute.path }">{{ router.currentRoute.meta.name }}</el-breadcrumb-item> -->
                </el-breadcrumb>
            </div>

            <div class="manager-header-right">
                <el-dropdown placement="bottom">
                    <div class="avatar">
                        <img :src="user.avatar || 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png'" />
                        <div>{{ user.name || '管理员' }}</div>
                    </div>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item @click.native="goToPerson">个人信息</el-dropdown-item>
                        <el-dropdown-item @click.native="router.push('/password')">修改密码</el-dropdown-item>
                        <el-dropdown-item @click.native="logout">退出登录</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
            </div>
        </div>

        <!--  主体  -->
        <div class="manager-main">
            <!--  侧边栏  -->
            <div class="manager-main-left">
                <el-menu :default-openeds="['info', 'user']" router style="border: none" :default-active="router.currentRoute.path">
                    <el-menu-item index="/home">
                        <i class="el-icon-s-home"></i>
                        <span slot="title">系统首页</span>
                    </el-menu-item>
                    <el-submenu index="info">
                        <template slot="title">
                            <i class="el-icon-menu"></i><span>信息管理</span>
                        </template>
                        <el-menu-item index="/category">博客分类</el-menu-item>
                        <el-menu-item index="/blog">博客信息</el-menu-item>
                        <el-menu-item index="/activity">活动信息</el-menu-item>
                        <el-menu-item index="/comment">评论信息</el-menu-item>
                        <el-menu-item index="/activitySign">活动报名</el-menu-item>
                        <el-menu-item index="/notice">公告信息</el-menu-item>
                    </el-submenu>

                    <el-submenu index="user">
                        <template slot="title">
                            <i class="el-icon-menu"></i><span>用户管理</span>
                        </template>
                        <el-menu-item index="/admin">管理员信息</el-menu-item>
                        <el-menu-item index="/user">用户信息</el-menu-item>
                    </el-submenu>
                </el-menu>
            </div>

            <!--  数据表格  -->
            <div class="manager-main-right">
                <router-view @update:user="updateUser" />
            </div>
        </div>
    </div>
</template>

<style scoped>
.manager-container {
    background-color: #f8f8ff;
    min-height: 100vh;
}

.manager-header {
    display: flex;
    background-color: #0066bc;
}

.manager-header-left {
    width: 200px;
    height: 60px;
    padding-left: 10px;
    display: flex;
    align-items: center
}

.manager-header-left img {
    width: 40px;
    height: 40px;
}

.manager-header-left .title {
    flex: 1;
    margin-left: 5px;
    font-size: 20px;
    font-weight: bold;
    color: #eee
}

.manager-header-center {
    flex: 1;
    width: 0;
    display: flex;
    align-items: center
}

.manager-header-right {
    width: 200px;
    display: flex;
    align-items: center;
    justify-content: flex-end;
}

.manager-header-right .avatar {
    display: flex;
    align-items: center;
    padding-right: 10px;
    color: #eee;
    cursor: default
}

.manager-header-right .avatar img {
    width: 40px;
    height: 40px;
    border-radius: 50%;
    margin-right: 5px
}

.manager-main {
    display: flex;
}

.manager-main-left {
    width: 200px;
    min-height: calc(100vh - 60px);
    box-shadow: 0 0 6px rgba(0, 21, 41, .35);
}

.manager-main-right {
    flex: 1;
    width: 0;
    padding: 10px;
}

.manager-main-right .search {
    padding: 10px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.1);
}

.manager-main-right .operation {
    margin-top: 5px;
    padding: 10px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.1)
}

.manager-main-right .table {
    margin-top: 5px;
    padding: 15px 10px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
}

.manager-main-right .table .pagination {
    margin-top: 10px;
}

/* ElementUI */
.el-menu {
    width: 200px;
    height: 100%;
    background-color: #00162a;
}

.el-submenu__title {
    color: #ddd;
    background-color: #011223 !important;
    height: 50px;
    line-height: 50px;
}

.el-menu-item {
    color: #fff;
    height: 50px;
    line-height: 50px;
    background-color: #000b17 !important; /* 必须加上这个背景色，否则鼠标离开会出现白色 */
}

.el-menu-item i {
    color: #fff !important;
}

.el-menu-item.is-active {
    background-color: #1890ff !important;
    color: #fff;
}

.el-menu--inline .el-menu-item {
    padding-left: 50px !important;
}

.el-menu .is-active {
    color: #fff !important;
}

.el-submenu__title:hover {
    /*background-color: #222 !important;*/
}

.el-menu-item:not(.is-active):hover {
    /*background-color: #0376bf !important;*/
    /*color: #fff;*/
}

.el-menu-item:hover {
    color: #fff !important;
    background-color: #46a6ff !important;
}

.el-submenu__icon-arrow {
    color: #ddd !important;
    margin-top: -5px;
}

.el-breadcrumb__inner {
    color: #eee !important;
}

.el-dropdown-menu {
    margin-top: 20px !important;
}

.el-breadcrumb {
    margin-left: 10px;
}

th.el-table__cell {
    background-color: #f8f8f8 !important;
    color: #666;
}

</style>
