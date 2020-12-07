package com.example.proyectofinalv1.io

import com.example.proyectofinalv1.model.Piece
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("chapters")
    abstract fun listar(): Call<ArrayList<Piece>>

    companion object Factory {
        private const val BASE_URL = "https://onepiececover.com/api/"

        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}