<template>
  <div class="login">
    <h1 style="color:#fff"> Sign in</h1>
    <el-row type="flex" justify="center" class="container">
      <el-form ref="loginForm" :model="loginInfo" :rules="rules" status-icon label-width="200px">
        <div v-show="this.errorInfo !== ''" class="error">{{errorInfo}}</div>
        <el-form-item label="用户名" prop="name">
          <el-input type="text" v-model="loginInfo.uname" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="pwd">
          <el-input type="password" v-model="loginInfo.upwd" placeholder="请输入密码"></el-input>
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
      loginInfo: {uname: '', upwd: ''},
      errorInfo: '',
      userInfo: {},
      rules: {
        uname: [
          {required: true, message: '用户名不能为空', trigger: 'blur'}
        ],
        upwd: [
          {required: true, message: '密码不能为空', trigger: 'blur'}
        ]
      }
    }
  },
  methods: {
    login () {
      this.$axios({
        method: 'POST',
        url: 'http://localhost:8080/user/login',
        data: {
          uname: this.loginInfo.uname,
          upwd: this.loginInfo.upwd
        }
      }).then((res) => {
        console.log(res)
        if (typeof (res.data) !== typeof ('')) {
          // this.$store.commit('savePermission', res.data)
          localStorage.setItem('userid', res.data.id)
          localStorage.setItem('username', res.data.uname)
          localStorage.setItem('roleid', res.data.roleid)
          this.$router.replace({
            name: 'index',
            path: '/index'
          })
          this.$notify({
            type: 'success',
            message: '欢迎你，' + this.loginInfo.uname + '!',
            duration: 3000
          })
        } else {
          this.errorInfo = res.data
        }
      }).catch(err => {
        console.log(err)
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
  .error{
    color: red;
    position: relative;
    left: 200px;
    width: 200px;
    text-align: center;
    margin-bottom: 5px;
  }
</style>
