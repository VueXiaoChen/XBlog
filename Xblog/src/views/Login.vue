

<script lang="ts" setup>
import { ref, computed,reactive,getCurrentInstance } from "vue"
import {useRoute, useRouter } from "vue-router"
import { ElMessage } from 'element-plus'
import axios from "axios";
const { proxy } = getCurrentInstance() as any

const router:any = useRouter()


let form = ref(
  {
    role:'ADMIN',
    username:'123',
    password:'123',
  }
)
let rules = ref(
  {
    username: [
      { required: true, message: '请输入账号', trigger: 'blur' },
    ],
    password: [
      { required: true, message: '请输入密码', trigger: 'blur' },
    ],
  }
)
let forms:any = ref('')
const Form = reactive({
  username: 'ccc',
  password: '123',
})

function handleLogin(){
  forms.value?.validate((valid: boolean, fields) => {
    if (valid) {
      // axios.get('/api/user/list').then(res=>{
      //   console.log(res);
      // })
      axios.post('/api/user/loading',Form).then(res=>{
        localStorage.setItem('user',JSON.stringify(res.data.data))
        router.push({name:'Home'})
      })
      // 
    } else {
      console.error("表单校验不通过")
    }
  })
}



function onSubmit() {
  console.log('submit!')
}

</script>

<template>
  <div class="container">
    <div class="forms-container"></div>
    <div class="signin-signup">
      <el-form ref="forms" :model="Form" label-width="auto" :rules="rules">
        <el-form-item label="账号 : " prop="username">
          <el-input v-model="Form.username" />
        </el-form-item>
        <el-form-item label="密码 : " prop="password">
          <el-input v-model="Form.password" />
        </el-form-item>
        <el-form-item>
          <div class="btn" style="text-align: center; width: 100%;">
            <el-button type="primary" @click.prevent="handleLogin" >登录</el-button>
            <el-button type="primary">注册</el-button>
          </div>
        </el-form-item>
      </el-form>
    </div>
    
  </div>
</template>


<style scoped>
.container {
  position: relative;
  width: 100%;
  background-color: #fff;
  min-height: 100vh;
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: center;
  background: url('../assets/imgs/log.svg') no-repeat center;
}

.forms-container {
  position: absolute;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
}

.signin-signup {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 600px;
  height: 600px;
}

</style>