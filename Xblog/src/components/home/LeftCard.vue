

<script lang="ts" setup>
import { ref, computed,reactive,getCurrentInstance,onMounted } from "vue"
import {useRoute, useRouter } from "vue-router"
import { ElMessage } from 'element-plus'
import axios from "axios";
const router:any = useRouter()
//接收父组件的参数
interface Props {
    leftcardid?: 2,
}
//参数实例化
const props = defineProps<Props>()
// 暴露给父组件的值
const navid = ref(2)
//将值传送给父组件
defineExpose({navid})

let navname:any = ref("暂无数据")

let categoryList:any = ref(
    [
    {
            id:1,
            name:"你好"
        },
        {
            id:2,
            name:"你好啊"
        },
        {
            id:2,
            name:"你好啊1"
        },
        {
            id:2,
            name:"你好啊2"
        },
        {
            id:2,
            name:"你好啊3"
        },
    ]
)
//获取导航
async function GetUserNav(){
    await axios.get('/api/category/list').then(res=>{
        categoryList.value = res.data.data.list
        navname.value = res.data.data.list[0].name
    })
}

// 使用defineEmits注册一个自定义事件
const emit = defineEmits(["GetNavId"])
//传递导航的Id来获取博客
function selectCategory(id,name){
    navname.value = name
    navid.value = id
    emit("GetNavId", navid.value)
}

//初始化
onMounted(()=>{
    GetUserNav()
})
</script>

<template>
    <div class="LeftCard-card">
        <div class="category-item" :class="{ 'category-item-active': item.name === navname }" v-for="item in categoryList"
            :key="item.id" @click="selectCategory(item.id,item.name)">{{ item.name }}</div>
    </div>
</template>


<style scoped>
.LeftCard-card {
    width: 150px;
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.1);
}
.LeftCard-card .category-item {
    text-align: center;
    padding: 10px 0;
    font-size: 16px;
    cursor: pointer;
}

.LeftCard-card .category-item-active {
    background-color: #1890ff;
    color: #fff;
    border-radius: 5px;
}
</style>