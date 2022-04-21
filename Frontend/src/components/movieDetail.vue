<template>
    <sui-segment inverted>
    <!--head-->
    <sui-segment inverted>
        <div  class="row">
            <div class="column"  id  = "innerbox">
                <sui-image floated = "center" size="medium" :src="`${this.movie.image}`" /> 
            </div>
            <div class="column" >
                <div class="row">
                   <font face = "Times New Roman" size = "6"> Title:  &nbsp;  {{this.movie.title}}</font>
                </div>
                <br>
                <div class="row">
                    <font face = "Times New Roman" size = "6"> Year:  &nbsp;{{this.movie.year}}</font>
                </div>
                <br>
                <div class="row">
                   <font face = "Times New Roman" size = "6"> Minute:  &nbsp;  {{this.movie.runtimeMins}}</font>
                </div>
                <br>
                <div class="row">
                    <font face = "Times New Roman" size = "6"> Award:  &nbsp;{{this.movie.awards}}</font>
                </div>
                <br>
                <div class="row">
                   <font face = "Times New Roman" size = "6">  Directors:  &nbsp;  {{this.movie.directors}}</font>
                </div>
                <br>
                <div class="row">
                    <font face = "Times New Roman" size = "6"> Stars:  &nbsp;{{this.movie.stars}}</font>
                </div>
                <br>
            </div>
            
        </div> 
        <br><br><br><br><br><br>
        <div class="row">
            <sui-segment>
                 <h2>Rating</h2> 
                <sui-rating :defaultRating="3" :maxRating="10" color="yellow"   />
            </sui-segment> 
                
        </div>

        <br><br>
        <div  class="row">
            
        <sui-segment script = "width: 50%">
            <sui-comment-group minimal>
            <sui-header as="h3" dividing>Comments</sui-header>
            <input type="text" placeholder="comments" v-model="this.newComment.text">
            <sui-button  type="submit" basic color="blue" @click="addComment">
                <sui-icon name="save" />Save
            </sui-button>
            <sui-comment v-for="(comment, key) in comments" :key='key'>
                <!--<sui-comment-avatar src="/images/avatar/small/matt.jpg" />-->
                <sui-comment-content>
                <sui-comment-author as="a">Post By : {{comment.postby}}</sui-comment-author>
                <sui-comment-metadata>
                    <span>{{comment.postTime}}</span>
                </sui-comment-metadata>
                <sui-comment-text>
                    {{comment.text}}
                </sui-comment-text>
                <sui-comment-actions>
                    <a href="#">Replay</a>
                </sui-comment-actions>
                </sui-comment-content>
            </sui-comment>
            
         </sui-comment-group>
        </sui-segment>
            
            
        </div> 

    </sui-segment>
    
</sui-segment>
</template>

<script>
import axios from 'axios'

export default {
    name: 'movieDetail',
    data(){
        return{      
            movie_id: this.$route.params.id,
            movie: {},
            comments: [],
            newComment: {
                postby: "test",
                text: "",
            }
        }  
    },
    mounted(){
        
        axios.request('https://imdb-api.com/en/API/Title/k_up2i483u/' + this.movie_id)
        .then((response) => {
            this.movie = response.data
        })
        .catch((error) => {
            console.log(error)
        })

        axios.get('http://localhost:5000/movieDetail/' + this.movie_id)
        .then((response) => {
            console.log(response.data[0].comments)
            this.comments = response.data[0].comments
        })
        .catch((error) => {
            console.log(error)
        })
    },
    methods: {
        addComment(){
            var currentComment = {
                movie_id: this.movie_id,
                comments: this.comments
            }

            axios.post('http://localhost:5000/movieDetail/' + this.newComment.postby + '/' + this.newComment.text, currentComment)
            .then((response) => {
                console.log(response.data)
            })
            .catch((error) => {
                console.log(error)
            })

            window.location.reload()
        }
    }
    

}
</script>

<style>
.row {
  display: flex;
}

.column {
    margin-left: 50px;
  flex: 33.33%;
  padding: 5px;
}
#innerbox
{
   width:250px; /* or whatever width you want. */
   max-width:400px; /* or whatever width you want. */
   display: inline-block;
}
</style>