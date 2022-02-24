<template>
  <div class="about">
    <Navbar />  
    <ListComponent />
  </div>
</template>

<script>
import  Navbar  from '@/components/Navbar.vue'
import ListComponent from '@/components/ListComponent.vue'
export default {
  name: 'List',
  components: {
    Navbar,
    ListComponent
  }
}
</script>