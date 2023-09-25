<template>
  <CardContent>
    <div class="container" style="width:40%">
      <div class="card">
        <div class="card-body">
          <form @submit.prevent="register">
            <div class="mb-3">
            <label for="username" class="form-label">账号</label>
            <input v-model="username" type="username" class="form-control" id="username" placeholder="请输入账号">
            </div>
            <div class="mb-3">
            <label for="password" class="form-label">密码</label>
            <input v-model="password" type="password" class="form-control" id="password" placeholder="请输入密码">
          </div>
          <div class="mb-3">
            <label for="username" class="form-label">确认密码</label>
            <input v-model="confirmedpassword" type="password" class="form-control" id="password" placeholder="请确认密码">
            </div>
            <div class="error-message">{{ error_message }}</div>
          <button @click="register" type="button" class="btn btn-primary">登录</button>
          </form>
        </div>
      </div>
    </div>
  </CardContent>
</template>

<script>
import CardContent from '@/components/CardContent.vue';
import { ref } from 'vue';
import router from '@/router';
import $ from 'jquery';

export default {
    components: {
        CardContent
    },
    setup() {
      let username = ref('');
      let password = ref('');
      let confirmedpassword = ref('');
      let error_message = ref('');

      // 这里的注册实现的原理是不会自动更新数据，我们需要自己再次进行登录
      const register = () => {
        error_message.value = "";
        $.ajax({
          url: "http://localhost:3000/user/account/register",
          type: "post",
          data: {
            username: username.value,
            password: password.value,
            confirmedpassword: confirmedpassword.value
          },
          success(resp) {
            if(resp.error_message === "success") {
              router.push({name: "login"}); // 再次进行登录
            } else {
              error_message.value = resp.error_message
            }
          }
        })
      }

      return {
        username,
        password,
        confirmedpassword,
        error_message,
        register
        
      }
    }
}
</script>

<style scoped>
    button {
    margin-top: 20px;
    width: 100%;
  }
  .error-message {
    color: red;
  }
</style>