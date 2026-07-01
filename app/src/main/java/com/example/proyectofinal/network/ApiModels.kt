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

data class AuthRequest(
    val usuario: String,
    val contrasena: String
)

data class AuthResponse(
    val mensaje: String,
    val jugador: JugadorDto
)
data class PreguntaDto(
    @SerializedName("id_pregunta")
    val idPregunta: Int,

    @SerializedName("codigo_edificio")
    val codigoEdificio: String,

    @SerializedName("numero_pregunta")
    val numeroPregunta: Int,

    val titulo: String,
    val dificultad: String,
    val pista: String,

    @SerializedName("texto_pregunta")
    val textoPregunta: String,

    @SerializedName("opcion_a")
    val opcionA: String,

    @SerializedName("opcion_b")
    val opcionB: String,

    @SerializedName("opcion_c")
    val opcionC: String,

    @SerializedName("respuesta_correcta")
    val respuestaCorrecta: String,

    val recompensa: Int
)