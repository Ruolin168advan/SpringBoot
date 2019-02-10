<template>
<div id="adminEquip">
  <el-button @click="clearFilter">显示全部设备</el-button>
  <el-button @click="addEquip" v-if="isAdmin">添加设备</el-button>
  <el-table
    ref="filterTable"
    :data="EquipData"
    style="width: 100%;margin:0 auto">
    <el-table-column
      prop="num"
      label="设备编号"
      width="120">
    </el-table-column>
    <el-table-column
      prop="id"
      label="设备ID"
      width="120"
      align="center">
    </el-table-column>
    <el-table-column
      prop="ename"
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
      prop="egroup"
      label="设备群组（可筛选）"
      width="180"
      column-key="group"
      :filters="[{ text: '燃烧试验区域', value: '燃烧试验区域' }, { text: '耐久试验区域', value: '耐久试验区域' },{ text: '低温试验区域', value: '低温试验区域' }, { text: '压力试验区域', value: '压力试验区域' }]"
      :filter-method="filterHandler"
      filter-placement="bottom-end">
    </el-table-column>
    <el-table-column
      label="删除设备"
      v-if="isAdmin"
      align="center">
      <template slot-scope="scope">
        <i class="el-icon-delete active" @click="deleteEquip(scope.row)"></i>
      </template>
    </el-table-column>
  </el-table>
  <el-dialog title="增加设备" :visible.sync="addDialog">
    <el-table
      ref="multipleTable"
      :data="AllEquip"
      tooltip-effect="dark"
      style="width: 100%"
      @selection-change="changeFun">
      <el-table-column
        type="selection"
        width="55">
      </el-table-column>
      <el-table-column
        prop="id"
        label="设备ID"
        width="120">
      </el-table-column>
      <el-table-column
        prop="num"
        label="设备编号"
        width="120">
      </el-table-column>
      <el-table-column
        prop="ename"
        label="设备名称"
        width="120">
      </el-table-column>
      <el-table-column
        prop="egroup"
        label="设备群组"
        show-overflow-tooltip>
      </el-table-column>
    </el-table>
    <span slot="footer" class="dialog-footer">
      <el-button @click="addDialog = false">取 消</el-button>
      <el-button type="primary" @click="save">保 存</el-button>
    </span>
  </el-dialog>
</div>
</template>

<script>
export default {
  name: 'adminEquip',
  data () {
    return {
      EquipData: [],
      AllEquip: [],
      addDialog: false,
      multipleSelection: []
    }
  },
  props: {
    uid: {
      type: Number,
      required: true
    },
    isAdmin: {
      type: Boolean,
      required: true
    }
  },
  mounted () {
    this.getEquip()
    console.log(this.isAdmin)
  },
  methods: {
    clearFilter () {
      this.$refs.filterTable.clearFilter()
    },
    filterHandler (value, row, column) {
      const property = column['property']
      return row[property] === value
    },
    getEquip () {
      console.log(this.uid)
      this.$axios({
        method: 'GET',
        url: 'http://localhost:8080/equipuser/getequip',
        params: {id: this.uid}
      }).then((res) => {
        console.log(res.data)
        this.EquipData = res.data
      }).catch(err => {
        console.log(err)
      })
    },
    addEquip () {
      // console.log('add')
      this.addDialog = true
      this.$axios({
        method: 'GET',
        url: 'http://localhost:8080/equip/all'
      }).then((res) => {
        console.log(res.data)
        this.AllEquip = res.data
      }).catch(err => {
        console.log(err)
      })
    },
    deleteEquip (row) {
      this.$confirm('此操作将永久删除该设备, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let obj = {equipId: row.id, userId: this.uid}
        this.$axios({
          method: 'DELETE',
          url: 'http://localhost:8080/equipuser/delete',
          data: obj
        }).then((res) => {
          console.log(res.data)
          this.getEquip()
        }).catch(err => {
          console.log(err)
        })
        this.$message({
          type: 'success',
          message: '删除成功!'
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    changeFun (val) {
      this.multipleSelection = val
      console.log(this.multipleSelection)
    },
    save () {
      console.log('save')
      this.multipleSelection.forEach(item => {
        console.log(item.id)
        let obj = {userId: this.uid, equipId: item.id}
        this.$axios({
          method: 'POST',
          url: 'http://localhost:8080/equipuser/add',
          data: obj
        }).then((res) => {
          console.log(res.data)
          this.getEquip()
          this.addDialog = false
        }).catch(err => {
          console.log(err)
        })
      })
    }
  }
}
</script>

<style scoped>
#adminEquip {
  overflow: hidden;
  /* background: rgb(239, 248, 223); */
  height: 700px;
  width: 100%;
  margin: 0 auto
}
.succ {
  background: green;
}
</style>
