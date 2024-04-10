package com.nscc.samples

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var imageUrl by remember { mutableStateOf<String?>(null) }

             //val BASE_URL = "https://api.nasa.gov/planetary/"
            //val BASE_URL = "https://random-d.uk/api/v2/"
            val BASE_URL = "https://dog.ceo/api/breeds/image/"


            val retrofit: Retrofit =Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service:ApiService=retrofit.create(ApiService::class.java)

            LaunchedEffect(Unit) {
                Log.i("TAG", "before Retrofit API call")
                //val response = service.getTodayApod("bWcsRnUMCSoDwM2XdRc5oOz962JGi7vD5g0aEErq")
                //val response = service.getRandomDuck()
                val response = service.getDog()
                print(response)
                Log.i("TAG", "after Retrofit API call")
                Log.i("TAG", response.url)
            }


        }
    }
}
