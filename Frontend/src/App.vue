<template>
  <sui-menu inverted>
  <sui-menu-item ><img src="/src/assets/logo.png" alt=""></sui-menu-item>
  <router-link to ="/">
  <sui-menu-item>Home</sui-menu-item> 
  </router-link>

   <router-link to ="/">
  <sui-menu-item>Movie</sui-menu-item> 
  </router-link>
   <router-link to ="/">
  <sui-menu-item>Home</sui-menu-item> 
  </router-link>
   <router-link to ="/">
  <sui-menu-item>Home</sui-menu-item> 
  </router-link>

  <sui-menu-item position  = "right" > <sui-icon name="users" /></sui-menu-item>


  </sui-menu>
  <!-- <div class="ui menu">
  <a class="item">Browse</a>
  <a class="item">Submit</a>
  <div class="right menu">
    <a class="item">Sign Up</a>
    <a class="item">Help</a>
  </div> 
</div>-->
  <router-view />

</template>
<script>

export default {
  name: 'App',
}

</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: left;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}
</style>
