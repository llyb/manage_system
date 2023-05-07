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
                            @click="setId(good.goods_number)"
                        >
                            修改
                        </button>

                        <button
                            @click="
                                setId(good.goods_number);
                                deleteGoods();
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
                                <label for="recipient-name" class="col-form-label">商品价格:</label>
                                <input v-model="goods_price" type="text" class="form-control" id="recipient-name" />
                            </div>
                            <div class="mb-3">
                                <label for="message-text" class="col-form-label">商品编号:</label>
                                <textarea v-model="goods_number" class="form-control" id="message-text"></textarea>
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
                                <input v-model="good_price" type="text" class="form-control" id="recipient-name" />
                            </div>
                            <div class="mb-3">
                                <label for="message-text" class="col-form-label">商品编号:</label>
                                <textarea v-model="good_number" class="form-control" id="message-text"></textarea>
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
        let goods_price = ref('');
        let goods_number = ref('');
        let id = ref('');

        let good_name = ref('');
        let good_price = ref('');
        let good_number = ref('');

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

        const updateGoods = () => {
            // 对商品信息进行修改
            $.ajax({
                url: 'http://localhost:3000/update/goods',
                type: 'post',
                data: {
                    goods_number: goods_number.value,
                    goods_name: goods_name.value,
                    goods_price: goods_price.value,
                    old_good_number: id.value,
                },
                headers: {
                    Authorization: 'Bearer ' + store.state.user.token,
                },
                success(resp) {
                    console.log('成功更新数据' + resp);
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

        const deleteGoods = () => {
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
                    good_price: good_price.value,
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
            goods_price,
            goods_number,
            updateGoods,
            setId,
            deleteGoods,
            add_goods,
            good_name,
            good_price,
            good_number,
        };
    },
};
</script>

<style></style>
