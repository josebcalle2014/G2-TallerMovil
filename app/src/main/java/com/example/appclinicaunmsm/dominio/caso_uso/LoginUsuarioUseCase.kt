package com.example.appclinicaunmsm.dominio.caso_uso

import com.example.appclinicaunmsm.data.repositorio.UsuarioRepositorioImp
import com.example.appclinicaunmsm.dominio.model.Usuario
import com.example.appclinicaunmsm.util.Resultado
import javax.inject.Inject

class LoginUsuarioUseCase @Inject constructor(
    val repositorio: UsuarioRepositorioImp
) {
    suspend operator fun invoke(correo: String): Resultado<Usuario> {
        return repositorio.getUsuario(correo)
    }
}