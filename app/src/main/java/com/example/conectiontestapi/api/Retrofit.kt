package com.example.conectiontestapi.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {

    companion object{
        private const val BASE_URL = "https://hp-api.herokuapp.com/api/"
        private lateinit var retrofit: Retrofit

        private fun getRetrofit(): Retrofit{

            val httpClient = OkHttpClient.Builder()
            if (!::retrofit.isInitialized){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit
        }

        fun <S> createService(service: Class<S>): S{
            return getRetrofit().create(service)
        }

    }
}