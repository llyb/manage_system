<template>
  <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container">
    <a class="navbar-brand" href="#">仓库管理系统</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <router-link :to="{name:'goodsinfo'}" class="nav-link active">商品信息</router-link>
        </li>
        <li class="nav-item">
          <router-link :to="{name:'userinfo'}" class="nav-link active">个人信息</router-link>
        </li>
        <li class="nav-item">
          <router-link :to="{name:'storeinfo'}" class="nav-link">仓库信息</router-link>
        </li>
        <li class="nav-item">
          <router-link :to="{name:'changelog'}" class="nav-link">操作记录</router-link>
        </li>
      </ul>
    </div>
    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <router-link :to="{name:'register'}" class="nav-link">注册</router-link>
        </li>
        <li class="nav-item">
          <router-link :to="{name:'login'}" class="nav-link">登录</router-link>
        </li>
    </ul>
  </div>
</nav>
</template>

<script>
export default {
    name: 'NavBarView',
}
</script>

<style>

</style>