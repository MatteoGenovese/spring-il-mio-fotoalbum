<template>
  <div class="home">
    <div class=" container ">

      <div class="row">

      <input class="form-control me-2 mb-2" type="search" placeholder="Type for search images or tags..." aria-label="Search" v-model="searchBarValue" @keyup="searchByNameOrTag(searchBarValue)">




      <div v-for="photo in photoList" v-if="isloaded" :key="photo.id" class="col-4 mb-4 ">

        <CardComponent :photo="photo"/>

      </div>

    </div>

    </div>
  </div>
</template>

<script>
// @ is an alias to /src

import axios from 'axios';
import CardComponent from '@/components/CardComponent.vue'

export default {
  name: 'HomeView',
  components: {
    
    CardComponent
  },

  methods: {
    searchPhotoList() {
      this.isloaded=false;
      axios.get(`${this.apiURL}photos/all`)
        .then((result) => {
          console.log(result.data)
          this.photoList = result.data;
          this.isloaded=true;

        })
        .catch((error) => {
          console.warn(error);
        })
    },
    searchByNameOrTag(needle) {

      if(this.searchBarValue=="")
        this.searchPhotoList()
      else
      {
        this.isloaded=false;
      this.photoList=[];
      axios.get(`${this.apiURL}photos/search/${needle}`)
        .then((result) => {
          console.log(result.data)
          this.photoList = result.data;
          this.isloaded=true;

        })
        .catch((error) => {
          console.warn(error);
        })

      }
      
    },
  },
  data: function () {
    return {

      apiURL: 'http://localhost:8080/api/',
      isSearchBoxEmpty:true,
      photoList: [],
      searchBarValue:"",
      isloaded:false,
    }
  },
  mounted() {
    this.searchPhotoList();
  }
}
</script>
