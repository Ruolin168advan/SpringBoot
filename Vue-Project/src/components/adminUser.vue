<template>
<div id="adminUser">
  <el-table
    ref="filterTable"
    :data="userData"
    style="width: 90%;margin:30px auto">
    <el-table-column
      prop="id"
      label="用户ID"
      width="120">
    </el-table-column>
    <el-table-column
      prop="name"
      label="用户名"
      width="120">
    </el-table-column>
    <el-table-column
      prop="AllEquip"
      label="用户设备"
      show-overflow-tooltip>
    </el-table-column>
  </el-table>
</div>
</template>
<script>
export default {
  name: 'adminUser',
  data () { },
  props: {
    userDate: {
      type: Array,
      required: true
    }
  }
}
</script>

<style scoped>
#adminUser {
  overflow: hidden;
  background: rgb(239, 248, 223);
  height: 700px;
  width: 90%;
  margin: 0 auto
}
</style>
