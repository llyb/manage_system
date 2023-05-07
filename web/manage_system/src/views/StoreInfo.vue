<template>
    <CardContent>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>仓库编号</th>
                    <th>仓库体积</th>
                    <th>仓库类型</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="s in storage" :key="s.s_id">
                    <td>{{ s.s_id }}</td>
                    <td>{{ s.s_volume }}</td>
                    <td>{{ s.s_type }}</td>
                </tr>
            </tbody>
        </table>
    </CardContent>
</template>

<script>
import CardContent from '@/components/CardContent.vue';
import { useStore } from 'vuex';
import { ref } from 'vue';
import $ from 'jquery';

export default {
    components: {
        CardContent,
    },
    setup() {
        let storage = ref([]);
        const store = useStore();

        $.ajax({
            url: 'http://localhost:3000/get/storage',
            type: 'get',
            headers: {
                Authorization: 'Bearer ' + store.state.user.token,
            },
            success(resp) {
                console.log(resp);
                storage.value.length = 0;
                storage.value = resp;
            },
            error(resp) {
                console.log(resp);
            },
        });

        return {
            storage,
        };
    },
};
</script>

<style></style>
