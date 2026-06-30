package com.example.proyectofinal.network

import com.google.gson.annotations.SerializedName

data class JugadorRanking(
    @SerializedName("usuario")
    val nombre: String,

    val puntos: Int
)