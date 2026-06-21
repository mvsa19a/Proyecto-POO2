package com.example.proyectofinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.proyectofinal.ui.screens.*
import com.example.proyectofinal.ui.theme.ProyectoFINALTheme

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

                val pantallaActual = remember { mutableStateOf("inicio") }

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

                // Aquí se guardan las preguntas que ya salieron por edificio
                val preguntasUsadasPorEdificio = remember { mutableStateMapOf<String, List<Int>>() }

                val totalNivelesEdificio = 10

                var edificiosDesbloqueados by remember { mutableStateOf(1) }

                when (pantallaActual.value) {

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

                            progresoPorEdificio[nivelSeleccionado] = (nivelPreguntaActual + 1)
                                .coerceAtMost(totalNivelesEdificio)

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
                        },

                        onIncorrecto = {
                            if (vidas > 0) {
                                vidas--
                            }

                            pantallaActual.value = "nivelesEdificio"
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