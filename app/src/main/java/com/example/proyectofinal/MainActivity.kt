package com.example.proyectofinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.proyectofinal.ui.screens.*
import com.example.proyectofinal.ui.theme.ProyectoFINALTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ProyectoFINALTheme {

                val pantallaActual = remember { mutableStateOf("inicio") }
                var puntos by remember { mutableStateOf(0) }
                var vidas by remember { mutableStateOf(3) }
                var nivelSeleccionado by remember { mutableStateOf("edificioA") }

                when (pantallaActual.value) {

                    "inicio" -> PantallaInicio(
                        onStart = { pantallaActual.value = "menu" },
                        onInstructions = { pantallaActual.value = "instrucciones" }

                    )
                    "instrucciones" -> PantallaInstrucciones(
                        onComenzar = { pantallaActual.value = "menu" },
                        onBack = { pantallaActual.value = "inicio" }
                    )

                    "menu" -> PantallaMenu(
                        puntos = puntos,
                        vidas = vidas,
                        onIrNiveles = { pantallaActual.value = "niveles" },
                        onBack = { pantallaActual.value = "inicio" }
                    )

                    "niveles" -> PantallaNiveles(
                        onNivelSeleccionado = { nivel ->
                            nivelSeleccionado = nivel

                            if (nivel == "edificioA") {
                                pantallaActual.value = "exploracion"
                            } else {
                                pantallaActual.value = "reto"
                            }
                        },

                        onBack = { pantallaActual.value = "menu" }
                    )
                    "exploracion" -> PantallaExploracion(

                        onPistaEncontrada = {
                            puntos += 15
                            pantallaActual.value = "reto"
                        },

                        onBack = {
                            pantallaActual.value = "niveles"
                        }
                    )

                    "reto" -> PantallaReto(
                        nivel = nivelSeleccionado,
                        onCorrecto = {
                            puntos += if (nivelSeleccionado == "biblioteca") 20 else 10
                            pantallaActual.value = "menu"
                        },
                        onIncorrecto = {
                            vidas--
                            pantallaActual.value = "menu"
                        },
                        onBack = { pantallaActual.value = "niveles" }
                    )
                }
            }
        }
    }
}