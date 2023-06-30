package com.example.appclinicaunmsm.dominio.repositorio

import com.example.appclinicaunmsm.data.source.remoto.dto.UsuarioDto
import com.example.appclinicaunmsm.dominio.model.Usuario
import com.example.appclinicaunmsm.util.Resultado

interface UsuarioRepositorio {
    suspend fun getUsuario(correo: String): Resultado<Usuario>
    suspend fun crearUsuario(usuarioDto: UsuarioDto): Resultado<Usuario>
}