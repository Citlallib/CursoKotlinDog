package com.vero.cursokotlindog.api.response

import com.squareup.moshi.Json

class SignUpApiResponses(

    val message: String,
    @field: Json(name = "is_success")
    val isSuccess: Boolean,
    val data: UserResponse,
    )