import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import UserView from '../views/UserView.vue'
import LoginView from '../views/LoginView.vue'

// index.js
const isAuthenticated = true

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/user/:id',
      name: 'user',
      component: UserView,
      // beforeEnter: (to, from) => {
      //   console.log(to)
      //   console.log(from)
      // }
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView,
      // beforeEnter: (to, from) => {
      //   if (isAuthenticated === true) {
      //     console.log('이미 로그인 상태입니다.')
      //     return { name: 'home' }
      //   }
      // }
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue')
    }
  ]
})

// index.js

// router.beforeEach((to, from) => {
//   const isAuthenticated = false
  
//   if (!isAuthenticated && to.name !== 'login') {
//     console.log('로그인이 필요합니다.')
//     return { name: 'login' }
//   }
// })

export default router


