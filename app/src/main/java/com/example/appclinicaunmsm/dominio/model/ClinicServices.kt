package com.example.appclinicaunmsm.dominio.model

data class ClinicServices(
    override var title: String,
    override var description: String,
    override var imageUrl: String
) : Item{
}