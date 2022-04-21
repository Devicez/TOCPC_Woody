<template color  ="black">

<sui-segment >
<!-- Search -->
        


        <div class="ui teal segment">
            <div class="input-group">
                <sui-label ribbon color="grey">Movies</sui-label>
                <input type="text" class="form-control" placeholder="Search..." v-model="search">
                <div>
                    <sui-button color="gray"   attached="left">Search</sui-button>
                   
                   
                </div>
         </div>
         </div>
        
 
     
<br>

<sui-card-group :itemsPerRow="4" doubling v-for="(movie, key) in movies" :key='key'>
    <!-- <sui-card v-for = "movie_alias in filterContacts" v-bind:key = "movie_alias.name"> -->
    <!-- <sui-image class="card-img-top"  v-bind:src = "movie_alias.imageUrl" /> -->
    <sui-card>
        <sui-image :src="`${movie.image}`" />
    <sui-card-content >
        <sui-card-header textAlign="center">{{movie.title}} </sui-card-header>
        <sui-card-description >
            <sui-card-meta >    
            <span class="date">Year : {{movie.year}}</span><br>
            <span class="date">Rank : {{movie.rank}}</span><br>
            </sui-card-meta>  
        </sui-card-description >   

    </sui-card-content >    

            
    <div style  = "text-align: center">
            <router-link :to = "{path: 'moviedetail', name: 'movieDetail', params:{id: movie.movie_id}}">
                <sui-button floated="center" color = "blue" >
                        Detail
                </sui-button>
            </router-link>
           

    </div >
    <br>
    </sui-card>
    
    <!-- </sui-card>  -->
       
</sui-card-group>
</sui-segment>

    
</template>

<script>

import axios from 'axios'

export default {

    name: "movieList",
    data(){
        return{
            search: '',
            movies: []
        }  
    },
    mounted() {

        axios.request('https://imdb-api.com/en/API/Top250Movies/k_up2i483u')
        .then((response) => {
            
            for(var i=0 ; i<10 ; i++)
            {
                var urlLength = JSON.stringify(response.data.items[i].image)
                var posterUrl = response.data.items[i].image.substring(0,urlLength.length - 32) + "._V1_Ratio0.6800_AL_.jpg"

                this.movies.push(
                    {
                        movie_id: response.data.items[i].id,
                        title: response.data.items[i].title,
                        rank: response.data.items[i].rank,
                        year: response.data.items[i].year,
                        image: posterUrl
                    }
                )
                
            }
            console.log(this.movies)

        })
        .catch((error) => {
	        console.log(error);
        })  
       
    },methods: {

    },
    computed:{
        // filterContacts : function(){
        //     return this.movie.filter((contact)=>{
        //         return contact.firstname.toLowerCase().match(this.search.toLowerCase()) || contact.lastname.toLowerCase().match(this.search.toLowerCase()) ||  (contact.firstname +" "+contact.lastname).toLowerCase().match(this.search.toLowerCase())
        //     })
        // }
    }
}
</script>
   
<style>
.card-img-top {
  width: 100%;
  height: 50vh;
  object-fit: cover;
 

}
</style>