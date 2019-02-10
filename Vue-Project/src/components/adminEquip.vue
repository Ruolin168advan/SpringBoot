<template>
<div id="adminEquip">
  <el-button @click="clearFilter">显示全部设备</el-button>
  <el-button @click="addEquip">添加设备</el-button>
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
      width="120">
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
      label="操作"
      width="120" align="center">
      <template slot-scope="scope">
        <i class="el-icon-edit active" style="margin-right:10px" @click="updateEquip(scope.row)"></i>
        <i class="el-icon-delete active" @click="deleteEquip(scope.row)"></i>
      </template>
    </el-table-column>
  </el-table>
  <el-dialog :title="dialogTitle" :visible.sync="dialogFormVisible">
    <el-form :model="equipInfo">
      <el-form-item label="设备编号" :label-width="formLabelWidth">
        <el-input v-model="equipInfo.num" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="设备名称" :label-width="formLabelWidth">
        <el-input v-model="equipInfo.ename" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="设备类型" :label-width="formLabelWidth">
        <el-input v-model="equipInfo.type" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="设备地址" :label-width="formLabelWidth">
        <el-input v-model="equipInfo.address" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="设备群组" :label-width="formLabelWidth">
        <el-select v-model="equipInfo.egroup" placeholder="请选择群组">
          <el-option label="燃烧试验区域" value="燃烧试验区域"></el-option>
          <el-option label="耐久试验区域" value="耐久试验区域"></el-option>
          <el-option label="低温试验区域" value="低温试验区域"></el-option>
          <el-option label="压力试验区域" value="压力试验区域"></el-option>
        </el-select>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取 消</el-button>
      <el-button type="primary" @click="save">保 存</el-button>
    </div>
  </el-dialog>
</div>
</template>

<script>
export default {
  name: 'adminEquip',
  data () {
    return {
      EquipData: [],
      equipInfo: {},
      dialogFormVisible: false,
      dialogTitle: '',
      formLabelWidth: '100px',
      isUpdate: false
    }
  },
  created () {
    this.getAllEquip()
  },
  methods: {
    clearFilter () {
      this.$refs.filterTable.clearFilter()
    },
    filterHandler (value, row, column) {
      const property = column['property']
      return row[property] === value
    },
    getAllEquip () {
      this.$axios({
        method: 'GET',
        url: 'http://localhost:8080/equip/all'
      }).then((res) => {
        // console.log(res.data)
        this.EquipData = res.data
      }).catch(err => {
        console.log(err)
      })
    },
    addEquip () {
      this.dialogFormVisible = true
      this.dialogTitle = '添加设备'
    },
    updateEquip (row) {
      this.dialogFormVisible = true
      this.dialogTitle = '更改设备'
      this.equipInfo = row
      this.isUpdate = true
    },
    deleteEquip (row) {
      this.$confirm('此操作将永久删除该设备信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios({
          method: 'POST',
          url: 'http://localhost:8080/equip/delete',
          data: row
        }).then((res) => {
          console.log(res)
          this.getAllEquip()
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
    save () {
      this.dialogFormVisible = false
      console.log(this.equipInfo)
      if (this.isUpdate) {
        this.$axios({
          method: 'PUT',
          url: 'http://localhost:8080/equip/update',
          data: this.equipInfo
        }).then((res) => {
          console.log(res.data)
          this.getAllEquip()
        }).catch(err => {
          console.log(err)
        })
      } else {
        this.$axios({
          method: 'POST',
          url: 'http://localhost:8080/equip/add',
          data: this.equipInfo
        }).then((res) => {
          console.log(res.data)
          this.getAllEquip()
        }).catch(err => {
          console.log(err)
        })
      }
      this.equipInfo = {}
    }
  }
}
</script>

<style scoped>
#adminEquip {
  overflow: hidden;
  height: 700px;
  width: 100%;
  margin: 0 auto
}
.succ {
  background: green;
}
.active:hover{
  color:#fff;
  background: rgb(164, 195, 248);
  border-radius: 50%;
  padding: 4px;
}
</style>
