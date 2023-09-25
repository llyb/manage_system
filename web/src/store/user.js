import $ from 'jquery';

export default {
    state: {
        id: '',
        username: '',
        permission: '',
        user_info: '',
        token: '',
        is_login: false,
        pulling_info: true,
    },
    getters: {},
    mutations: {
        update_user(state, user) {
            state.id = user.id;
            state.username = user.username;
            state.permission = user.permission;
            state.user_info = user.info;
            state.is_login = user.is_login;
        },
        update_user1(state, user) {
            (state.username = user.username), (state.permission = user.permission), (state.user_info = user.info);
        },
        update_token(state, token) {
            state.token = token;
        },
        logout(state) {
            state.id = '';
            state.username = '';
            state.permission = '';
            state.user_info = '';
            state.token = '';
            state.is_login = false;
        },
        updatePullingInfo(state, pulling_info) {
            state.pulling_info = pulling_info;
        },
    },
    actions: {
        login(context, data) {
            // data是我们传入的数据
            $.ajax({
                url: 'http://localhost:3000/user/account/token',
                type: 'post',
                data: {
                    username: data.username,
                    password: data.password,
                },
                success(resp) {
                    if (resp.error_message === 'success') {
                        localStorage.setItem('jwt_token', resp.token); // 将token存到浏览器中而不是内存中
                        context.commit('update_token', resp.token); // 登录成功更新token
                        data.success(resp); // 自定义标志函数
                    } else {
                        // 能将信息返回给前端但是账号或密码有问题
                        data.error(resp);
                    }
                },
                error(resp) {
                    // 不能将信息返回给前端
                    data.error(resp);
                },
            });
        },
        get_info(context, data) {
            $.ajax({
                url: 'http://localhost:3000/user/account/info',
                type: 'get',
                headers: {
                    // 通过授权即可得到当前用户的信息，每个用户的token是根据用户的id进行绑定的
                    Authorization: 'Bearer ' + context.state.token,
                },
                success(resp) {
                    if (resp.error_message === 'success') {
                        context.commit('update_user', {
                            ...resp,
                            is_login: true,
                        });
                        data.success(resp);
                    } else {
                        data.error(resp);
                    }
                },
                error(resp) {
                    data.error(resp);
                },
            });
        },
        update(context, data) {
            $.ajax({
                url: 'http://localhost:3000/user/update',
                type: 'post',
                headers: {
                    Authorization: 'Bearer ' + context.state.token,
                },
                data: {
                    user_id: data.user_id,
                    username: data.username,
                    permission: data.permission,
                    user_info: data.user_info,
                },
                success(resp) {
                    if (resp.error_message === 'success') {
                        // 这里只对修改的数据进行更改，防止因为异步问题导致前端的id在某刻无法获取的问题
                        context.commit('update_user1', {
                            username: data.username,
                            permission: data.permission,
                            user_info: data.user_info,
                        });
                        data.success(); // 重新获取前端数据
                    }
                    console.log(resp);
                },
                error(resp) {
                    console.log(resp);
                },
            });
        },
        // 直接删除所有信息就是退出登录
        logout(context) {
            localStorage.removeItem('jwt_token');
            context.commit('logout');
        },
    },
    modules: {},
};
