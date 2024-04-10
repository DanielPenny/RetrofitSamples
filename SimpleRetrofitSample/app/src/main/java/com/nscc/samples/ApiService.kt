package com.nscc.samples
// ApiService.kt
import com.nscc.samples.data.Apod
import com.nscc.samples.data.Dog
import com.nscc.samples.data.Duck
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //https://api.nasa.gov/

    @GET("apod")
    suspend fun getTodayApod(@Query("api_key") apiKey:String,@Query("thumbs") thumbs:Boolean=true): Apod

    @GET("apod")
    suspend fun getList(@Query("api_key")apiKey: String,@Query("thumbs") thumbs:Boolean=true,@Query("count") count:Int =15):List<Apod>

//  https://random-d.uk/api


    @GET("random")
    suspend fun getRandomDuck(): Duck

//  https://dog.ceo/dog-api/

    @GET("random")
    suspend fun getDog(): Dog
}


