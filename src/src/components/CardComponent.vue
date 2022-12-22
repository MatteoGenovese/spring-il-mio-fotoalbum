<template>
    <div class="card " th:object="${photo}">
        <a th:href="@{/{id} (id=*{id})}">
            <h5 class="card-title mt-2">{{ photo.title }}</h5>
            <img class="card-img-top" src="https://picsum.photos/id/237/200/300" alt="Card image cap">
            <div class="card-body">
                
                <p class="card-subtitle">{{ photo.description }}</p>

                <p class="card-text text-success">



                        Categories:
                    <span v-for="(category, index) in photo.categoryList" :key="category.id" class="card-text text-success">
                        <span v-if="index == 0">|</span>
                        {{ category.title }}
                        <span v-if="index != Object.keys(photo.categoryList).length">|</span>
                    </span>

                </p>
                <p class="card-text text-danger">
                    Tags:
                    <span v-for="(tag, index) in photo.tagList" :key="tag.id" class="card-text text-danger">
                        <span v-if="index != Object.keys(photo.tagList).length">#</span>
                        {{ tag.title }}
                        <span v-if="index != Object.keys(photo.tagList).length-1">, </span>
                    </span>

                </p>
                <p class="card-text text-primary">
                    Comments:
                <ul class="list-group list-group-flush text-primary">
                    <li v-for="comment in photo.commentList" :key="comment.id" class="card-text text-primary ">
                        {{ comment.comment }}
                    </li>
                </ul>
                </p>

                <input class="form-control me-2 mb-2" type="search" name="comment" placeholder="Add a comment..."
                    v-model="userComment" @keyup.enter="addComment()">

            </div>
        </a>
    </div>
</template>
  
<script>

import axios from 'axios';


export default {
    name: 'Header',
    props: {
        photo: {
            type: Object,
            required: true,
        }
    },
    data() {
        return {
            comment_create: {},
            API_URL: 'http://localhost:8080/api/comments',
            userComment: '',
            newComment: { comment: '', photo_id: '' },

        };
    },
    methods: {
        addComment() {
            if (this.userComment.trim() === '') return;
            this.newComment.photo_id = this.photo.id;
            this.newComment.comment = this.userComment;

            console.log(this.photo.id + " - " + this.userComment)

            axios.post(this.API_URL + "/add-comment/" + this.photo.id, this.newComment)
                .then(response => {
                    this.getPhotoComments(this.photo.id);
                    //  this.userComment = '';
                })
                .catch(error => {
                    console.log(error);
                });
        },
        getPhotoComments() {
            this.photo.commentList=[];
            axios.get(this.API_URL + '/by/photo/' + this.photo.id)
                .then(response => {
                    const photoComments = response.data;
                    if (photoComments == null) return
                    this.photo.commentList= photoComments;
                    console.log(this.photo.commentList);
                    this.userComment=null;
                })
                .catch(error => {
                    console.log(error);
                });
        },
    },
}   
</script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
.card-img-top{
    padding: 10px;
    max-height: 500px;
    overflow: hidden;
    object-fit: cover;
}
</style>
