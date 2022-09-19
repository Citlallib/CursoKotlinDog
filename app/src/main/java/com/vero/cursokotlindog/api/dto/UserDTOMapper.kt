package com.vero.cursokotlindog.api.dto

import com.vero.cursokotlindog.model.User

class UserDTOMapper {
    fun fromUserDTOToUserDomain(userDto: UserDto): User =
        User(userDto.id, userDto.email, userDto.authenticationToken)
}