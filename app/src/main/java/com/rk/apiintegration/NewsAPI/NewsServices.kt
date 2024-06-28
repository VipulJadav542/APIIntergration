package com.rk.apiintegration.NewsAPI

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val Base_Url="https://newsapi.org/"
const val API_KEY="0a01bf44e5f74608a5267ac5b53fcf52"

interface NewsInterface {

    //for my api
    @GET("api/v1/task")
//    @Headers("Content-Type: application/json", "Authorization: Bearer NnmNEJonsw3R_kp2dIFNe8Bt2D8ZuDwNY3KhwdH2IqPZGskLbw")
    fun AllUsers():Call<VipulAPI>

    @GET("v2/top-headlines?apiKey=$API_KEY")
//    fun getNewsHeadlines(@Query("country") country: String,@Query("page") page: Int):Call<News>
    fun getNewsHeadlines(@Query("sources") country: String):Call<News>

    @GET("v2/everything?apiKey=$API_KEY")
    fun getEverything(@Query("domains") domain:String):Call<News>

    @GET("v2?apiKey=$API_KEY")
    suspend fun getAll():Response<News>


}

val headerInterceptor: Interceptor
    get() = Interceptor { chain ->
        val original = chain.request()
        val requestBuilder = original.newBuilder()
            .header("Authorization", "Bearer NnmNEJonsw3R_kp2dIFNe8Bt2D8ZuDwNY3KhwdH2IqPZGskLbw")
            .header("Content-Type", "application/json")
        val request = requestBuilder.build()
        chain.proceed(request)
    }

val okHttpClient: OkHttpClient
    get() = OkHttpClient.Builder()
        .addInterceptor(headerInterceptor)
        .build()

object NewsServices {
    val newsInstance: NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(Base_Url)
            .client(okHttpClient)  // Pass the OkHttpClient here
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}
