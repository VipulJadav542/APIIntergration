package com.rk.apiintegration.MyRetrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val Base_Url="https://jsonplaceholder.typicode.com/"

interface RetrofirInterface {
    @GET("/posts")
    fun getAllData():Call<DataClass>
}

object RetrofitServices
{
    val interfaces:RetrofirInterface
    init {
        val retrofit=Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        interfaces=retrofit.create(RetrofirInterface::class.java)
    }
}