package com.example.appclinicaunmsm.dominio.model.noticiaModelos

import com.example.appclinicaunmsm.adapter.Item
import com.google.gson.annotations.SerializedName

data class Noticia(
    //TODO: Revisar atributos de noticia
    @SerializedName("id_noticia")
    override var id: String,
    @SerializedName("url_noticia")
    override var titulo: String,
    @SerializedName("estado")
    override var descripcion: String,
    @SerializedName("img_noticia")
    override var urlImagen: String,
) : Item