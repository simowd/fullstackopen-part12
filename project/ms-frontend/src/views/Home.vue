<template>

  <div class="home">
    <Navbar />
    <AddCustomer/>
  </div>
</template>

<script>
// @ is an alias to /src
import AddCustomer from '@/components/AddCustomer.vue'
import  Navbar  from '@/components/Navbar.vue'

export default {
  name: 'Home',
  components: {
    AddCustomer,
    Navbar
  }
}
</script>
