package com.example.conectiontestapi.api

import retrofit2.Call
import retrofit2.http.GET

interface PotterApi {
    @GET("characters")
    fun getPotterApi(): Call<List<PersonApi>>

}