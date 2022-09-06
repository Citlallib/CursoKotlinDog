package com.vero.cursokotlindog.api

import com.vero.cursokotlindog.BASE_URL
import com.vero.cursokotlindog.Dog
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

interface ApiService{
    @GET("dogs")
    suspend fun getAllDogs(): List<Dog>
}

//Tomar el service para utilizarlo
object DogsApi{
    //Variable para acceder a los metodos
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}