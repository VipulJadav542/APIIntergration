package com.rk.apiintegration.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    val api = "https://quotable.io/"

    fun getInstance(): Retrofit {
        return  Retrofit.Builder().baseUrl(api)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}