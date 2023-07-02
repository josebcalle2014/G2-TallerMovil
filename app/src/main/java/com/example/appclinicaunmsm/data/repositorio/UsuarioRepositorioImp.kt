package com.example.appclinicaunmsm.data.repositorio

import com.example.appclinicaunmsm.data.source.remoto.dto.RegistroDto
import com.example.appclinicaunmsm.data.source.remoto.dto.UsuarioDto
import com.example.appclinicaunmsm.di.ApiClinicaUNMSM
import com.example.appclinicaunmsm.dominio.model.Usuario
import com.example.appclinicaunmsm.dominio.repositorio.UsuarioRepositorio
import com.example.appclinicaunmsm.util.Resultado
import retrofit2.HttpException
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

    override suspend fun crearUsuario(registroDto: RegistroDto): Resultado<Usuario> {
        val respuesta = try {
            ApiClinicaUNMSM.obtenerApi().registro(registroDto)
        } catch (e: HttpException) {
                return Resultado.Error(e.response().toString())
        } catch (e: Exception) {
                return Resultado.Error("Error desconocido")
        }
        return Resultado.Correcto(respuesta.toUsuario())
    }
}