

<script lang="ts" setup>
import { ref, computed,reactive,getCurrentInstance } from "vue"
import {useRoute, useRouter } from "vue-router"
import { ElMessage } from 'element-plus'
import axios from "axios";

import LeftNav from '../views/nav/LeftNav.vue'



</script>

<template>
  <div class="main-container">
    <div class="view">
      <LeftNav></LeftNav>
    </div>
  </div>
</template>


<style scoped>
.main-container {
  margin: auto;
  width: 100%;
  max-width: 1200px;
}

.main-container .view {
  margin-top: 1.66rem;
}
</style>