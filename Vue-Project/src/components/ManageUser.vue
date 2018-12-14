<template>
  <div id="ManageUser">
    <el-table :data="myList" class="table">
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
        label="位置"
        show-overflow-tooltip>
      </el-table-column>
      <el-table-column
        prop="group"
        label="设备群组"
        width="180">
      </el-table-column>
      <el-table-column label="权限">
        <el-table-column label="查看">
          <template slot-scope="scope">
            <i class="el-icon-circle-check active"></i>
          </template>
        </el-table-column>
        <el-table-column label="控制">
          <template slot-scope="scope">
            <i class="el-icon-circle-check" :class="{'active':isAdmin}"></i>
          </template>
        </el-table-column>
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
import bus from '@/assets/eventBus'
export default {
  name: 'ManageUser',
  data () {
    return {
      myList: [],
      isAdmin: true
    }
  },
  created () {
    bus.$on('getMsg', this.showList)
  },
  methods: {
    showList (msg) {
      this.myList = msg
      console.log(msg)
    }
  }
}
</script>

<style scoped>
.active {
  color: green
}
</style>
