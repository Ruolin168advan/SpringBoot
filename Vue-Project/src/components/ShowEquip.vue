<template>
<div id="ShowEquip">
  <el-table :data="tableData" style="width: 100%">
    <el-table-column type="expand">
      <template slot-scope="props">
        <el-table
          ref="multipleTable"
          :data="tableData"
          tooltip-effect="dark"
          style="width: 100%"
          @selection-change="handleSelectionChange">
          <el-table-column
            type="selection"
            width="55">
          </el-table-column>
          <el-table-column
            label="设备编号"
            width="80" prop="num">
          </el-table-column>
          <el-table-column
            prop="id"
            label="设备ID"
            width="120">
          </el-table-column>
          <el-table-column
            prop="name"
            label="设备名称"
            width="100">
          </el-table-column>
          <el-table-column
            prop="type"
            label="设备类型"
            width="120">
          </el-table-column>
          <el-table-column
            prop="address"
            label="位置"
            show-overflow-tooltip>
          </el-table-column>
          <el-table-column
            prop="isConnect"
            label="连接状态"
            width="120">
            <template slot-scope="scope">
              <div class="isConnect? succ : error"></div>
            </template>
          </el-table-column>
          <el-table-column
            label="查看设备"
            width="120">
          </el-table-column>
          <el-table-column
            label="操作"
            width="120">
          </el-table-column>
        </el-table>
      </template>
    </el-table-column>
    <el-table-column
      label="设备群组"
      prop="group">
    </el-table-column>
    <el-table-column
      label="描述"
      prop="desc">
    </el-table-column>
    <el-table-column
      label="操作">
      <template slot-scope="scope">
        <i class="el-icon-edit" style="margin-right:10px"></i>
        <i class="el-icon-delete"></i>
      </template>
    </el-table-column>
  </el-table>
</div>
</template>

<script>
export default {
  name: 'ShowEquip',
  data () {
    return {
      tableData: [{
        num: '001',
        group: '燃烧试验区域',
        id: 'A001-HJC-001',
        name: '1号高温仓',
        type: '环境仓',
        desc: '环境仓',
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
        group: '燃烧试验区域',
        id: 'A001-HJC-003',
        name: '3号高温仓',
        type: '环境仓',
        desc: '环境仓',
        address: '试验配套区域（北区）',
        isConnect: true
      }, {
        num: '004',
        group: '燃烧试验区域',
        id: 'A001-HJC-004',
        name: '4号高温仓',
        type: '环境仓',
        desc: '环境仓',
        address: '试验配套区域（南区）',
        isConnect: true
      }]
    }
  }
}
</script>

<style scoped>
#showEquip {
  overflow: auto
}
.succ {
  width: 15px;
  height: 15px;
  border-radius: 50%;
  background: green;
}
.error {
  width: 15px;
  height: 15px;
  border-radius: 50%;
  background: red;
}
</style>
