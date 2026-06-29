package com.example.proyectofinal.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jugador_local")
data class JugadorLocalEntity(
    @PrimaryKey
    val idJugador: Int,
    val nombre: String,
    val usuario: String?,
    val puntos: Int,
    val vidas: Int,
    val edificiosDesbloqueados: Int
)