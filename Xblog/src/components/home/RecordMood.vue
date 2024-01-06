

<script lang="ts" setup>
import { ref, computed,reactive,getCurrentInstance } from "vue"
import {useRoute, useRouter } from "vue-router"
import { ElMessage } from 'element-plus'
import axios from "axios";
const router:any = useRouter()


</script>

<template>
    <div class="RecordMood-card">
        <div style="font-size: 20px; font-weight: bold; margin-bottom: 10px">欢迎您！😊</div>
        <a href="/front/person">
            <div style="color: #666">写下博客记录美好的一天</div>
        </a>
    </div>
</template>


<style scoped>
.RecordMood-card{
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.1);
    margin-bottom: 10px
}
.RecordMood-card a{
    color: #333;
    text-decoration: none;
}
</style>