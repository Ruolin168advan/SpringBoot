<template>
<div>
  <!-- <el-dialog
    title="提示"
    :visible.sync="noLogin"
    width="30%">
    <span>您尚未登陆，请跳转到登录页面</span>
    <span slot="footer" class="dialog-footer">
      <el-button type="primary" @click="toLogin">确 定</el-button>
    </span>
  </el-dialog> -->
  <div class="index">
    <el-header class="title">
      <p>welcome to index page</p>
      <p>
        <i class="el-icon-setting logout" @click="logout"></i>
        <span>{{user.uname}}</span>
      </p>
    </el-header>
    <el-main class="carousel">
      <div class="block" v-if="this.user.roleid === '2'">
        <a class="demonstration" @click="toUser">进入用户界面</a>
      </div>
      <div class="block" v-if="this.user.roleid === '1'">
        <a class="demonstration" @click="toAdmin">进入管理员界面</a>
      </div>
    </el-main>
  </div>
</div>
</template>

<script>
export default {
  name: 'index',
  data () {
    return {
      user: [],
      noLogin: true
    }
  },
  watch: {
  },
  created () {
    this.user.roleid = localStorage.getItem('roleid')
    if (this.user.roleid === null) {
      this.toLogin()
    }
    this.user.uname = localStorage.getItem('username')
  },
  methods: {
    toLogin () {
      this.$router.push({
        name: 'login',
        path: '/login'
      })
    },
    toUser () {
      this.$router.push({
        name: 'user',
        path: '/user',
        params: this.user
      })
    },
    logout () {
      localStorage.clear()
      this.$router.replace({
        name: 'login',
        path: '/login'
      })
    },
    toAdmin () {
      this.$router.push({
        name: 'admin',
        path: '/admin',
        params: this.user
      })
    }
  }
}
</script>

<style>
.index {
  margin: 15px;
  height: 725px;
  padding-top: 35px;
  background: #6699ee;
  box-shadow: 0 0 20px 0 #666
}
.title {
  font-size: 32px;
  color:#fff;
  display: flex;
  justify-content: space-between;
}
.carousel {
  display: flex;
  justify-content: space-around;
  margin-top: 150px;
}
.block{
  width: 450px;
  height: 400px;
}
.block a{
  margin-top: 15px;
  display:block;
  font-size:26px;
  text-align: center;
  padding:15px;
}
.block a:hover{
  margin-top: 15px;
  display:block;
  font-size:26px;
  text-align: center;
  padding:15px;
  color: #fff;
  border:1px solid #fff;
  cursor: pointer;
}
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 150px;
  margin: 0;
}
.el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
}
.el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
}
</style>
