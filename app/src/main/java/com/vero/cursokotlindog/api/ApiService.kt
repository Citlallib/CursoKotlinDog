package com.vero.cursokotlindog.api

import com.vero.cursokotlindog.BASE_URL
import com.vero.cursokotlindog.GET_ALL_DOGS_URL
import com.vero.cursokotlindog.SIGN_UP_URL
import com.vero.cursokotlindog.api.dto.SignUpDTO
import com.vero.cursokotlindog.api.response.DogListApiResponse
import com.vero.cursokotlindog.api.response.SignUpApiResponses
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

interface ApiService{
    @GET(GET_ALL_DOGS_URL)
    suspend fun getAllDogs(): DogListApiResponse

    @POST(SIGN_UP_URL)
    suspend fun signUp(@Body signUpDTO: SignUpDTO): SignUpApiResponses
}

//Tomar el service para utilizarlo
object DogsApi{
    //Variable para acceder a los metodos
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}