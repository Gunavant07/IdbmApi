package com.example.idbmapi.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {

        val BASEURL = "https://imdb8.p.rapidapi.com/"

        fun getRetrofit(): Retrofit {
            var retrofit = Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }
    }

}