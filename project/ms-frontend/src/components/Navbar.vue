<template>
    <div>
  <b-navbar toggleable="lg" type="light">
    <b-navbar-brand href="#">Prueba</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item to="/">Añadir cliente</b-nav-item>
        <b-nav-item to="list">Listar cliente</b-nav-item>
        
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</div>
</template>

<script>
export default {
    name: 'Navbar',
    components: {
        
    },
};
</script>
