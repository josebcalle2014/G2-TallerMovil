package com.example.appclinicaunmsm.dominio.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _loginEnabled = MutableLiveData<Boolean>()
    val loginEnabled: LiveData<Boolean> = _loginEnabled

    fun onLoginChanged(username: String, password: String) {
        _username.value = username
        _password.value = password
        _loginEnabled.value = isValidUsername(username) && isInvalidPassword(password)
    }

    // TODO: Agregar validaciones para usuario
    private fun isValidUsername(username: String): Boolean {
        return true;
    }

    // TODO: Agregar validaciones para contraseña
    private fun isInvalidPassword(password: String): Boolean {
        return password.length > 6;
    }

    // TODO: Agregar comunicación con api
    fun onLoginSelected() {

    }

}