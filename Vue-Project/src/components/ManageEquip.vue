<template>
  <div id="ManageEquip">
    <div class="tableTitle">请选择您需要的设备</div>
    <el-table ref="multipleTable" :data="allEquip" tooltip-effect="dark" class="table" @selection-change="getInfo">
      <el-table-column
        type="selection"
        width="55"
        :selectable="selectable">
      </el-table-column>
      <el-table-column
        label="设备编号"
        width="100"
        sortable
        prop="num">
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
        prop="group"
        label="设备群组"
        width="120">
      </el-table-column>
      <el-table-column
        prop="address"
        label="位置"
        show-overflow-tooltip>
      </el-table-column>
      <el-table-column
        label="查看设备"
        width="120" align="center">
        <template slot-scope="scope">
          <i class="el-icon-search"></i>
        </template>
      </el-table-column>
    </el-table>
    <div style="text-align:center">
      <i class="el-icon-d-arrow-left btn" @click="toDown"></i>
    </div>
    <div class="tableTitle">
      <span>我的设备</span>
      <el-button @click="sendMsg">确定</el-button>
    </div>
    <el-table :data="myEquip" class="table">
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
      <el-table-column
        label="删除"
        width="120" align="center">
        <template slot-scope="scope">
          <i class="el-icon-delete delbtn"  @click="deleteRow(scope.$index, scope.row)"></i>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
import bus from '@/assets/eventBus'

export default {
  name: 'ManageEquip',
  data () {
    return {
      allEquip: [],
      myEquip: [],
      multipleSelection: []
    }
  },
  props: {
    tableData: {
      type: Array,
      required: true
    }
  },
  created () {
    for (let i = 0; i < this.tableData.length; i++) {
      this.allEquip.push(this.tableData[i])
    }
    this.selectable()
  },
  methods: {
    sendMsg () {
      if (this.myEquip.length === 0) {
        this.$message({
          type: 'warning',
          message: '您尚未提交数据！'
        })
      } else {
        this.$confirm('提交之后不可修改，确认继续？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$message({
            type: 'success',
            message: '提交成功!   请进入“用户管理”处查看您的权限。'
          })
          bus.$emit('getMsg', this.myEquip)
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消提交'
          })
        })
      }
    },
    toDown () {
      let arr = this.multipleSelection
      for (let i = 0; i < arr.length; i++) {
        let index = this.allEquip.indexOf(arr[i])
        this.myEquip.push(arr[i])
        this.allEquip.splice(index, 1)
      }
    },
    deleteRow (index, data, row) {
      this.myEquip.splice(index, 1)
      this.allEquip.push(data)
    },
    getInfo (val) {
      this.multipleSelection = val
    },
    selectable () {
      let arr = arguments[0]
      for (const i in arr) {
        if (arr[i] === '管理员设备') {
          return false
        }
      }
      return true
    }
  }
}
</script>

<style scoped>
.table {
  width: 100%;
  height: 230px;
  border: 2px solid #DFE4ED;
  border-top:0;
  overflow: auto
}
.tableTitle {
  border: 2px solid #DFE4ED;
  border-bottom:1px solid #EBEEF5;
  padding:6px;
  display: flex;
  justify-content: space-between;
}
.btn {
  height: 35px;
  width: 35px;
  color: #6699EE;
  text-align: center;
  font-size: 28px;
  margin: 10px;
  transform: rotate(-90deg)
}
.btn:active {
  color:rgb(233, 76, 76);
  font-weight: bold;
  transform: scale(.8,.8) rotate(-90deg)
}
.delbtn {
  color:#6699EE;
}
.delbtn:active {
  color: rgb(233, 76, 76)
}
</style>
