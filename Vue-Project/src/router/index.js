import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import admin from '@/components/admin'
import errPage from '@/components/errPage'
import adminEquip from '@/components/adminEquip'
// import manager from '@/components/manager'
import adminUser from '@/components/adminUser'
import Index from '@/components/index.vue'
import user from '@/components/user.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login
    }, {
      path: '/index',
      name: 'index',
      component: Index
    }, {
      path: '/admin',
      name: 'admin',
      component: admin
    }, {
      path: '/user',
      name: 'user',
      component: user
    }, {
      path: '/err',
      name: 'err',
      component: errPage
    }, {
      path: '/adminEquip',
      name: 'adminEquip',
      component: adminEquip
    }, {
      path: '/adminUser',
      name: '/adminUser',
      component: adminUser
    }
  ]
})
