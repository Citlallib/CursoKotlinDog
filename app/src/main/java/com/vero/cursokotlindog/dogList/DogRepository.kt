package com.vero.cursokotlindog.dogList

import com.vero.cursokotlindog.Dog
import com.vero.cursokotlindog.api.DogsApi.retrofitService
import com.vero.cursokotlindog.dto.DogDTOMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {
    suspend fun downloadDogs(): List<Dog>{
        //Dispatchers en que se va a utilizar una corruitina
        //IO descargar de Internet - tomar de la BD
        //MAIN se usa en el hilo principal
        return withContext(Dispatchers.IO) {
            val dogListApiResponse = retrofitService.getAllDogs()
            val dogDTOList = dogListApiResponse.data.dogs
            val dogDTOMapper = DogDTOMapper()
            dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOList)
        }
    }
}