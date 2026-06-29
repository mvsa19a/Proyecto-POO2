package com.example.proyectofinal.local

import androidx.room.Entity

@Entity(
    tableName = "progreso_local",
    primaryKeys = ["idJugador", "codigoEdificio"]
)
data class ProgresoLocalEntity(
    val idJugador: Int,
    val codigoEdificio: String,
    val nombre: String,
    val descripcion: String,
    val orden: Int,
    val nivelActual: Int,
    val completado: Boolean
)