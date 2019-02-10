<template>
  <div id="user">
    <el-container style="height:665px;border:1px solid #eee">
      <el-header class="header">
        <h1>用户展示</h1>
        <p>
          <i class="el-icon-setting" style="margin-right: 15px" @click="logout"></i>
          <span>{{uname}}</span>
        </p>
      </el-header>
      <el-aside width="100%" style="background-color: rgb(238, 241, 246)">
        <el-tabs type="border-card" tab-position="left" style="height: 608px">
          <el-tab-pane label="设备展示">
            <user-equip :uid="uid" :isAdmin="isAdmin"></user-equip>
          </el-tab-pane>
        </el-tabs>
      </el-aside>
    </el-container>
  </div>
</template>
<script>
import userEquip from '@/components/userEquip'
export default {
  uname: 'user',
  data () {
    return {
      isAdmin: false,
      noLogin: true
    }
  },
  components: {
    userEquip
  },
  created () {
    this.uname = localStorage.getItem('username')
    this.roleid = localStorage.getItem('roleid')
    if (this.roleid === null) {
      this.toLogin()
    }
    if (this.roleid === '1') {
      this.isAdmin = true
    }
    this.uid = this.$route.params.id
    if (this.uid === undefined) {
      this.uid = localStorage.getItem('userid')
      this.uid = parseInt(this.uid)
      console.log(typeof (this.uid))
    }
    console.log(this.uid)
  },
  methods: {
    toLogin () {
      this.$router.push({
        name: 'login',
        path: '/login'
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
<style>
#user{
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
