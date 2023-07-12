package com.example.appclinicaunmsm.dominio.caso_uso

import com.example.appclinicaunmsm.data.repositorio.UsuarioRepositorioImp
import com.example.appclinicaunmsm.data.source.remoto.dto.RegistroDto
import com.example.appclinicaunmsm.util.Resultado
import javax.inject.Inject

class RegistroUsuarioUseCase @Inject constructor(
    val repositorio: UsuarioRepositorioImp
) {
    suspend operator fun invoke(registroDto: RegistroDto): Resultado<Void> {
        return repositorio.crearUsuario(registroDto)
    }
}