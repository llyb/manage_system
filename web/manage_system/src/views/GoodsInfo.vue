<template>
  <CardContent>
    <table class="table table-hover">
    <thead>
      <tr>
        <th>商品名</th>
        <th>商品价格</th>
        <th>商品编号</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>John</td>
        <td>Doe</td>
        <td>john@example.com</td>
        <td>
          <button type="button" class="btn btn-primary" style="margin-right: 10px;">添加</button>
          <button type="button" class="btn btn-danger">删除</button>
        </td>
      </tr>
      <tr>
        <td>Mary</td>
        <td>Moe</td>
        <td>mary@example.com</td>
        <td>
          <button type="button" class="btn btn-primary" style="margin-right: 10px;">添加</button>
          <button type="button" class="btn btn-danger">删除</button>
        </td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@example.com</td>
        <td>
          <button type="button" class="btn btn-primary" style="margin-right: 10px;">添加</button>
          <button type="button" class="btn btn-danger">删除</button>
        </td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@example.com</td>
        <td>
          <button type="button" class="btn btn-primary" style="margin-right: 10px;">添加</button>
          <button type="button" class="btn btn-danger">删除</button>
        </td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@example.com</td>
        <td>
          <button type="button" class="btn btn-primary" style="margin-right: 10px;">添加</button>
          <button type="button" class="btn btn-danger">删除</button>
        </td>
      </tr>
    </tbody>
</table>
  </CardContent>
</template>

<script>
import CardContent from '@/components/CardContent.vue';
export default {
    components: {
        CardContent
    }
}
</script>

<style>

</style>