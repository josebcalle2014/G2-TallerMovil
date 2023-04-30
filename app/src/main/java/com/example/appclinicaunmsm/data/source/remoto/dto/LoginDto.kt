package com.example.appclinicaunmsm.data.source.remoto.dto

import com.example.appclinicaunmsm.dominio.model.LoginModelos.Login
import com.example.appclinicaunmsm.dominio.model.LoginModelos.LoginRespuesta

data class LoginDto(
    val errors: String?="",
    val response: LoginRespuesta,
    val success: Boolean
)

fun LoginDto.aLogin():Login{
    return Login(errors,response,success)
}