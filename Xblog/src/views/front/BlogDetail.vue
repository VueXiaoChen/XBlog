<script lang="ts" setup>
import { ref, computed,reactive,getCurrentInstance } from "vue"
import {useRoute, useRouter } from "vue-router"
import { ElMessage } from 'element-plus'
import axios from "axios";
import Blog from "../../components/blogdetail/Blog.vue";
import DetailedData from "../../components/blogdetail/DetailedData.vue";
import Comment from "../../components/blogdetail/Comment.vue";
import ArticleInformation from "../../components/blogdetail/ArticleInformation.vue";
import Recommend from "../../components/blogdetail/Recommend.vue";

const router:any = useRouter()



</script>

<template>
    <div class="main-content">
        <div style="display: flex; grid-gap: 10px">
            <div style="flex: 1; width: 0">
                <Blog></Blog>
                <DetailedData></DetailedData>
                <Comment></Comment>
            </div>
            <div style="width: 260px">
                <ArticleInformation></ArticleInformation>
                <Recommend></Recommend>
            </div>
        </div>
    </div>
</template>


<style scoped></style>