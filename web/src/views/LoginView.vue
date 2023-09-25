<template>
  <CardContentVue v-if="!$store.state.user.pulling_info">
    <div class="container" style="width:40%">
      <div class="card">
        <div class="card-body">
            <form @submit.prevent="login">
              <div class="mb-3">
              <label for="username" class="form-label">账号</label>
              <input v-model="username" type="username" class="form-control" id="username" placeholder="请输入账号">
              </div>
              <div class="mb-3">
              <label for="password" class="form-label">密码</label>
              <input v-model="password" type="password" class="form-control" id="password" placeholder="请输入密码">
              <div class="error-message">{{ error_message }}</div>
              <button type="submit" class="btn btn-primary">登录</button>
            </div>
            </form>
        </div>
      </div>
    </div>
  </CardContentVue>
</template>

<script>
import CardContentVue from '../components/CardContent.vue'
import { ref } from 'vue';
import { useStore } from 'vuex';
import router from '@/router';

export default {
    components: {
        CardContentVue
    },
    setup() {
      const store = useStore();
      let username = ref('');
      let password = ref('');
      let error_message = ref('');

      const jwt_token = localStorage.getItem("jwt_token");
      if(jwt_token) {
        store.commit("update_token", jwt_token);
        store.dispatch("get_info", {
          success() {
            router.push({name: "goodsinfo"});
            store.commit("updatePullingInfo", false);
          },
          error() {
            store.commit("updatePullingInfo", false);
          }
        })
      } else {
        store.commit("updatePullingInfo", false);
      }

      const login = () => {
        error_message.value = "";
        if(!username.value || !password.value) {
          error_message.value = "用户名或密码不能为空";
        }
        else {
          store.dispatch("login",{
          username: username.value,
          password: password.value,
          // 自定义错误处理函数
          success(resp) {
            // 获取用户信息
            store.dispatch("get_info", {
              success(resp) {
              // 登录成功并获取信息之后跳转到商品页面
              router.push({name: "goodsinfo"});
              console.log(resp);
              },
              error(resp) {
                error_message.value = "获取用户信息出错";
                console.log(resp);
              }
            })
            console.log(resp);
          },
          error(resp) {
            error_message.value = "用户名或密码错误";
            console.log(resp);
          }
        });
        }
      }

      return {
        username,
        password,
        error_message,
        login
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
    color:red;
  }
</style>