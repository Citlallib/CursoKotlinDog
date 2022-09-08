package com.vero.cursokotlindog.api

import com.vero.cursokotlindog.Dog

//Permite mejor manejo de errores y acaparar todos sin necesidad de generar else o más código
sealed class ApiResponseStatus {
    class Success(val dogList: List<Dog>) : ApiResponseStatus()
    class Loading() : ApiResponseStatus()
    class Error(val messageId: Int) : ApiResponseStatus()
}