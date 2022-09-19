package com.vero.cursokotlindog.api.dto

import com.squareup.moshi.Json
import retrofit2.http.Field

//TODOS LOS OBJETOS QUE TENGAN QUE VER CON ENVIAR Y RECIBIR DATOS DE INTERNET SE DEBRAN LLAMAR DTO

class SignUpDTO (
    val email: String,
    val password: String,
    @field:Json(name = "password_confirmation")
    val confirmPassword: String
    )