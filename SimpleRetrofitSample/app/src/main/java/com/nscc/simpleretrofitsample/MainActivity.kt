package com.nscc.simpleretrofitsample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nscc.samples.ApiService
import com.nscc.simpleretrofitsample.ui.theme.SimpleRetrofitSampleTheme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //val BASE_URL = "https://api.nasa.gov/planetary/"
            //val BASE_URL = "https://random-d.uk/api/v2/"
            val BASE_URL = "https://dog.ceo/api/breeds/image/"


            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service: ApiService =retrofit.create(ApiService::class.java)

            LaunchedEffect(Unit) {
                Log.i("TAG", "before Retrofit API call")
                //val response = service.getTodayApod("bWcsRnUMCSoDwM2XdRc5oOz962JGi7vD5g0aEErq")
                //val response = service.getRandomDuck()
                val response = service.getDog()
                print(response)
                Log.i("TAG", "after Retrofit API call")
                Log.i("TAG", response.url)
            }



            SimpleRetrofitSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimpleRetrofitSampleTheme {
        Greeting("Android")
    }
}