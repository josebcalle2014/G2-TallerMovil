package com.example.appclinicaunmsm.data.source.remoto.dto

import com.example.appclinicaunmsm.dominio.model.Noticia

data class NoticiaDto(
    val estado: Int,
    val id_noticia: Int,
    val img_noticia: String,
    val url_noticia: String
) {
    fun toNoticia() : Noticia {
        return Noticia(id_noticia.toString(), url_noticia, img_noticia)
    }
}