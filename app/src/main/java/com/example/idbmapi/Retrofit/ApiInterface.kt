package com.example.idbmapi.Retrofit

import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface ApiInterface {

    @GET("auto-complete")
    fun getData(@Query("q")q:String, @Header("X-RapidAPI-Key")key:String, @Header("X-RapidAPI-Host")host:String) : Call<Modeldata>
}