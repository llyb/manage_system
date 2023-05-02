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
  let flag = 1;
  const jwt_token = localStorage.getItem("jwt_token");

  if(jwt_token) {
    store.commit("update_token", jwt_token); // 如果有token就进行更新
    store.dispatch("get_info", {
      success() {

      },
      error() {
        alert("token无效,请重新登录");
        router.push({name: 'login'});
      }
    })
  } else {
    flag = 2;
  }

  if(to.meta.requestAuth && !store.state.user.is_login) {
      if(flag === 1) {
        next();
      } else {
        alert("请先进行登录！");
        next({name: 'login'});
      }
  } else {
    next();
  }
})

export default router