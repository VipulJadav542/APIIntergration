package com.rk.apiintegration.Retrofit

import retrofit2.http.GET

interface myInterface
{
    @GET("/Quotes")
    suspend fun getQuotes():retrofit2.Response<QuoteList>
}