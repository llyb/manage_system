<template>
    <CardContent>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>商品名</th>
                    <th>商品个数</th>
                    <th>商品编号</th>
                    <th>所在仓库</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="good in goods" :key="good.goods_number">
                    <td>{{ good.goods_name }}</td>
                    <td>{{ good.goods_num }}</td>
                    <td>{{ good.goods_number }}</td>
                    <td>{{ good.in_storage }}</td>
                    <td>
                        <button
                            data-bs-toggle="modal"
                            data-bs-target="#exampleModalLabel"
                            data-bs-whatever="@mdo"
                            type="button"
                            class="btn btn-primary"
                            style="margin-right: 10px"
                            @click="
                                setId(good.goods_number);
                                setnum(good.goods_num);
                            "
                        >
                            修改
                        </button>

                        <button
                            @click="
                                setId(good.goods_number);
                                deleteGoods(good.in_storage, good.goods_num);
                            "
                            type="button"
                            class="btn btn-danger"
                        >
                            删除
                        </button>
                    </td>
                </tr>
            </tbody>
        </table>
        <div
            class="modal fade"
            id="exampleModalLabel"
            tabindex="-1"
            aria-labelledby="exampleModalLabel"
            aria-hidden="true"
        >
            <div class="modal-dialog">
                <form @submit.prevent="updateGoods">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">修改商品信息</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="mb-3">
                                <label for="recipient-name" class="col-form-label">商品名称:</label>
                                <input v-model="goods_name" type="text" class="form-control" id="recipient-name" />
                            </div>
                            <div class="mb-3">
                                <label for="recipient-name" class="col-form-label">商品个数:</label>
                                <input v-model="goods_num" type="text" class="form-control" id="recipient-name" />
                            </div>
                            <div class="mb-3">
                                <label for="recipient-name" class="col-form-label">商品编号:</label>
                                <input v-model="goods_number" type="text" class="form-control" id="recipient-name" />
                            </div>
                            <div class="mb-3">
                                <label for="recipient-name" class="col-form-label">仓库编号:</label>
                                <input v-model="in_storage" type="text" class="form-control" id="recipient-name" />
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
        <button
            data-bs-toggle="modal"
            data-bs-target="#exampleModalLabel1"
            data-bs-whatever="@mdo"
            type="button"
            style="float: right"
            class="btn btn-primary"
        >
            添加商品
        </button>
        <div
            class="modal fade"
            id="exampleModalLabel1"
            tabindex="-1"
            aria-labelledby="exampleModalLabel1"
            aria-hidden="true"
        >
            <div class="modal-dialog">
                <form @submit.prevent="add_goods">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel1">商品信息</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="mb-3">
                                <label for="recipient-name" class="col-form-label">商品名称:</label>
                                <input v-model="good_name" type="text" class="form-control" id="recipient-name" />
                            </div>
                            <div class="mb-3">
                                <label for="recipient-name" class="col-form-label">商品个数:</label>
                                <input v-model="good_num" type="text" class="form-control" id="recipient-name" />
                            </div>
                            <div class="mb-3">
                                <label for="message-text" class="col-form-label">商品编号:</label>
                                <input v-model="good_number" class="form-control" id="message-text" />
                            </div>
                            <div class="mb-3">
                                <label for="message-text" class="col-form-label">仓库编号:</label>
                                <input v-model="in_storage1" class="form-control" id="message-text" />
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                            <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">确认添加</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </CardContent>
</template>

<script>
import CardContent from '@/components/CardContent.vue';
import { useStore } from 'vuex';
import $ from 'jquery';
import { ref } from 'vue';

