<template>
<div id="ShowEquip">
  <el-button @click="clearFilter">显示全部设备</el-button>
  <el-table
    ref="filterTable"
    :data="tableData"
    style="width: 100%">
    <el-table-column
      prop="num"
      label="设备编号"
      width="120">
    </el-table-column>
    <el-table-column
      prop="id"
      label="设备ID"
      width="120">
    </el-table-column>
    <el-table-column
      prop="name"
      label="设备名称"
      width="120">
    </el-table-column>
    <el-table-column
      prop="type"
      label="设备类型"
      width="120">
    </el-table-column>
    <el-table-column
      prop="address"
      label="设备地址"
      show-overflow-tooltip>
    </el-table-column>
    <el-table-column
      prop="group"
      label="设备群组（可筛选）"
      width="180"
      column-key="group"
      :filters="[{ text: '燃烧试验区域', value: '燃烧试验区域' }, { text: '耐久试验区域', value: '耐久试验区域' },{ text: '低温试验区域', value: '低温试验区域' }, { text: '管理员设备', value: '管理员设备' }]"
      :filter-method="filterHandler"
      filter-placement="bottom-end">
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
</div>
</template>

<script>
export default {
  name: 'ShowEquip',
  data () {
    return {}
  },
  props: {
    tableData: {
      type: Array,
      required: true
    }
  },
  mounted () {
  },
  methods: {
    clearFilter () {
      this.$refs.filterTable.clearFilter()
    },
    filterHandler (value, row, column) {
      const property = column['property']
      return row[property] === value
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
