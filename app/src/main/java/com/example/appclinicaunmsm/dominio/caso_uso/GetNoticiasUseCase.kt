package com.example.appclinicaunmsm.dominio.caso_uso

import com.example.appclinicaunmsm.dominio.model.Noticia
import com.example.appclinicaunmsm.dominio.repositorio.NoticiaRepositorio
import com.example.appclinicaunmsm.util.Resultado
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNoticiasUseCase @Inject constructor(
    private val repositorio: NoticiaRepositorio
){
    operator fun invoke(): Flow<Resultado<List<Noticia>>> {
        return repositorio.getNoticias()
    }
}