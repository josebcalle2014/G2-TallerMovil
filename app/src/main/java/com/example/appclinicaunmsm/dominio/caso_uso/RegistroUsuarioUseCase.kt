package com.example.appclinicaunmsm.dominio.caso_uso

import com.example.appclinicaunmsm.data.repositorio.UsuarioRepositorioImp
import com.example.appclinicaunmsm.data.source.remoto.dto.UsuarioDto
import com.example.appclinicaunmsm.dominio.model.Usuario
import com.example.appclinicaunmsm.util.Resultado
import javax.inject.Inject

class RegistroUsuarioUseCase @Inject constructor(
    val repositorio: UsuarioRepositorioImp
) {
    suspend operator fun invoke(usuarioDto: UsuarioDto): Resultado<Usuario> {
        return repositorio.crearUsuario(usuarioDto)
    }
}