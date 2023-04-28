<template>
  <NavBarView/>
  <router-view/>
</template>

<script>
  import 'bootstrap/dist/css/bootstrap.css';
  import 'bootstrap/dist/js/bootstrap';
  import NavBarView from './views/NavBarView.vue';

  export default {
    components: {
      NavBarView
    }
  }
</script>

<style>
</style>
