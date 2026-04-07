package com.example.examenretrofitjordi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelLogin: ViewModel() {
    private val _loginResult = MutableLiveData<Boolean>()
    var loginResult: LiveData<Boolean> = _loginResult

    private val _errorMessage = MutableLiveData<String>()
    var errorMessage: LiveData<String> = _errorMessage

    fun login(name: String, password: String){
        if(!name.equals("2023_jordimasip2003@iticbcn.cat")){
            _errorMessage.value = "El nombre esta incorrecto"
            return
        }

        if (!password.equals("1357924680")){
            _errorMessage.value = "La password no es correcta"
            return
        }

        _errorMessage.value = null
        _loginResult.value = true
    }
}