package com.vero.cursokotlindog.dogList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vero.cursokotlindog.Dog
import kotlinx.coroutines.launch

class DogListViewModel: ViewModel() {
    //LIVEDATA
    //Editar
    private val _dogList = MutableLiveData<List<Dog>>()
    //Para evitar que sea editable de clases que vienen de fuera - livedata
    val dogList: LiveData<List<Dog>>
        get() = _dogList

    private val dogRepository = DogRepository()

    init {
        downloadDogs()
    }

    private fun downloadDogs() {
        //Ejecuta corrutina
        viewModelScope.launch{
           _dogList.value = dogRepository.downloadDogs()
        }
    }
}