package com.vero.cursokotlindog.dogList

import com.vero.cursokotlindog.Dog
import com.vero.cursokotlindog.api.ApiResponseStatus
import com.vero.cursokotlindog.api.DogsApi.retrofitService
import com.vero.cursokotlindog.api.dto.DogDTOMapper
import com.vero.cursokotlindog.api.makeNetworkCall

class DogRepository {
    //Usa el ApiResponseStatus <con el tipo de dato que se quiere obtener>
    suspend fun downloadDogs(): ApiResponseStatus<List<Dog>> {
        return makeNetworkCall {
            val dogListApiResponse = retrofitService.getAllDogs()
            val dogDTOList = dogListApiResponse.data.dogs
            val dogDTOMapper = DogDTOMapper()
            dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOList)
        }
    }
}