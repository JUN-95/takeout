import Vue from 'vue'
import VueRouter from 'vue-router'
import Cart from '../views/Cart'
import Info from '../views/Info'
import About from "../views/About"
import Login from "../views/Login"
import Mine from "../views/Mine"
import Order from "../views/Order"
import OrderDetail from "../views/OrderDetail"
import Pay from "../views/Pay"

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: '购物车',
    component: Cart
  },
  {
    path: '/info',
    name: '用户信息',
    component: Info
  },
  {
    path: '/about',
    name: '关于',
    component: About
  },
  {
    path: '/login',
    name: '登录',
    component: Login
  },
  {
    path: '/mine',
    name: '我的',
    component: Mine
  },
  {
    path: '/order',
    name: '订单',
    component: Order
  },
  {
    path: '/orderDetail',
    name: '订单详情',
    component: OrderDetail
  },
  {
    path: '/pay',
    name: '支付',
    component: Pay
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) => {
  if (to.path.startsWith('/login')) {
    window.localStorage.removeItem('access-user')
    next()
  } else {
    let user = JSON.parse(window.localStorage.getItem('access-user'))
    if (!user) {
      next({path: '/login'})
    } else {
      next()
    }
  }
})

export default router
