package com.example.proyectofinal.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EscapeUamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardarJugador(jugador: JugadorLocalEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardarProgreso(progreso: List<ProgresoLocalEntity>)

    @Query("SELECT * FROM jugador_local WHERE idJugador = :idJugador LIMIT 1")
    suspend fun obtenerJugador(idJugador: Int): JugadorLocalEntity?

    @Query("SELECT * FROM progreso_local WHERE idJugador = :idJugador ORDER BY orden")
    suspend fun obtenerProgreso(idJugador: Int): List<ProgresoLocalEntity>

    @Query("""
        UPDATE jugador_local
        SET puntos = :puntos,
            vidas = :vidas,
            edificiosDesbloqueados = :edificiosDesbloqueados
        WHERE idJugador = :idJugador
    """)
    suspend fun actualizarJugador(
        idJugador: Int,
        puntos: Int,
        vidas: Int,
        edificiosDesbloqueados: Int
    )

    @Query("""
        UPDATE progreso_local
        SET nivelActual = :nivelActual,
            completado = :completado
        WHERE idJugador = :idJugador
        AND codigoEdificio = :codigoEdificio
    """)
    suspend fun actualizarProgreso(
        idJugador: Int,
        codigoEdificio: String,
        nivelActual: Int,
        completado: Boolean
    )

    @Query("""
        UPDATE progreso_local
        SET nivelActual = 0,
            completado = 0
        WHERE idJugador = :idJugador
        AND codigoEdificio = :codigoEdificio
    """)
    suspend fun reiniciarEdificio(
        idJugador: Int,
        codigoEdificio: String
    )

    @Query("DELETE FROM progreso_local WHERE idJugador = :idJugador")
    suspend fun eliminarProgreso(idJugador: Int)

    @Query("DELETE FROM jugador_local WHERE idJugador = :idJugador")
    suspend fun eliminarJugador(idJugador: Int)
}