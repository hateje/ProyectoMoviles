package com.example.caso.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize

data class Propiedad (
    var id: String,
    val nombre: String,
    val descripcion: String,
    val habitaciones: Int,
    val pisos: Int,
    val banos: Int,
    val precio: Long,
    val nombreCorredor: String,
    val telefonoCorredor: String

): Parcelable {
    constructor():
            this ("","","",0,0,0,0,"","")
}
