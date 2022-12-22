<template>
  <div id="app">
    <HeaderComponent/>

    <router-view/>
  </div>
</template>

<script>
// @ is an alias to /src
import HeaderComponent from '@/components/HeaderComponent.vue'

export default {
  name: 'HomeView',
  components: {
    HeaderComponent

  }
}


</script>

<style lang="scss">
@import "~bootstrap/scss/bootstrap.scss";



</style>
