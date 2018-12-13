<template>
  <div id="ManageUser">
    <el-button @click="getMsg">获取我的设备信息</el-button>
  </div>
</template>
<script>
import bus from '@/assets/eventBus'
export default {
  name: 'ManageUser',
  data () {
    return {
      myList: []
    }
  },
  props: {
    tableData: {
      type: Array,
      required: true
    }
  },
  mounted () {
    bus.$on('getMsg', function (msg) {
      this.myList = msg
      console.log(this.myList)
    })
  },
  created: {
    showList (list) {}
  }
}
</script>
