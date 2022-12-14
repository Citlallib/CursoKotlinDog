package com.vero.cursokotlindog.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vero.cursokotlindog.api.ApiResponseStatus
import com.vero.cursokotlindog.model.User
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {
    private val _user = MutableLiveData<User>()

    //Para evitar que sea editable de clases que vienen de fuera - livedata
    val user: LiveData<User>
        get() = _user

    private val _status = MutableLiveData<ApiResponseStatus<User>>()
    val status: LiveData<ApiResponseStatus<User>>
        get() = _status

    private val authRepository = AuthRepository()

    fun signUp(email: String, password: String, confirmPassword: String){
        viewModelScope.launch {
            _status.value = ApiResponseStatus.Loading()
            handleResponseStatus(authRepository.signUp(email, password, confirmPassword))
        }
    }
    private fun handleResponseStatus(apiResponseStatus: ApiResponseStatus<User>) {
        if (apiResponseStatus is ApiResponseStatus.Success){
            _user.value = apiResponseStatus.data!!
        }
        _status.value = apiResponseStatus
    }

}