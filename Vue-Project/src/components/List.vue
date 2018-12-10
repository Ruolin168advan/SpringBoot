<template>
  <div id="list">
    <el-container style="height:672px;border:1px solid #eee">
      <el-header class="header">
        <h1>设备管理界面</h1>
        <p>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <span>{{user.name}}</span>
        </p>
      </el-header>
      <el-aside width="100%" style="background-color: rgb(238, 241, 246)">
        <el-tabs type="border-card" tab-position="left" style="height: 608px;overflow: auto">
          <el-tab-pane label="设备访问">
            <show-equip></show-equip>
          </el-tab-pane>
          <el-tab-pane label="设备管理">
            <manage-equip></manage-equip>
          </el-tab-pane>
          <el-tab-pane label="用户管理"></el-tab-pane>
        </el-tabs>
      </el-aside>
    </el-container>
  </div>
</template>

<script>
import ShowEquip from '@/components/ShowEquip'
import ManageEquip from '@/components/ManageEquip'
import UserEquip from '@/components/ManageUser'
export default {
  name: 'List',
  data () {
    return {
      user: {name: 'admin'}
    }
  },
  components: {
    ShowEquip,
    ManageEquip,
    UserEquip
  },
  methods: {
  }
}
</script>

<style scoped>
#list {
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
