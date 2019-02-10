<template>
<div id="adminUser">
  <el-button @click="addUser">添加新用户</el-button>
  <el-table
    :data="UserData"
    style="width: 100%;margin:0 auto">
    <el-table-column
      prop="id"
      label="用户ID"
      width="120">
    </el-table-column>
    <el-table-column
      prop="uname"
      label="用户名称"
      width="120">
    </el-table-column>
    <el-table-column
      prop="permission"
      label="用户权限"
      width="120">
    </el-table-column>
    <el-table-column
      label="查看用户设备"
      align="center">
      <template slot-scope="scope">
        <i class="el-icon-search active" @click="search(scope.row)"></i>
      </template>
    </el-table-column>
    <el-table-column
      label="修改用户信息"
      align="center">
      <template slot-scope="scope">
        <i class="el-icon-edit active" @click="updateUser(scope.row)"></i>
      </template>
    </el-table-column>
    <el-table-column
      label="删除用户"
      align="center">
      <template slot-scope="scope">
        <i class="el-icon-delete active" @click="deleteUser(scope.row)"></i>
      </template>
    </el-table-column>
  </el-table>
  <el-dialog :title="dialogTitle" :visible.sync="dialogFormVisible">
    <el-form :model="userInfo">
      <el-form-item label="用户名称" :label-width="formLabelWidth">
        <el-input v-model="userInfo.uname" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="用户密码" :label-width="formLabelWidth">
        <el-input v-model="userInfo.upwd" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="用户权限" :label-width="formLabelWidth">
        <el-select v-model="userInfo.roleid" placeholder="请选择用户权限">
          <el-option label="1" value=1></el-option>
          <el-option label="2" value=2></el-option>
        </el-select>
        <span>1 - 管理员， 2 - 普通用户</span>
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
  name: 'adminUser',
  data () {
    return {
      UserData: [],
      dialogFormVisible: false,
      userInfo: {},
      formLabelWidth: '100px',
      isUpdate: false,
      dialogTitle: ''
    }
  },
  inject: ['reload'],
  created () {
    this.getUserData()
    console.log(this.UserData)
  },
  methods: {
    getUserData () {
      this.$axios({
        method: 'GET',
        url: 'http://localhost:8080/user/all'
      }).then((res) => {
        console.log(res.data)
        let arr = res.data
        for (let i = 0; i < arr.length; i++) {
          if (arr[i].roleid === 1) {
            arr[i].permission = '管理员'
          } else if (arr[i].roleid === 2) {
            arr[i].permission = '普通用户'
          }
        }
        this.UserData = arr
      }).catch(err => {
        console.log(err)
      })
    },
    addUser () {
      this.dialogFormVisible = true
      this.dialogTitle = '添加新用户'
    },
    updateUser (row) {
      this.dialogFormVisible = true
      this.isUpdate = true
      this.dialogTitle = '修改用户信息'
      console.log(row)
      this.userInfo.id = row.id
      this.userInfo.roleid = row.roleid
      this.userInfo.uname = row.uname
      this.userInfo.upwd = row.upwd
    },
    search (row) {
      console.log(row.id)
      this.$router.push({
        path: '/user',
        name: 'user',
        params: {id: row.id}
      })
    },
    deleteUser (row) {
      this.$confirm('此操作将永久删除该用户信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios({
          method: 'POST',
          url: 'http://localhost:8080/user/delete',
          data: row
        }).then((res) => {
          console.log(res)
          this.getUserData()
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
      this.userInfo.roleid = parseInt(this.userInfo.roleid)
      console.log(this.userInfo)
      if (this.isUpdate) {
        this.$axios({
          method: 'PUT',
          url: 'http://localhost:8080/user/update',
          data: this.userInfo
        }).then((res) => {
          console.log(res.data)
          this.getUserData()
        }).catch(err => {
          console.log(err)
        })
      } else {
        this.$axios({
          method: 'POST',
          url: 'http://localhost:8080/user/add',
          data: this.userInfo
        }).then((res) => {
          console.log(res.data)
          this.getUserData()
        }).catch(err => {
          console.log(err)
        })
      }
      this.userInfo = {}
    }
  }
}
</script>

<style scoped>
#adminUser {
  overflow: auto;
  height: 580px;
  width: 100%;
  margin: 0 auto;
  color: #000;
}
.active:hover{
  color:#fff;
  background: rgb(164, 195, 248);
  border-radius: 50%;
  padding: 4px;
}
</style>
