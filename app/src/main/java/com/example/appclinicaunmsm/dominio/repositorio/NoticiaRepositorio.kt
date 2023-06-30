package com.example.appclinicaunmsm.dominio.repositorio

import com.example.appclinicaunmsm.dominio.model.Noticia
import com.example.appclinicaunmsm.util.Resultado
import kotlinx.coroutines.flow.Flow

interface NoticiaRepositorio {

    fun getNoticias(): Flow<Resultado<List<Noticia>>>
}