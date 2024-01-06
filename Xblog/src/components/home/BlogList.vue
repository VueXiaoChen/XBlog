

<script lang="ts" setup>
import { ref, computed,reactive,getCurrentInstance,onMounted,watch } from "vue"
import {useRoute, useRouter } from "vue-router"
import { ElMessage } from 'element-plus'
import axios from "axios";
const router:any = useRouter()
interface Props {
  navid?: 1,
}
//参数实例化

const props = defineProps<Props>()



const user:any = ref(JSON.parse(localStorage.getItem('user')))

const total = ref(0)

const pageNum = ref(1)

const pageSize = ref(10)

const tableData:any = ref(
  [
  {
      id:1,
      title:"你好啊",
      descr:'222',
      userName:'1',
      readCount:'5',
      likesCount:'5',
      tags:'["后端","Java","面试"]'
    },
    {
      id:2,
      title:"你好啊",
      descr:'222',
      userName:'1',
      readCount:'5',
      likesCount:'5',
      tags:'["后端","Java","面试"]'
    },
    {
      id:3,
      title:"你好啊",
      descr:'222',
      userName:'1',
      readCount:'5',
      likesCount:'5',
      tags:'["后端","Java","面试"]'
    },
  ]
)



const showOpt = ref(false)
//获取博客内容
async function GetBlogList(id,pize,size,navid){
  await axios.get("/api/blog/list?userId="+id+"&page="+pize+"&size="+size+"&categoryId="+navid).then(res=>{
    //console.log(res.data.data);
    total.value = res.data.data.total
    tableData.value=res.data.data.list
  })
}

function editBlog(id){

}

function del(id){

}
//分页查询
function handleCurrentChange(page){
  pageNum.value=page
  GetBlogList(user.value.id,page,10,props.navid)
}

//监听nav的变化值获取数据
watch(
  () => props.navid,
    (val, oldVal) => {
      if(props.navid){
        GetBlogList(user.value.id,1,10,props.navid)
      }
    },
    {
        immediate: true,
    }
);
function BlogJump(blog:any){
  console.log(blog);
  sessionStorage.setItem("userid",blog.userId)
  sessionStorage.setItem("blogid",blog.id)
  router.push({name:'BlogDetail'})
}
//初始化
onMounted(()=>{
  GetBlogList(user.value.id,1,10,1)
})


</script>

<template>
  <div>
    <div class="BlogList-card">
      <div class="blog-box" v-for="item in tableData" :key="item.id" v-if="total > 0">
        <div style="flex: 1; width: 0">
          <div  @click="BlogJump(item)">
            <div class="blog-title">{{ item.title }}</div>
          </div>
          <div class="line1" style="color: #666; margin-bottom: 10px; font-size: 13px">{{ item.descr }}</div>
          <div style="display: flex; align-items: center">
            <div style="flex: 1; font-size: 13px">
              <span style="color: #666; margin-right: 20px"><el-icon><Camera /></el-icon> {{ item.userName }}</span>
              <span style="color: #666; margin-right: 20px"><el-icon><Camera /></el-icon> {{ item.readCount }}</span>
              <span style="color: #666"><el-icon><Camera /></el-icon> {{ item.likesCount }}</span>

              <span v-if="showOpt" style="margin-left: 40px; color: red; cursor: pointer" @click="del(item.id)"><i
                  class="el-icon-delete"></i>删除</span>
              <span v-if="showOpt" style="margin-left: 10px; color: #2a60c9; cursor: pointer"
                @click="editBlog(item.id)"><i class="el-icon-edit"></i>编辑</span>
            </div>
            <div style="width: fit-content">
              <el-tag v-for="(items, index) in JSON.parse(item.tags || '[]')" :key="index" type="success"
                style="margin-right:5px">{{ items }}</el-tag>
            </div>
          </div>
        </div>
        <div style="width: 150px">
          <img style="width: 100%; height: 80px; border-radius: 5px" :src="item.cover" alt="">
        </div>
      </div>
      <div v-if="total === 0" style="padding: 20px ;text-align: center; font-size: 16px; color: #666">暂无数据</div>
      <div style="margin-top: 10px" v-if="total">
        <el-pagination background @current-change="handleCurrentChange" :current-page="pageNum" :page-sizes="[5, 10, 20]"
          :page-size="pageSize" layout="total, prev, pager, next" :total="total">
        </el-pagination>
      </div>
    </div>
  </div>
</template>


<style scoped>
.BlogList-card {
  padding: 20px;
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.1);
  margin-bottom: 10px;
  min-height: 80vh
}

.BlogList-card a {
  color: #333;
  text-decoration: none;
}

.BlogList-card .blog-box {
  display: flex;
  grid-gap: 15px;
  padding: 10px 0;
  border-bottom: 1px solid #ddd;
}

.BlogList-card .blog-box:first-child {
  padding-top: 0;
}

.BlogList-card .blog-title {
  font-size: 16px;
  font-weight: bold;
  margin-bottom: 10px;
  cursor: pointer;
}

.BlogList-card .blog-title:hover {
  color: #2a60c9;
}
.BlogList-card .el-icon{
  top: 2px;
}
</style>