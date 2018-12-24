<template>
<div id="admin">
  <h1 class="title">管理员界面</h1>
  <div class="btn">
    <el-button @click="toEquip" type="success" plain style="margin-right:80px">进入设备管理界面</el-button>
    <el-button @click="toUser" type="success" plain>进入用户管理界面</el-button>
  </div>
</div>
</template>
<script>
export default {
  name: 'manager',
  methods: {
    toEquip () {
      this.$router.push('/adminEquip')
    },
    toUser () {
      this.$router.push('/adminUser')
    }
  }
}
</script>
<style scoped>
#admin {
  background: #B3CC88;
  height:400px;
  width:90%;
  margin: 100px auto;
}
.title {
  color: #ffffff;
  text-align: center;
  padding: 80px;
  font-size: 48px
}
.btn {
  text-align: center;
}
</style>
