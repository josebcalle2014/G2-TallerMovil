package com.example.appclinicaunmsm.presentacion.vistas.login

data class LoginState (
    val correo: String = "",
    val contrasenia: String = "",
    val botonActivo: Boolean = false,
    val isLoading: Boolean = false,
    val login: Boolean = false
)