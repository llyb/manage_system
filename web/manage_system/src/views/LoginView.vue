<template>
  <CardContentVue>
    <div class="container" style="width:40%">
      <div class="card">
        <div class="card-body">
          <div class="mb-3">
        <label for="username" class="form-label">账号</label>
        <input type="username" class="form-control" id="username" placeholder="请输入账号">
        </div>
        <div class="mb-3">
        <label for="password" class="form-label">密码</label>
        <input type="password" class="form-control" id="password" placeholder="请输入密码">
        <button type="button" class="btn btn-primary">登录</button>
      </div>
        </div>
      </div>
    </div>
  </CardContentVue>
</template>

<script>
import CardContentVue from '../components/CardContent.vue'
export default {
    components: {
        CardContentVue
    }
}
</script>

<style scoped>
  button {
    margin-top: 20px;
    width: 100%;
  }
</style>