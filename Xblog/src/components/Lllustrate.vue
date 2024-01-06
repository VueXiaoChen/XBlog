<script lang="ts" setup>
import { ref, computed,reactive,getCurrentInstance } from "vue"
import {useRoute, useRouter } from "vue-router"
import { ElMessage } from 'element-plus'
import axios from "axios";
const router:any = useRouter()





</script>

<template>
    <div class="Lllustrate-card">
        <div>举报邮箱： 455664949@qq.com</div>
        <div>座机电话： 010-123456789</div>
        <div>京ICP备888888©2024 哇水水啊啊</div>
    </div>
</template>


<style scoped>
.Lllustrate-card {
    line-height: 30px;
    color: #666;
    padding: 0 10px
}
</style>