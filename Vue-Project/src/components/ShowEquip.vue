<template>
<div id="ShowEquip">
  <el-table :data="tableGroup" style="width: 100%">
    <el-table-column type="expand">
      <template slot-scope="props">
        <el-table
          ref="multipleTable"
          :data="datalist"
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
      </template>
    </el-table-column>
    <el-table-column
      label="设备群组"
      prop="name">
    </el-table-column>
    <el-table-column
      label="描述"
      prop="desc">
    </el-table-column>
    <el-table-column
      label="操作" align="center">
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
      datalist: []
    }
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
  mounted () {
    this.getData()
  },
  methods: {
    getData () {
      for (var i = 0; i <= this.tableData.length; i++) {
        if (this.tableData.group === this.tableGroup.name) {
          this.datalist.push(this.tableData[i])
        }
      }
    }
  }
}
</script>

<style scoped>
#showEquip {
  overflow: auto
}
.succ {
  background: green;
}
</style>
