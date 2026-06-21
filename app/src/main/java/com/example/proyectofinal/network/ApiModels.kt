package com.example.proyectofinal.network

import com.google.gson.annotations.SerializedName

data class JugadorDto(
    @SerializedName("id_jugador")
    val idJugador: Int,

    val nombre: String,
    val puntos: Int,
    val vidas: Int,

    @SerializedName("edificios_desbloqueados")
    val edificiosDesbloqueados: Int
)

data class ProgresoEdificioDto(
    @SerializedName("codigo_edificio")
    val codigoEdificio: String,

    val nombre: String,
    val descripcion: String,
    val orden: Int,

    @SerializedName("nivel_actual")
    val nivelActual: Int,

    val completado: Boolean
)

data class JugadorResponse(
    val jugador: JugadorDto,
    val progreso: List<ProgresoEdificioDto>
)

data class ActualizarJugadorRequest(
    val puntos: Int,
    val vidas: Int,

    @SerializedName("edificios_desbloqueados")
    val edificiosDesbloqueados: Int
)

data class ActualizarProgresoRequest(
    @SerializedName("nivel_actual")
    val nivelActual: Int,

    val completado: Boolean
)