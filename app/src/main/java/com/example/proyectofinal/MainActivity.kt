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
            ProyectoFINALTheme() {

                var pantallaActual = remember { mutableStateOf("inicio") }

                // 🔥 Estado del usuario
                var puntos by remember { mutableStateOf(0) }
                var vidas by remember { mutableStateOf(3) }

                when (pantallaActual.value) {

                    "inicio" -> PantallaInicio(
                        onStart = { pantallaActual.value = "menu" }
                    )

                    "menu" -> PantallaMenu(
                        puntos = puntos,
                        vidas = vidas,
                        onIrNiveles = { pantallaActual.value = "niveles" },
                        onBack = { pantallaActual.value = "inicio" }
                    )

                    "niveles" -> PantallaNiveles(
                        onNivelSeleccionado = {
                            pantallaActual.value = "reto"
                        },
                        onBack = { pantallaActual.value = "menu" }
                    )

                    "reto" -> PantallaReto(
                        onCorrecto = {
                            puntos += 10
                            pantallaActual.value = "menu"
                        },
                        onIncorrecto = {
                            vidas--
                            pantallaActual.value = "menu"
                        }
                    )
                }
            }
        }
    }
}