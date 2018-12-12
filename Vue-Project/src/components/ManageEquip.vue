<template>
  <div id="ManageEquip">
    <div style="margin:10px;margin-top:0">未设置分组</div>
    <el-table
      ref="multipleTable"
      :data="tableData"
      tooltip-effect="dark"
      style="width: 100%;height: 200px;border: 2px solid #DFE4ED;overflow: auto"
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
        label="连接状态"
        width="120">
        <template slot-scope="scope">
          <i class="el-icon-star-on" :class="{'succ' : isConnect}"></i>
        </template>
      </el-table-column>
      <el-table-column
        label="查看设备"
        width="120" align="center">
        <template slot-scope="scope">
          <i class="el-icon-search"></i>
        </template>
      </el-table-column>
      <el-table-column
        label="操作"
        width="120" align="center">
        <template slot-scope="scope">
          <i class="el-icon-edit" style="margin-right:10px"></i>
          <i class="el-icon-delete"></i>
        </template>
      </el-table-column>
    </el-table>
    <div style="display: flex; justify-content: space-around;margin-bottom:0">
      <i class="el-icon-d-arrow-left btn btn-down"></i>
      <i class="el-icon-d-arrow-left btn btn-up"></i>
    </div>
    <div>设备群组</div>
    <show-equip :tableData="tableData" :tableGroup="tableGroup" style="height:260px;overflow:auto;border:2px solid #DFE4ED"></show-equip>
  </div>
</template>
<script>
import ShowEquip from '@/components/ShowEquip'
export default {
  name: 'ManageEquip',
  data () {
    return {}
  },
  props: {
    tableData: {
      type: Array,
      required: true
    },
    tableGroup: {
      type: Array,
      required: true
    }
  },
  components: {
    ShowEquip
  }
}
</script>

<style scoped>
.btn {
  height: 35px;
  width: 35px;
  color: #6699EE;
  text-align: center;
  font-size: 28px;
  margin: 10px
}
.btn-down {
  transform: rotate(-90deg)
}
.btn-up {
  transform: rotate(90deg)
}
</style>
