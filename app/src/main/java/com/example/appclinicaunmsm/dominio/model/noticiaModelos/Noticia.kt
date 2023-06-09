package com.example.appclinicaunmsm.dominio.model.noticiaModelos

import com.example.appclinicaunmsm.adapter.Item
import com.google.gson.annotations.SerializedName

data class Noticia(
    @SerializedName("title")
    override var titulo: String,
    @SerializedName("body")
    override var descripcion: String,
    @SerializedName("userId")
    override var urlImagen: String,
    @SerializedName("id")
    var id: String,
) : Item