package com.vero.cursokotlindog.api

import com.vero.cursokotlindog.BASE_URL
import com.vero.cursokotlindog.GET_ALL_DOGS_URL
import com.vero.cursokotlindog.api.response.DogListApiResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

interface ApiService{
    @GET(GET_ALL_DOGS_URL)
    suspend fun getAllDogs(): DogListApiResponse
}

//Tomar el service para utilizarlo
object DogsApi{
    //Variable para acceder a los metodos
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}