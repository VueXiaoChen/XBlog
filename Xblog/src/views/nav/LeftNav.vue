

<script lang="ts" setup>
import { ref, computed,reactive,getCurrentInstance } from "vue"
import {useRoute, useRouter } from "vue-router"
import { ElMessage } from 'element-plus'
import axios from "axios";
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from '@element-plus/icons-vue'

const isCollapse = ref(true)
const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}


</script>

<template>
    <div class="left-nav">
      <el-scrollbar height="700px">
            <el-menu default-active="2" class="el-menu-vertical-demo"  @open="handleOpen"
                @close="handleClose">
                <el-menu-item :index=index v-for="(item,index) in 8" :key="item">
                    <el-icon><icon-menu /></el-icon>
                    <template #title>Navigator Two</template>
                </el-menu-item>
            </el-menu>
        </el-scrollbar>
    </div>
</template>


<style scoped>
.left-nav {
    width: 180px;
    position: -webkit-sticky;
    position: sticky;
    top: 80px;
    margin-right: 20px;
    height: -webkit-fit-content;
    height: -moz-fit-content;
    height: fit-content;
    border-radius: 4px;
    background-color: #fff;
    max-height: calc(100vh - 101px);
    overflow-x: hidden;
}
</style>