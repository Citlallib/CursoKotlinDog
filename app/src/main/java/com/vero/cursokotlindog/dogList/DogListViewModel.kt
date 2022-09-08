package com.vero.cursokotlindog.dogList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vero.cursokotlindog.Dog
import com.vero.cursokotlindog.api.ApiResponseStatus
import kotlinx.coroutines.launch
import java.lang.Exception

class DogListViewModel: ViewModel() {
    //LIVEDATA
    //Editar
    private val _dogList = MutableLiveData<List<Dog>>()
    //Para evitar que sea editable de clases que vienen de fuera - livedata
    val dogList: LiveData<List<Dog>>
        get() = _dogList

    private val _status = MutableLiveData<ApiResponseStatus>()
    val status: LiveData<ApiResponseStatus>
        get() = _status

    private val dogRepository = DogRepository()

    init {
        downloadDogs()
    }

    private fun downloadDogs() {
        //Ejecuta corrutina
        viewModelScope.launch{
            _status.value = ApiResponseStatus.LOADING
            try {
                _dogList.value = dogRepository.downloadDogs()
                _status.value = ApiResponseStatus.SUCCESS
            } catch (e: Exception){
                _status.value = ApiResponseStatus.ERROR
            }
        }
    }
}