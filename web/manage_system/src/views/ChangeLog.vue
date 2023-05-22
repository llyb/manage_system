<template>
    <CardContent>
        <td>
            <tr v-for="log in logs" :key="log.id">
                <CardContent>
                    此次操作的商品编号为：{{ log.goods_number }}，仓库编号为：{{ log.storage_id }}，操作的时间为：{{
                        log.time
                    }}，操作的用户编号为：{{ log.user_id }}，操作类型为：{{ log.info }}，操作的物品数量为：{{
                        log.good_num
                    }}
                </CardContent>
            </tr>
        </td>
    </CardContent>
</template>

<script>
import CardContent from '@/components/CardContent.vue';
import $ from 'jquery';
import { useStore } from 'vuex';
import { ref } from 'vue';

export default {
    components: {
        CardContent,
    },
    setup() {
        const store = useStore();
        let logs = ref([]);

        $.ajax({
            url: 'http://localhost:3000/getAll/inlogs',
            type: 'get',
            headers: {
                Authorization: 'Bearer ' + store.state.user.token,
            },
            success(resp) {
                logs.value = resp;
            },
            error(resp) {
                console.log(resp);
            },
        });

        $.ajax({
            url: 'http://localhost:3000/getAll/outlogs',
            type: 'get',
            headers: {
                Authorization: 'Bearer ' + store.state.user.token,
            },
            success(resp) {
                logs.value = logs.value.concat(resp); // 将返回的数据与之前的logs.value合并
            },
            error(resp) {
                console.log(resp);
            },
        });

        // function dateData(property, bol) {
        //     return function (a, b) {
        //         var value1 = a[property];
        //         var value2 = b[property];
        //         if (bol) {
        //             // 升序
        //             return Date.parse(value1) - Date.parse(value2);
        //         } else {
        //             // 降序
        //             return Date.parse(value2) - Date.parse(value1);
        //         }
        //     };
        // }

        // logs.value.sort(dateData('time', true));

        console.log(logs);

        return {
            logs,
        };
    },
};
</script>

<style></style>
