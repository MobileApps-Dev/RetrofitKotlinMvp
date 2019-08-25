package com.example.retrofitkotlinmvp

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import  retrofit2.converter.gson.GsonConverterFactory

object RestClient {


    fun create(): ApiInterface {
        val client = OkHttpClient().newBuilder().addInterceptor(HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE

        }).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://13.234.47.78")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiInterface::class.java)
    }
}