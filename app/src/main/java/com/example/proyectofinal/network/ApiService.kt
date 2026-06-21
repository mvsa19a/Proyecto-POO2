package com.example.proyectofinal.network

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @GET("jugador/{id}")
    suspend fun obtenerJugador(
        @Path("id") id: Int
    ): JugadorResponse

    @PUT("jugador/{id}")
    suspend fun actualizarJugador(
        @Path("id") id: Int,
        @Body datos: ActualizarJugadorRequest
    ): JugadorDto

    @PUT("progreso/{idJugador}/{codigoEdificio}")
    suspend fun actualizarProgreso(
        @Path("idJugador") idJugador: Int,
        @Path("codigoEdificio") codigoEdificio: String,
        @Body datos: ActualizarProgresoRequest
    ): ProgresoEdificioDto

    @PUT("progreso/{idJugador}/{codigoEdificio}/reiniciar")
    suspend fun reiniciarEdificio(
        @Path("idJugador") idJugador: Int,
        @Path("codigoEdificio") codigoEdificio: String
    )
}