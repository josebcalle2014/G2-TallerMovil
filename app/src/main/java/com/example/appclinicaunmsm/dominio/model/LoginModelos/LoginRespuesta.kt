package com.example.appclinicaunmsm.dominio.model.LoginModelos

data class LoginRespuesta(
    val nRetorno: Int,
    val oUsuario: LoginDatosUsuario,
    val sRetorno: String
)