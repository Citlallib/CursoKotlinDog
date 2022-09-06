package com.vero.cursokotlindog.dogList

import com.vero.cursokotlindog.Dog
import com.vero.cursokotlindog.api.DogsApi
import com.vero.cursokotlindog.api.DogsApi.retrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {
    suspend fun downloadDogs(): List<Dog>{
        //Dispatchers en que se va a utilizar una corruitina
        //IO descargar de Internet - tomar de la BD
        //MAIN se usa en el hilo principal
        return withContext(Dispatchers.IO) {
            val dogListApiResponde = retrofitService.getAllDogs()
            dogListApiResponde.data.dogs
        }
    }
}