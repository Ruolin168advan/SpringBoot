<template>
  <div id="list">
    <el-container style="height:665px;border:1px solid #eee">
      <el-header class="header">
        <h1>设备管理界面</h1>
        <p>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <span>{{user.name}}</span>
        </p>
      </el-header>
      <el-aside width="100%" style="background-color: rgb(238, 241, 246)">
        <el-tabs type="border-card" tab-position="left" style="height: 608px">
          <el-tab-pane label="设备访问">
            <show-equip :tableData="tableData" :tableGroup="tableGroup" style="height:608px;overflow:auto"></show-equip>
          </el-tab-pane>
          <el-tab-pane label="设备管理">
            <manage-equip :tableData="tableData" :tableGroup="tableGroup"></manage-equip>
          </el-tab-pane>
          <el-tab-pane label="用户管理">
            <manage-user :tableData="tableData" :tableGroup="tableGroup"></manage-user>
          </el-tab-pane>
        </el-tabs>
      </el-aside>
    </el-container>
  </div>
</template>

<script>
import ShowEquip from '@/components/ShowEquip'
import ManageEquip from '@/components/ManageEquip'
import ManageUser from '@/components/ManageUser'
export default {
  name: 'List',
  data () {
    return {
      user: {name: 'admin'},
      tableData: [{
        num: '001',
        group: '燃烧试验区域',
        id: 'A001-HJC-001',
        name: '1号高温仓',
        type: '环境仓',
        address: '试验配套区域（东区）',
        isConnect: true
      }, {
        num: '002',
        group: '燃烧试验区域',
        id: 'A001-HJC-002',
        name: '2号高温仓',
        type: '环境仓',
        desc: '环境仓',
        address: '试验配套区域（西区）',
        isConnect: false
      }, {
        num: '003',
        group: '耐久试验区域',
        id: 'A001-HJC-003',
        name: '3号高温仓',
        type: '环境仓',
        desc: '环境仓',
        address: '试验配套区域（北区）',
        isConnect: true
      }, {
        num: '004',
        group: '耐久试验区域',
        id: 'A001-HJC-004',
        name: '4号高温仓',
        type: '环境仓',
        desc: '环境仓',
        address: '试验配套区域（南区）',
        isConnect: true
      }, {
        num: '005',
        group: '低温试验区域',
        id: 'A001-HJC-003',
        name: '3号低温仓',
        type: '环境仓',
        desc: '环境仓',
        address: '试验配套区域（北区）',
        isConnect: true
      }, {
        num: '006',
        group: '低温试验区域',
        id: 'A001-HJC-004',
        name: '4号低温仓',
        type: '环境仓',
        desc: '环境仓',
        address: '试验配套区域（南区）',
        isConnect: true
      }],
      tableGroup: [{
        name: '燃烧试验区域',
        desc: '环境仓'
      }, {
        name: '耐久试验区域',
        desc: '环境仓'
      }, {
        name: '低温试验区域',
        desc: '环境仓'
      }]
    }
  },
  components: {
    ShowEquip,
    ManageEquip,
    ManageUser
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
