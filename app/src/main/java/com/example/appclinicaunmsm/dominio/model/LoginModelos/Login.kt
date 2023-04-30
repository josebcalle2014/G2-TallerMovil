package com.example.appclinicaunmsm.dominio.model.LoginModelos

import java.lang.Exception

data class Login(
    val errors:String?="",
    val response: LoginRespuesta,
    val success: Boolean
)

class UsuarioInvalidoException(mensaje:String):Exception(mensaje)