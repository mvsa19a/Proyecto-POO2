package com.example.proyectofinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.proyectofinal.ui.screens.*
import com.example.proyectofinal.ui.theme.ProyectoFINALTheme
import com.example.proyectofinal.network.ActualizarJugadorRequest
import com.example.proyectofinal.network.ActualizarProgresoRequest
import com.example.proyectofinal.network.RetrofitClient
import kotlinx.coroutines.launch
import com.example.proyectofinal.local.EscapeUamDatabase
import com.example.proyectofinal.local.JugadorLocalEntity
import com.example.proyectofinal.local.ProgresoLocalEntity

data class EdificioInfo(
    val codigo: String,
    val nombre: String,
    val descripcion: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ProyectoFINALTheme {

                val dao = remember {
                    EscapeUamDatabase.getDatabase(applicationContext).escapeUamDao()
                }

                val pantallaActual = remember { mutableStateOf("acceso") }
                val scope = rememberCoroutineScope()

                // Por ahora queda fijo para que Luis luego lo conecte con usuario real desde la API.
                val idJugador = 1

                var usuarioActual by remember { mutableStateOf("") }

                val edificios = listOf(
                    EdificioInfo("edificioA", "Edificio A", "Admisión, Registro Académico y Producción Audiovisual"),
                    EdificioInfo("edificioE", "Edificio E", "Medicina"),
                    EdificioInfo("edificioJ", "Edificio J", "Odontología"),
                    EdificioInfo("edificioP", "Edificio P", "Copérnico"),
                    EdificioInfo("edificioO", "Edificio O", "Ingeniería y Arquitectura"),
                    EdificioInfo("edificioK", "Edificio K", "Sección Deportiva"),
                    EdificioInfo("edificioF", "Edificio F", "Ciencias Jurídicas"),
                    EdificioInfo("edificioI", "Edificio I", "Ciencias Comerciales, Administrativas y Económicas")
                )

                val ordenEdificios = edificios.map { it.codigo }

                var puntos by remember { mutableStateOf(0) }
                var vidas by remember { mutableStateOf(3) }

                var nivelSeleccionado by remember { mutableStateOf("edificioA") }
                var nivelPreguntaActual by remember { mutableStateOf(0) }
                var edificioSeleccionado by remember { mutableStateOf("edificioA") }

                val progresoPorEdificio = remember { mutableStateMapOf<String, Int>() }

                // Aquí se guardan las preguntas que ya salieron por edificio.
                val preguntasUsadasPorEdificio = remember { mutableStateMapOf<String, List<Int>>() }

                val totalNivelesEdificio = 10

                var edificiosDesbloqueados by remember { mutableStateOf(1) }

                LaunchedEffect(Unit) {
                    try {
                        val respuesta = RetrofitClient.api.obtenerJugador(idJugador)

                        puntos = respuesta.jugador.puntos
                        vidas = respuesta.jugador.vidas
                        edificiosDesbloqueados = respuesta.jugador.edificiosDesbloqueados

                        progresoPorEdificio.clear()

                        respuesta.progreso.forEach { progreso ->
                            progresoPorEdificio[progreso.codigoEdificio] = progreso.nivelActual
                        }

                        // Guardar copia local en Room
                        dao.guardarJugador(
                            JugadorLocalEntity(
                                idJugador = respuesta.jugador.idJugador,
                                nombre = respuesta.jugador.nombre,
                                usuario = null,
                                puntos = respuesta.jugador.puntos,
                                vidas = respuesta.jugador.vidas,
                                edificiosDesbloqueados = respuesta.jugador.edificiosDesbloqueados
                            )
                        )

                        dao.guardarProgreso(
                            respuesta.progreso.map { progreso ->
                                ProgresoLocalEntity(
                                    idJugador = respuesta.jugador.idJugador,
                                    codigoEdificio = progreso.codigoEdificio,
                                    nombre = progreso.nombre,
                                    descripcion = progreso.descripcion,
                                    orden = progreso.orden,
                                    nivelActual = progreso.nivelActual,
                                    completado = progreso.completado
                                )
                            }
                        )

                    } catch (e: Exception) {
                        e.printStackTrace()

                        // Si falla la API, cargamos desde Room
                        val jugadorLocal = dao.obtenerJugador(idJugador)
                        val progresoLocal = dao.obtenerProgreso(idJugador)

                        if (jugadorLocal != null) {
                            puntos = jugadorLocal.puntos
                            vidas = jugadorLocal.vidas
                            edificiosDesbloqueados = jugadorLocal.edificiosDesbloqueados

                            progresoPorEdificio.clear()

                            progresoLocal.forEach { progreso ->
                                progresoPorEdificio[progreso.codigoEdificio] = progreso.nivelActual
                            }
                        }
                    }
                }

                when (pantallaActual.value) {

                    "acceso" -> PantallaAcceso(
                        onCrearUsuario = {
                            pantallaActual.value = "crearUsuario"
                        },
                        onLogin = {
                            pantallaActual.value = "login"
                        }
                    )

                    "crearUsuario" -> PantallaCrearUsuario(
                        onUsuarioCreado = { usuario, _ ->
                            usuarioActual = usuario
                            pantallaActual.value = "inicio"
                        },
                        onBack = {
                            pantallaActual.value = "acceso"
                        }
                    )

                    "login" -> PantallaLogin(
                        onLoginExitoso = { usuario, _ ->
                            usuarioActual = usuario
                            pantallaActual.value = "inicio"
                        },
                        onBack = {
                            pantallaActual.value = "acceso"
                        }
                    )

                    "inicio" -> PantallaInicio(
                        onStart = {
                            pantallaActual.value = "menu"
                        },
                        onInstructions = {
                            pantallaActual.value = "instrucciones"
                        }
                    )

                    "instrucciones" -> PantallaInstrucciones(
                        onComenzar = {
                            pantallaActual.value = "menu"
                        },
                        onBack = {
                            pantallaActual.value = "inicio"
                        }
                    )

                    "menu" -> PantallaMenu(
                        puntos = puntos,
                        vidas = vidas,
                        onIrNiveles = {
                            pantallaActual.value = "niveles"
                        },
                        onBack = {
                            pantallaActual.value = "inicio"
                        }
                    )

                    "niveles" -> PantallaNiveles(
                        edificiosDesbloqueados = edificiosDesbloqueados,

                        onEdificioSeleccionado = { edificio ->
                            edificioSeleccionado = edificio

                            nivelPreguntaActual = (progresoPorEdificio[edificio] ?: 0)
                                .coerceIn(0, totalNivelesEdificio - 1)

                            pantallaActual.value = "nivelesEdificio"
                        },

                        onBack = {
                            pantallaActual.value = "menu"
                        }
                    )

                    "nivelesEdificio" -> {
                        val infoEdificio = edificios.firstOrNull { it.codigo == edificioSeleccionado }
                            ?: edificios.first()

                        NivelesEdificioScreen(
                            edificioCodigo = edificioSeleccionado,
                            nombreEdificio = infoEdificio.nombre,
                            descripcionEdificio = infoEdificio.descripcion,
                            progresoActual = (progresoPorEdificio[edificioSeleccionado] ?: 0)
                                .coerceIn(0, totalNivelesEdificio),
                            totalNiveles = totalNivelesEdificio,

                            onNivelSeleccionado = { nivel ->
                                nivelPreguntaActual = nivel
                                nivelSeleccionado = edificioSeleccionado
                                pantallaActual.value = "reto"
                            },

                            onBack = {
                                pantallaActual.value = "niveles"
                            }
                        )
                    }

                    "exploracion" -> PantallaExploracion(
                        onPistaEncontrada = {
                            puntos += 15
                            pantallaActual.value = "reto"
                        },
                        onBack = {
                            pantallaActual.value = "nivelesEdificio"
                        }
                    )

                    "reto" -> PantallaReto(
                        nivel = nivelSeleccionado,
                        numeroNivel = nivelPreguntaActual,
                        totalNivelesEdificio = totalNivelesEdificio,
                        mostrarSiguienteNivel = nivelPreguntaActual < totalNivelesEdificio - 1,

                        preguntasUsadas = preguntasUsadasPorEdificio[nivelSeleccionado] ?: emptyList(),

                        onPreguntaUsada = { idPregunta ->
                            val preguntasActuales = preguntasUsadasPorEdificio[nivelSeleccionado]
                                ?.toMutableList()
                                ?: mutableListOf()

                            if (!preguntasActuales.contains(idPregunta)) {
                                preguntasActuales.add(idPregunta)
                                preguntasUsadasPorEdificio[nivelSeleccionado] = preguntasActuales
                            }
                        },

                        onCorrecto = { recompensa ->
                            puntos += recompensa

                            val nuevoProgreso = (nivelPreguntaActual + 1)
                                .coerceAtMost(totalNivelesEdificio)

                            progresoPorEdificio[nivelSeleccionado] = nuevoProgreso

                            val esUltimoNivelDelEdificio = nivelPreguntaActual >= totalNivelesEdificio - 1

                            if (esUltimoNivelDelEdificio) {
                                val indiceSeleccionado = ordenEdificios.indexOf(nivelSeleccionado)
                                val ultimoDesbloqueado = edificiosDesbloqueados - 1

                                if (
                                    indiceSeleccionado == ultimoDesbloqueado &&
                                    edificiosDesbloqueados < ordenEdificios.size
                                ) {
                                    edificiosDesbloqueados++
                                }
                            }

                            scope.launch {
                                try {
                                    RetrofitClient.api.actualizarJugador(
                                        id = idJugador,
                                        datos = ActualizarJugadorRequest(
                                            puntos = puntos,
                                            vidas = vidas,
                                            edificiosDesbloqueados = edificiosDesbloqueados
                                        )
                                    )

                                    RetrofitClient.api.actualizarProgreso(
                                        idJugador = idJugador,
                                        codigoEdificio = nivelSeleccionado,
                                        datos = ActualizarProgresoRequest(
                                            nivelActual = nuevoProgreso,
                                            completado = nuevoProgreso >= totalNivelesEdificio
                                        )
                                    )

                                } catch (e: Exception) {
                                    e.printStackTrace()
                                }
                                dao.actualizarJugador(
                                    idJugador = idJugador,
                                    puntos = puntos,
                                    vidas = vidas,
                                    edificiosDesbloqueados = edificiosDesbloqueados
                                )

                                dao.actualizarProgreso(
                                    idJugador = idJugador,
                                    codigoEdificio = nivelSeleccionado,
                                    nivelActual = nuevoProgreso,
                                    completado = nuevoProgreso >= totalNivelesEdificio
                                )
                            }
                        },

                        onIncorrecto = {
                            vidas--

                            if (vidas <= 0) {
                                vidas = 3

                                preguntasUsadasPorEdificio.remove(nivelSeleccionado)
                                progresoPorEdificio[nivelSeleccionado] = 0
                                nivelPreguntaActual = 0
                                edificioSeleccionado = nivelSeleccionado

                                pantallaActual.value = "nivelesEdificio"

                                scope.launch {
                                    try {
                                        RetrofitClient.api.reiniciarEdificio(
                                            idJugador = idJugador,
                                            codigoEdificio = nivelSeleccionado
                                        )

                                        RetrofitClient.api.actualizarJugador(
                                            id = idJugador,
                                            datos = ActualizarJugadorRequest(
                                                puntos = puntos,
                                                vidas = vidas,
                                                edificiosDesbloqueados = edificiosDesbloqueados
                                            )
                                        )

                                    } catch (e: Exception) {
                                        e.printStackTrace()
                                    }

                                    dao.actualizarJugador(
                                        idJugador = idJugador,
                                        puntos = puntos,
                                        vidas = vidas,
                                        edificiosDesbloqueados = edificiosDesbloqueados
                                    )

                                    dao.reiniciarEdificio(
                                        idJugador = idJugador,
                                        codigoEdificio = nivelSeleccionado
                                    )
                                }

                            } else {
                                scope.launch {
                                    try {
                                        RetrofitClient.api.actualizarJugador(
                                            id = idJugador,
                                            datos = ActualizarJugadorRequest(
                                                puntos = puntos,
                                                vidas = vidas,
                                                edificiosDesbloqueados = edificiosDesbloqueados
                                            )
                                        )
                                    } catch (e: Exception) {
                                        e.printStackTrace()
                                    }

                                    dao.actualizarJugador(
                                        idJugador = idJugador,
                                        puntos = puntos,
                                        vidas = vidas,
                                        edificiosDesbloqueados = edificiosDesbloqueados
                                    )
                                }
                            }
                        },

                        onVolverANiveles = {
                            pantallaActual.value = "nivelesEdificio"
                        },

                        onSiguienteNivel = {
                            if (nivelPreguntaActual < totalNivelesEdificio - 1) {
                                nivelPreguntaActual++
                            } else {
                                pantallaActual.value = "nivelesEdificio"
                            }
                        },

                        onBack = {
                            pantallaActual.value = "nivelesEdificio"
                        }
                    )
                }
            }
        }
    }
}