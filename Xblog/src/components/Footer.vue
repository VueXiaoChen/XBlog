<script lang="ts" setup>
import { ref, computed,reactive,getCurrentInstance } from "vue"
import {useRoute, useRouter } from "vue-router"
import { ElMessage } from 'element-plus'
import axios from "axios";
const router:any = useRouter()





</script>



<template>
  <div class="foot">
    <div>京ICP备666888999 ©版权所有 小陈@大海</div>
    <div> 公司地址：小陈 | 公司座机：0551-666666666</div>
  </div>
</template>



<style scoped>
.foot {
  font-size: 16px;
  padding: 20px 0;
  text-align: center;
  line-height: 30px;
  color: #666;
}</style>