export default {
    components: {
        CardContent,
    },
    setup() {
        const store = useStore();
        const goods = ref([]);
        let goods_name = ref('');
        let goods_num = ref('');
        let goods_number = ref('');
        let in_storage = ref('');
        let id = ref('');

        let good_name = ref('');
        let good_num = ref('');
        let good_number = ref('');
        let in_storage1 = ref('');

        let old_num = ref('');

        $.ajax({
            url: 'http://localhost:3000/get/goods',
            type: 'get',
            headers: {
                Authorization: 'Bearer ' + store.state.user.token,
            },
            success(resp) {
                goods.value.length = 0;
                goods.value = resp;
            },
            error() {
                alert('获取信息出错，请重试！');
            },
        });

        const setId = (goods_number) => {
            id.value = goods_number;
        };

        const setnum = (goods_num) => {
            old_num.value = goods_num;
        };

        const updateGoods = () => {
            // 对商品信息进行修改
            $.ajax({
                url: 'http://localhost:3000/update/goods',
                type: 'post',
                data: {
                    goods_number: goods_number.value,
                    goods_name: goods_name.value,
                    goods_num: goods_num.value,
                    old_good_number: id.value,
                    storage_id: in_storage.value,
                },
                headers: {
                    Authorization: 'Bearer ' + store.state.user.token,
                },
                success(resp) {
                    console.log('修改成功！' + resp);

                    if (old_num.value > goods_num.value) {
                        // 进行出库操作
                        $.ajax({
                            url: 'http://localhost:3000/update/inlogs',
                            type: 'post',
                            headers: {
                                Authorization: 'Bearer ' + store.state.user.token,
                            },
                            data: {
                                goods_number: goods_number.value,
                                storage_id: in_storage.value,
                                user_id: store.state.user.id,
                                good_num: Math.abs(goods_num.value - old_num.value),
                            },
                            success(resp) {
                                console.log('成功将记录进行更新！');
                                console.log(resp);
                            },
                            error(resp) {
                                console.log(resp);
                            },
                        });
                        // 对仓库的体积进行更新
                        $.ajax({
                            url: 'http://localhost:3000/update/storage',
                            type: 'post',
                            headers: {
                                Authorization: 'Bearer ' + store.state.user.token,
                            },
                            data: {
                                s_volume: Math.abs(old_num.value - goods_num.value),
                                s_id: in_storage.value,
                            },
                            success(resp) {
                                console.log(resp);
                            },
                            error(resp) {
                                console.log(resp);
                            },
                        });
                    } else {
                        // 更新记录
                        $.ajax({
                            url: 'http://localhost:3000/update/outlogs',
                            type: 'post',
                            headers: {
                                Authorization: 'Bearer ' + store.state.user.token,
                            },
                            data: {
                                goods_number: goods_number.value,
                                in_storage: in_storage.value,
                                user_id: store.state.user.id,
                                good_num: Math.abs(old_num.value - goods_num.value),
                            },
                            success(resp) {
                                console.log(resp);
                            },
                            error(resp) {
                                console.log(resp);
                            },
                        });
                        // 对仓库的体积进行更新
                        $.ajax({
                            url: 'http://localhost:3000/update/storage',
                            type: 'post',
                            headers: {
                                Authorization: 'Bearer ' + store.state.user.token,
                            },
                            data: {
                                s_volume: Math.abs(goods_num.value - old_num.value),
                                s_id: in_storage.value,
                            },
                        });
                    }

                    $.ajax({
                        url: 'http://localhost:3000/get/goods',
                        type: 'get',
                        headers: {
                            Authorization: 'Bearer ' + store.state.user.token,
                        },
                        success(resp) {
                            console.log('重新获取数据成功！');
                            goods.value.length = 0;
                            goods.value = resp;
                            console.log(goods);
                        },
                        error() {
                            alert('获取信息出错，请重试！');
                        },
                    });
                },
                error(resp) {
                    console.log(resp);
                },
            });
        };

        const deleteGoods = (in_storage, good_num) => {
            console.log(id.value);
            $.ajax({
                url: 'http://localhost:3000/delete/goods',
                type: 'delete',
                headers: {
                    Authorization: 'Bearer ' + store.state.user.token,
                },
                data: {
                    goods_number: id.value,
                },
                success(resp) {
                    console.log('删除成功' + resp);
                    // 更新出库记录
                    $.ajax({
                        url: 'http://localhost:3000/update/outlogs',
                        type: 'post',
                        headers: {
                            Authorization: 'Bearer ' + store.state.user.token,
                        },
                        data: {
                            goods_number: id.value,
                            in_storage: in_storage,
                            user_id: store.state.user.id,
                            good_num: good_num,
                        },
                        success(resp) {
                            console.log(resp);
                        },
                        error(resp) {
                            console.log(resp);
                        },
                    });
                    // 对仓库的体积进行更新
                    $.ajax({
                        url: 'http://localhost:3000/update/storage',
                        type: 'post',
                        headers: {
                            Authorization: 'Bearer ' + store.state.user.token,
                        },
                        data: {
                            s_volume: '-' + good_num,
                            s_id: in_storage,
                        },
                    });
                    // 重新获取商品信息
                    $.ajax({
                        url: 'http://localhost:3000/get/goods',
                        type: 'get',
                        headers: {
                            Authorization: 'Bearer ' + store.state.user.token,
                        },
                        success(resp) {
                            goods.value.length = 0;
                            goods.value = resp;
                        },
                        error() {
                            alert('获取信息出错，请重试！');
                        },
                    });
                },
                error(resp) {
                    console.log(resp);
                },
            });
        };

        // 添加商品之后我们应该更新操作记录数据库
        const add_goods = () => {
            $.ajax({
                url: 'http://localhost:3000/goods/add',
                type: 'post',
                headers: {
                    Authorization: 'Bearer ' + store.state.user.token,
                },
                data: {
                    good_number: good_number.value,
                    good_name: good_name.value,
                    good_num: good_num.value,
                    in_storage: in_storage1.value,
                },
                success(resp) {
                    $.ajax({
                        url: 'http://localhost:3000/get/goods',
                        type: 'get',
                        headers: {
                            Authorization: 'Bearer ' + store.state.user.token,
                        },
                        success(resp) {
                            console.log('重新获取数据成功！');
                            goods.value.length = 0;
                            goods.value = resp;
                            console.log(goods);
                        },
                        error() {
                            alert('获取信息出错，请重试！');
                        },
                    });
                    $.ajax({
                        url: 'http://localhost:3000/update/inlogs',
                        type: 'post',
                        headers: {
                            Authorization: 'Bearer ' + store.state.user.token,
                        },
                        data: {
                            goods_number: good_number.value,
                            storage_id: in_storage1.value,
                            user_id: store.state.user.id,
                            good_num: good_num.value,
                        },
                        success(resp) {
                            console.log('成功将记录进行更新！');
                            console.log(resp);
                        },
                        error(resp) {
                            console.log(resp);
                        },
                    });
                    // 对仓库的体积进行更新
                    $.ajax({
                        url: 'http://localhost:3000/update/storage',
                        type: 'post',
                        headers: {
                            Authorization: 'Bearer ' + store.state.user.token,
                        },
                        data: {
                            s_volume: good_num.value,
                            s_id: in_storage1.value,
                        },
                        success(resp) {
                            console.log(resp);
                        },
                        error(resp) {
                            console.log(resp);
                        },
                    });
                    console.log(resp);
                },
                error(resp) {
                    console.log(resp);
                },
            });
        };

        return {
            goods,
            goods_name,
            goods_num,
            goods_number,
            updateGoods,
            setId,
            deleteGoods,
            add_goods,
            good_name,
            good_num,
            good_number,
            in_storage,
            in_storage1,
            setnum,
        };
    },
};
</script>

<style></style>
