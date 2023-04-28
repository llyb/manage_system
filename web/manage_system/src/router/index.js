import { createRouter, createWebHistory } from 'vue-router';
import NotFoundView from '@/views/NotFoundView';
import ChangeLog from '@/views/ChangeLog';
import GoodsInfo from '@/views/GoodsInfo';
import LoginView from '@/views/LoginView';
import RegisterView from '@/views/RegisterView';
import StoreInfo from '@/views/StoreInfo';
import UserInfo from '@/views/UserInfo';

const routes = [
  {
    path: '/changelog',
    name: 'changelog',
    component: ChangeLog
  },
  {
    path: '/goodsinfo',
    name: 'goodsinfo',
    component: GoodsInfo
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/register',
    name: 'register',
    component: RegisterView
  },
  {
    path: '/storeinfo',
    name: 'storeinfo',
    component: StoreInfo
  },
  {
    path: '/userinfo',
    name: 'userinfo',
    component: UserInfo
  },
  {
    path: '/404',
    name: 'notfound',
    component: NotFoundView
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router