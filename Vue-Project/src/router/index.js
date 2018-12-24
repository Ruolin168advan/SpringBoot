import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import List from '@/components/List'
import errPage from '@/components/errPage'
import adminEquip from '@/components/adminEquip'
import manager from '@/components/manager'
import adminUser from '@/components/adminUser'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: Login
    }, {
      path: '/list',
      component: List
    }, {
      path: '/err',
      component: errPage
    }, {
      path: '/adminEquip',
      component: adminEquip
    }, {
      path: '/manager',
      component: manager
    }, {
      path: '/adminUser',
      component: adminUser
    }
  ]
})
