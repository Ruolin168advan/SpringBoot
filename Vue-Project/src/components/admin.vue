<template>
  <div id="admin">
    <!-- <el-dialog
    title="提示"
    :visible.sync="noLogin"
    width="30%">
    <span>您尚未登陆，请跳转到登录页面</span>
    <span slot="footer" class="dialog-footer">
      <el-button type="primary" @click="toLogin">确 定</el-button>
    </span>
  </el-dialog> -->
    <el-container style="height:665px;border:1px solid #eee">
      <el-header class="header">
        <h1>管理员界面</h1>
        <p>
          <i class="el-icon-setting" style="margin-right: 15px" @click="logout"></i>
          <span>{{uname}}</span>
        </p>
      </el-header>
      <el-aside width="100%" style="background-color: rgb(238, 241, 246)">
        <el-tabs type="border-card" tab-position="left" style="height: 608px">
          <el-tab-pane label="用户管理">
            <admin-user></admin-user>
          </el-tab-pane>
          <el-tab-pane label="设备管理">
            <admin-equip></admin-equip>
          </el-tab-pane>
        </el-tabs>
      </el-aside>
    </el-container>
  </div>
</template>

<script>
import adminEquip from '@/components/adminEquip'
import adminUser from '@/components/adminUser'

export default {
  name: '',
  data () {
    return {
      uname: '',
      UserData: [],
      noLogin: true
    }
  },
  components: {
    adminEquip,
    adminUser
  },
  created () {
    this.uname = localStorage.getItem('username')
    this.roleid = localStorage.getItem('roleid')
    // this.getUserData()
    // console.log(this.UserData)
    if (this.uname === null) {
      this.toLogin()
    }
    if (this.roleid === '2') {
      this.toErr()
    }
  },
  methods: {
    toLogin () {
      this.$router.push({
        name: 'login',
        path: '/login'
      })
    },
    toErr () {
      this.$router.push({
        name: 'err',
        path: '/err'
      })
    },
    logout () {
      localStorage.clear()
      this.$router.replace({
        name: 'login',
        path: '/login'
      })
    }
  }
}
</script>

<style scoped>
#admin {
  margin: 15px;
  height: 725px;
  background: #6699ee;
  box-shadow: 0 0 20px 0 #666
}
.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-size: 20px;
}
</style>
