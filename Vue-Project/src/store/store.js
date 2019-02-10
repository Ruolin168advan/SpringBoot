import Vue from 'vue'
import Vuex from 'vuex'
import Cookie from 'vue-cookies'
Vue.use(Vuex)

export default new Vuex.Store({
  // 组件中通过 this.$store.state.username 调用
  state: {
    id: Cookie.get('id'),
    uname: Cookie.get('uname'),
    roleid: Cookie.get('roleid')
  },
  mutations: {
    // 组件中通过 this.$store.commit(参数)  调用
    savePermission: function (state, data) {
      state.id = data.id
      state.uname = data.uname
      state.roleid = data.roleid
      Cookie.set('id', data.id, '20min')
      Cookie.set('uname', data.uname, '20min')
      Cookie.set('roleid', data.roleid, '20min')
    },
    clearPermission: function (state) {
      state.uname = null
      state.roleid = null
      state.id = null
      Cookie.remove('id')
      Cookie.remove('uname')
      Cookie.remove('roleid')
    }
  }
})
