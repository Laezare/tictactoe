<template>
  <div id="app">
    
    
    <TicTacToe />
  </div>
</template>

<script src="https://kit.fontawesome.com/6006bef861.js" crossorigin="anonymous"></script>
<script>
import TicTacToe from './components/TicTacToe.vue'

export default {
  name: 'app',
  components: {
    TicTacToe
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
