<template>
    <header class="mb-5">
        <nav class="navbar navbar-expand-lg navbar-light bg-light px-5">
            <a class="navbar-brand" href="#">Il mio fotoalbum</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        
                        <a href="http://localhost:8080/photos/admin/all" class="px-3">Login</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
</template>
  
<script>
export default {
    name: 'Header',
    props: {

    }
}
</script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">

</style>
  