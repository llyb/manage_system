<template>
  <CardContent>
    <div class="container" style="width:40%">
      <div class="card">
        <div class="card-body">
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
        <button @click="register" type="button" class="btn btn-primary">登录</button>
        </div>
      </div>
    </div>
  </CardContent>
</template>

<script>
import CardContent from '@/components/CardContent.vue';
import { ref } from 'vue';
import $ from 'jquery';

export default {
    components: {
        CardContent
    },
    setup() {
      let username = ref('');
      let password = ref('');
      let confirmedpassword = ref('');

      const register = () => {
        $.ajax({
        url: "http://localhost:3000/user/account/register",
        type: "post",
        data: {
          // 当key和value相同时可以不用写
          username,
          password,
          confirmedpassword
        },
        success(resp) {
          console.log(resp);
        },
        error(resp) {
          console.log(resp);
        }
      })
    }

      return {
        username,
        password,
        confirmedpassword,
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
</style>