package com.example.appclinicaunmsm.data.repositorio

import com.example.appclinicaunmsm.data.source.remoto.dto.UsuarioDto
import com.example.appclinicaunmsm.di.ApiClinicaUNMSM
import com.example.appclinicaunmsm.dominio.model.Usuario
import com.example.appclinicaunmsm.dominio.repositorio.UsuarioRepositorio
import com.example.appclinicaunmsm.util.Resultado
import javax.inject.Inject

class UsuarioRepositorioImp @Inject constructor() : UsuarioRepositorio {

    override suspend fun getUsuario(correo: String): Resultado<Usuario>{
        val respuesta = try {
            ApiClinicaUNMSM.obtenerApi().validarDatos(correo)
        } catch (e: Exception) {
            return Resultado.Error("Error desconocido")
        }
        return Resultado.Correcto(respuesta.toUsuario())
    }

    override suspend fun crearUsuario(usuarioDto: UsuarioDto): Resultado<Usuario> {
        val respuesta = try {
            ApiClinicaUNMSM.obtenerApi().registro(usuarioDto)
        } catch (e: Exception) {
            return Resultado.Error("Error desconocido")
        }
        return Resultado.Correcto(respuesta.toUsuario())
    }
}