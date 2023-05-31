<template>
    <CardContentVue>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>用户编号</th>
                    <th>用户姓名</th>
                    <th>用户身份</th>
                    <th>用户信息</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="user in users" :key="user.id">
                    <td>{{ user.id }}</td>
                    <td>{{ user.username }}</td>
                    <td>{{ user.permission }}</td>
                    <td>{{ user.user_info }}</td>
                    <td v-if="parseInt($store.state.user.id) === user.id">
                        <button
                            data-bs-toggle="modal"
                            data-bs-target="#exampleModal"
                            data-bs-whatever="@mdo"
                            type="button"
                            class="btn btn-primary"
                            style="margin-right: 10px"
                        >
                            修改
                        </button>
                    </td>
                </tr>
            </tbody>
        </table>
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <form @submit.prevent="updateUser">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">修改用户信息</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="mb-3">
                                <label for="recipient-name" class="col-form-label">用户姓名:</label>
                                <input v-model="username" type="text" class="form-control" id="recipient-name" />
                            </div>
                            <div class="mb-3">
                                <label for="recipient-name" class="col-form-label">用户身份:</label>
                                <input v-model="permission" type="text" class="form-control" id="recipient-name" />
                            </div>
                            <div class="mb-3">
                                <label for="message-text" class="col-form-label">用户信息:</label>
                                <textarea v-model="user_info" class="form-control" id="message-text"></textarea>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                            <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">保存修改</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </CardContentVue>
</template>
<script>
import { useStore } from 'vuex';
import CardContentVue from '../components/CardContent.vue';
import $ from 'jquery';
import { ref } from 'vue';

export default {
    components: {
        CardContentVue,
    },
    setup() {
        const store = useStore();
        const users = ref([]);
        let username = ref('');
        let permission = ref('');
        let user_info = ref('');

        $.ajax({
            url: 'http://localhost:3000/getAll/users',
            type: 'get',
            headers: {
                Authorization: 'Bearer ' + store.state.user.token,
            },
            success(resp) {
                users.value.length = 0;
                users.value = resp;
            },
            error() {
                alert('获取信息出错，请重试！');
            },
        });

        const updateUser = () => {
            store.dispatch('update', {
                user_id: store.state.user.id,
                username: username.value,
                permission: permission.value,
                user_info: user_info.value,
                success() {
                    $.ajax({
                        url: 'http://localhost:3000/getAll/users',
                        type: 'get',
                        headers: {
                            Authorization: 'Bearer ' + store.state.user.token,
                        },
                        success(resp) {
                            users.value.length = 0;
                            users.value = resp;
                        },
                        error() {
                            alert('获取信息出错，请重试！');
                        },
                    });
                },
            });
        };

        return {
            users,
            username,
            permission,
            user_info,
            updateUser,
        };
    },
};
</script>

<style></style>
