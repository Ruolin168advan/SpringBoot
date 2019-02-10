<template>
  <div id="app">
    <!-- <div class="header">
      <h3>ruolin.wang</h3>
      <div class="el-icon-setting"></div>
    </div> -->
    <!-- <router-view/> -->
    <router-view v-if="isRouterAlive"></router-view>
  </div>
</template>

<script>
export default {
  name: 'App',
  provide () {
    return {
      reload: this.reload
    }
  },
  data () {
    return {
      isRouterAlive: true
    }
  },
  methods: {
    reload () {
      this.isRouterAlive = false
      this.$nextTick(function () {
        this.isRouterAlive = true
      })
    }
  }

}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
* {margin: 0;}
.header{
  height: 50px;
  background: #6699ee;
  box-shadow: 0 0 20px 0 #666;
  display: flex;
  justify-content: space-between;
  color: aliceblue;
  font-size: 28px;
  padding: 15px 50px;
  align-items: center
}
</style>
