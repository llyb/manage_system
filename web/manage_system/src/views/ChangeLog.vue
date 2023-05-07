<template>
    <CardContent> 操作记录 </CardContent>
</template>

<script>
import CardContent from '@/components/CardContent.vue';
import $ from 'jquery';
import { useStore } from 'vuex';

export default {
    components: {
        CardContent,
    },
    setup() {
        const store = useStore();
        $.ajax({
            url: 'http://localhost:3000/update/logs',
            type: 'post',
            headers: {
                Authorization: 'Bearer ' + store.state.user.token,
            },
            data: {
                goods_number: '43',
                storage_id: '1',
                user_id: '5',
            },
            success(resp) {
                console.log(resp);
            },
            error(resp) {
                console.log(resp);
            },
        });
    },
};
</script>

<style></style>
