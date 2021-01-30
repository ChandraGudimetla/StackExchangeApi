package com.example.retrofit_stackexchangeapi.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestProvider {
    private val baseUrl = "https://api.stackexchange.com"
    private var mRetrofit: Retrofit? = null

    val client: Retrofit
    get() {
        if (mRetrofit == null) {
            mRetrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return this.mRetrofit!!
    }

}