<template>
    <nav class="navbar navbar-expand-lg bg-body-tertiary bg-dark">
        <div class="container">
            <a class="navbar-brand" href="#">仓库管理系统</a>
            <button
                class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarText"
                aria-controls="navbarText"
                aria-expanded="false"
                aria-label="Toggle navigation"
            >
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <router-link :to="{ name: 'goodsinfo' }" class="nav-link">商品信息</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link :to="{ name: 'userinfo' }" class="nav-link">个人信息</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link :to="{ name: 'storeinfo' }" class="nav-link">仓库信息</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link :to="{ name: 'changelog' }" class="nav-link">操作记录</router-link>
                    </li>
                </ul>
            </div>
            <ul v-if="!$store.state.user.is_login" class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <router-link :to="{ name: 'register' }" class="nav-link">注册</router-link>
                </li>
                <li class="nav-item">
                    <router-link :to="{ name: 'login' }" class="nav-link">登录</router-link>
                </li>
            </ul>
            <ul v-else class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <router-link :to="{ name: 'userinfo' }" class="nav-link">{{
                        $store.state.user.username
                    }}</router-link>
                </li>
                <!-- <li class="nav-item">
          <router-link :to="{name: 'userinfo'}" @click="logout" class="nav-link">退出登录</router-link>
        </li> -->
                <li class="nav-item">
                    <a @click="logout" class="nav-link" aria-current="page" href="#">注销</a>
                </li>
            </ul>
        </div>
    </nav>
</template>

<script>
import { useStore } from 'vuex';
export default {
    name: 'NavBarView',
    setup() {
        const store = useStore();
        // 这里的属性要进行动态变化或者直接在上面读取store中的数据
        // username.value = store.state.user.username;
        // is_login.value = store.state.user.is_login;

        const logout = () => {
            store.dispatch('logout');
        };

        return {
            logout,
        };
    },
};
</script>

<style scoped>
.navbar-brand {
    color: aqua;
}
.nav-link {
    color: bisque;
}
</style>
