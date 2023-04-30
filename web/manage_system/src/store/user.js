import $ from 'jquery';

export default ({
    state: {
        id: "",
        username: "",
        permission: "",
        user_info: "",
        token: "",
        is_login: false
    },
    getters: {
    },
    mutations: {
        update_user(state, user) {
            state.id = user.id;
            state.username = user.username;
            state.permission = user.permission;
            state.user_info = user.info;
            state.is_login = user.is_login;
        },
        update_token(state, token) {
            state.token = token;
        },
        logout(state) {
            state.id = "";
            state.username = "";
            state.permission = "";
            state.user_info = "";
            state.token = "";
            state.is_login = false;
        }
    },
    actions: {
        login(context, data) { // data是我们传入的数据
            $.ajax({
                url: "http://localhost:3000/user/account/token",
                type: "post",
                data: {
                  username: data.username,
                  password: data.password
                },
                success(resp) {
                    if(resp.error_message === "success") {
                        context.commit("update_token", resp.token); // 登录成功更新token
                        data.success(resp); // 自定义标志函数
                    } else { // 能将信息返回给前端但是账号或密码有问题
                        data.error(resp);
                    }
                },
                error(resp) { // 不能将信息返回给前端
                  data.error(resp);
                }
              });
        },
        get_info(context, data) {
            $.ajax({
                url: "http://localhost:3000/user/account/info",
                type: "get",
                headers: { // 通过授权即可得到当前用户的信息，每个用户的token是根据用户的id进行绑定的
                  Authorization: "Bearer " + context.state.token
                },
                success(resp) {
                if(resp.error_message === "success") {
                    context.commit("update_user", {
                        ...resp,
                        is_login: true
                      });
                      data.success(resp);
                } else {
                    data.error(resp);
                }
            },
            error(resp) {
                data.error(resp);
            }
            });
        },
        // 直接删除所有信息就是退出登录
        logout(context) {
            context.commit("logout");
            console.log("dawdaw" + context.state.is_login);
        }
    },
    modules: {
    }
  })