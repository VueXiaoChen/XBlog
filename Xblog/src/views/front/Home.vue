

<script lang="ts" setup>
import { ref, computed,reactive,getCurrentInstance,onMounted,watch} from "vue"
import {useRoute, useRouter } from "vue-router"
import { ElMessage } from 'element-plus'
import axios from "axios";
import Footer from "../../components/Footer.vue";
import BlogList from "../../components/home/BlogList.vue";
import LeftCard from "../../components/home/LeftCard.vue";
import RecordMood from "../../components/home/RecordMood.vue";
import ArticleRanking from "../../components/home/ArticleRanking.vue";
import RelatedArticles from "../../components/home/RelatedArticles.vue";

import Lllustrate from "../../components/Lllustrate.vue";


const router:any = useRouter()

const showList:any = ref('')

const topActivityList:any = ref('')

const current =ref('')

function refreshTop(){

}

const blogListRef = ref()
const leftcard = ref()
const navid:any = ref(1)
//子组件的方法赋值
const GetNavId = (navids) => {
    navid.value = navids;
};
// watch(
//   () => leftcard.value,
//     (val, oldVal) => {
//         console.log(val);
        
//     },
//     {
//         immediate: true,
//     }
// );

onMounted(()=>{
    //console.log(leftcard.value.navid);
})

</script>
<template>
    <div class="main-content">
        <div style="display: flex; align-items: flex-start; grid-gap: 10px">
            <LeftCard ref="leftcard" @GetNavId="GetNavId"></LeftCard>
            <div style="flex:1;">
                <BlogList  ref="blogListRef" :navid="navid"/>
                <Footer></Footer>
            </div>
            <div style="width: 260px">
                <RecordMood></RecordMood>
                <ArticleRanking></ArticleRanking>
                <RelatedArticles :navid="navid"></RelatedArticles>
                <Lllustrate></Lllustrate>
            </div>
        </div>
    </div>
</template>


<style scoped>

</style>