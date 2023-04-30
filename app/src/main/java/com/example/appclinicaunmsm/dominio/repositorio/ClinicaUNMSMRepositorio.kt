package com.example.appclinicaunmsm.dominio.repositorio

import com.example.appclinicaunmsm.data.source.remoto.dto.LoginDto
import com.example.appclinicaunmsm.dominio.model.LoginModelos.LoginInicioSesion

interface ClinicaUNMSMRepositorio {
    suspend fun validarDatos(loginInicioSesion: LoginInicioSesion):LoginDto
}