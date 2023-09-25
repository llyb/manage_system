import { createRouter, createWebHistory } from 'vue-router';
import NotFoundView from '@/views/NotFoundView';
import ChangeLog from '@/views/ChangeLog';
import GoodsInfo from '@/views/GoodsInfo';
import LoginView from '@/views/LoginView';
import RegisterView from '@/views/RegisterView';
import StoreInfo from '@/views/StoreInfo';
import UserInfo from '@/views/UserInfo';
import store from '@/store';

const routes = [
  {
    path: '/changelog',
    name: 'changelog',
    component: ChangeLog,
    meta: {
      requestAuth: true // 表示当前页面是否需要授权
    }
  },
  {
    path: '/goodsinfo',
    name: 'goodsinfo',
    component: GoodsInfo,
    meta: {
      requestAuth: true
    }
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView,
    meta: {
      requestAuth: false
    }
  },
  {
    path: '/register',
    name: 'register',
    component: RegisterView,
    meta: {
      requestAuth: false
    }
  },
  {
    path: '/storeinfo',
    name: 'storeinfo',
    component: StoreInfo,
    meta: {
      requestAuth: true
    }
  },
  {
    path: '/userinfo',
    name: 'userinfo',
    component: UserInfo,
    meta: {
      requestAuth: true
    }
  },
  {
    path: '/404',
    name: 'notfound',
    component: NotFoundView,
    meta: {
      requestAuth: false
    }
  },
  {
    path: '/:catchAll(.*)',
    redirect: '/404'
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  if (to.meta.requestAuth && !store.state.user.is_login) {
    next({name: "login"});
  } else {
    next();
  }
})

export default router