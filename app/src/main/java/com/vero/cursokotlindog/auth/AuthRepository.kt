package com.vero.cursokotlindog.auth

import com.vero.cursokotlindog.api.ApiResponseStatus
import com.vero.cursokotlindog.api.DogsApi
import com.vero.cursokotlindog.api.dto.DogDTOMapper
import com.vero.cursokotlindog.api.dto.SignUpDTO
import com.vero.cursokotlindog.api.dto.UserDTOMapper
import com.vero.cursokotlindog.api.makeNetworkCall
import com.vero.cursokotlindog.model.User
import java.lang.Exception

class AuthRepository {
    suspend fun signUp(
        email: String,
        password: String,
        confirmPassword: String
    ): ApiResponseStatus<User> = makeNetworkCall {
        val signUpDTO = SignUpDTO(email, password, confirmPassword)
        val signUpResponse = DogsApi.retrofitService.signUp(signUpDTO)

        if (!signUpResponse.isSuccess){
            throw Exception(signUpResponse.message)
        }

        val userDTO = signUpResponse.data.user
        val userDTOMApper = UserDTOMapper()
        userDTOMApper.fromUserDTOToUserDomain(userDTO)
    }
}