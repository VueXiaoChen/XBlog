<script lang="ts" setup>
import { ref, computed,reactive,getCurrentInstance,onMounted,watch } from "vue"
import {useRoute, useRouter } from "vue-router"
import { ElMessage } from 'element-plus'
import axios from "axios";
const router:any = useRouter()

const bolgid = ref(sessionStorage.getItem("blogid"))
const blog:any= ref(
    {
        id:1,
        title:12,
        userName:12,
        date:12,
        readCount:12,
        content:'<p>背景（偷懒）<br/>在小小的公司里面，挖呀挖呀挖。快挖不动了，一件事重复个5次，还在人肉手工，身体和心理就开始不舒服了，并且违背了个人的座右铭：“偷懒”是人类进步的第一推动力。<br/>每次想要去测试环境验证个新功能，又或者被测试无情的催促着部署新版本后；都需要本地打那个200多M的jar包；以龟速般的每秒几十KB网络，通过ftp上传到服务器；用烂熟透的jps命令查找到进程，kill后，重启服务。<br/>是的，我想偷懒，想从已陷入到手工部署的沼泽地里走出来。如何救赎？<br/>自我救赎之路<br/>我的诉求很简单，想要一款“一键CI/CD的工具”，然后可以继续偷懒。为了省事，我做了以下工作<br/>找了一款停止服务的脚本，并做了小小的优化<br/>首推 陈皮大哥的停服脚本（我在里面加了个sleep 5）；脚本见下文。只需要修改 APP_MAINCLASS的变量“XXX-1.0.0.jar”替换为自己jar的名字即可，其它不用动。<br/>该脚本主要是通过jps + jar的名字获得进程号，进行kill。( 脚本很简单，注释也很详细，就不展开了，感兴趣可以阅读下，不到5分钟，写过代码的你能看懂的)<br/><br/>作者：程序员猪佩琪<br/>链接：<a href="https://juejin.cn/post/7257440759569055802" target="_blank">https://juejin.cn/post/7257440759569055802</a><br/>来源：稀土掘金<br/>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。<br/></p>'
    },
)
async function GetBlogById(id){
    await axios.get('/api/blog/list?id='+id).then((res=>{
        blog.value=res.data.data.list[0] 
    }))
}
const tagsArr = ref(["后端","Java","面试"])

watch(
  () => bolgid.value,
    (val, oldVal) => {
        GetBlogById(bolgid.value)
    },
    {
        immediate: true,
    }
);
onMounted(()=>{
   
})
</script>

<template>
    <div class="Blog-card" style="padding: 30px; margin-bottom: 10px">
        <div style="font-weight: bold; font-size: 24px; margin-bottom: 20px">{{ blog.title }}</div>
        <div style="color: #666; margin-bottom: 20px">
            <span style="margin-right: 20px"><el-icon>
                    <Camera />
                </el-icon> {{ blog.userName }}</span>
            <span style="margin-right: 20px"><el-icon>
                    <Camera />
                </el-icon> {{ blog.date }}</span>
            <span style="margin-right: 20px"><el-icon>
                    <Camera />
                </el-icon>{{ blog.readCount }}</span>
            <span>
                <el-tag v-for="item in tagsArr" :key="item" type="success" style="margin-right:5px">{{ item }}</el-tag>
            </span>
        </div>
        <div class="w-e-text">
            <div v-html="blog.content"></div>
        </div>
    </div>
</template>


<style scoped>
.Blog-card {
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.1);
    margin-bottom: 10px;
}
.Blog-card .el-icon{
    top:2px;
}
</style>