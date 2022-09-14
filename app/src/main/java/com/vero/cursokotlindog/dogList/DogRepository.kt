package com.vero.cursokotlindog.dogList

import com.vero.cursokotlindog.Dog
import com.vero.cursokotlindog.R
import com.vero.cursokotlindog.api.ApiResponseStatus
import com.vero.cursokotlindog.api.DogsApi.retrofitService
import com.vero.cursokotlindog.dto.DogDTOMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.net.UnknownHostException

class DogRepository {
    //Usa el ApiResponseStatus <con el tipo de dato que se quiere obtener>
    suspend fun downloadDogs(): ApiResponseStatus<List<Dog>>{
        //Dispatchers en que se va a utilizar una corruitina
        //IO descargar de Internet - tomar de la BD
        //MAIN se usa en el hilo principal
        return withContext(Dispatchers.IO) {
            try {
                val dogListApiResponse = retrofitService.getAllDogs()
                val dogDTOList = dogListApiResponse.data.dogs
                val dogDTOMapper = DogDTOMapper()
                ApiResponseStatus.Success(dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOList))
            }catch (e: UnknownHostException){
                ApiResponseStatus.Error(R.string.error_unknown_host_exception)
            }catch (e: Exception){
                ApiResponseStatus.Error(R.string.error_unknown)
            }

        }
    }
}