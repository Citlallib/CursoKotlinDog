package com.vero.cursokotlindog.api

import com.vero.cursokotlindog.Dog

//Permite mejor manejo de errores y acaparar todos sin necesidad de generar else o más código
sealed class ApiResponseStatus<T> {
    class Success<T>(val data: T) : ApiResponseStatus<T>()
    class Loading<T>() : ApiResponseStatus<T>()
    class Error<T>(val messageId: Int) : ApiResponseStatus<T>()
}