<template>
  <div class="login">
    <h1 style="color:#fff"> Sign in</h1>
    <el-row type="flex" justify="center" class="container">
      <el-form ref="loginForm" :model="user" :rules="rules" status-icon label-width="200px">
        <el-form-item label="用户名" prop="name">
          <el-input type="text" v-model="user.name" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="pwd">
          <el-input type="password" v-model="user.pwd" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="login">登录</el-button>
        </el-form-item>
      </el-form>
    </el-row>
  </div>
</template>
<script>
export default {
  name: 'Login',
  data () {
    return {
      user: {},
      rules: {
        name: [
          {required: true, message: '用户名不能为空', trigger: 'blur'}
        ],
        pwd: [
          {required: true, message: '密码不能为空', trigger: 'blur'}
        ]
      }
    }
  },
  methods: {
    login () {
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
          if (this.user.name === 'admin' && this.user.pwd === '123') {
            this.$notify({
              type: 'success',
              message: '欢迎你，' + this.user.name + '!',
              duration: 3000
            })
            this.$router.replace('/list')
          } else {
            this.$message({
              type: 'error',
              message: '用户名或密码错误',
              showClose: true
            })
          }
        } else {
          return false
        }
      })
    }
  }
}
</script>
<style scoped>
  .login {
    width: 100%;
    height: 390px;
    padding: 175px;
    background-image: url('../../src/assets/index.jpg');
  }
  .container {
    width: 800px;
    height: 250px;
    color: #000 !important;
  }
</style>
