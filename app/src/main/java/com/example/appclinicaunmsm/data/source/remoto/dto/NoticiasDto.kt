package com.example.appclinicaunmsm.data.source.remoto.dto

import com.example.appclinicaunmsm.dominio.model.Noticia

class NoticiasDto : ArrayList<NoticiaDto>() {

    fun getListNoticia() : List<Noticia> {
        var lista = mutableListOf<Noticia>()
        for (dto in this) {
            val noticia = dto.toNoticia()
            lista.add(noticia)
        }
        return lista
    }
}