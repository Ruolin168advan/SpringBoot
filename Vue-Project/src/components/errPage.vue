<template>
<div>
  <h1>您尚未获得管理员权限</h1>
</div>
</template>

<script>
export default {
  name: 'errPage',
  created () {
    setTimeout(this.toIndex, 3000)
  },
  methods: {
    toIndex () {
      this.$router.push({
        name: 'index',
        path: '/index'
      })
    }
  }
}
</script>
<style>
h1{
  margin-top: 150px;
  padding: 150px;
  background: #6699ee;
  color: aliceblue;
}
</style>
