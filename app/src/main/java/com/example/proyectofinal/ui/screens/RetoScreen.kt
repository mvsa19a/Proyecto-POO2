package com.example.proyectofinal.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class RetoIA(
    val titulo: String,
    val dificultad: String,
    val pista: String,
    val pregunta: String,
    val opciones: List<String>,
    val respuestaCorrecta: String,
    val recompensa: Int
)

fun generarRetoIA(nivel: String): RetoIA {
    val retosEdificioA = listOf(
        RetoIA(
            titulo = "Edificio A",
            dificultad = "Nivel básico",
            pista = "La IA generó una pista de orientación para iniciar tu recorrido.",
            pregunta = "¿Qué acción te ayuda más a prepararte antes de una clase importante?",
            opciones = listOf("Revisar tus materiales", "Llegar tarde", "No llevar cuaderno"),
            respuestaCorrecta = "Revisar tus materiales",
            recompensa = 10
        ),
        RetoIA(
            titulo = "Edificio A",
            dificultad = "Nivel básico",
            pista = "La IA seleccionó un reto rápido sobre hábitos universitarios.",
            pregunta = "¿Cuál es un hábito saludable para mantener energía durante el día?",
            opciones = listOf("Tomar agua", "No dormir", "Saltarse comidas"),
            respuestaCorrecta = "Tomar agua",
            recompensa = 10
        ),
        RetoIA(
            titulo = "Edificio A",
            dificultad = "Nivel básico",
            pista = "La IA detectó una pregunta sencilla de lógica.",
            pregunta = "Si encontrás 3 pistas y luego descubrís 2 más, ¿cuántas pistas tenés?",
            opciones = listOf("5 pistas", "3 pistas", "6 pistas"),
            respuestaCorrecta = "5 pistas",
            recompensa = 10
        )
    )

    val retosBiblioteca = listOf(
        RetoIA(
            titulo = "Biblioteca Central",
            dificultad = "Nivel avanzado",
            pista = "La IA creó un reto matemático usando salas de estudio.",
            pregunta = "Si cada sala tiene 4 mesas y cada mesa tiene 3 pistas, ¿cuántas pistas hay en 5 salas?",
            opciones = listOf("60 pistas", "35 pistas", "45 pistas"),
            respuestaCorrecta = "60 pistas",
            recompensa = 20
        ),
        RetoIA(
            titulo = "Biblioteca Central",
            dificultad = "Nivel avanzado",
            pista = "La IA generó un reto de comportamiento dentro de la biblioteca.",
            pregunta = "¿Qué acción es más adecuada dentro de una biblioteca universitaria?",
            opciones = listOf("Guardar silencio", "Hablar fuerte", "Correr entre pasillos"),
            respuestaCorrecta = "Guardar silencio",
            recompensa = 20
        ),
        RetoIA(
            titulo = "Biblioteca Central",
            dificultad = "Nivel avanzado",
            pista = "La IA seleccionó una pregunta de razonamiento.",
            pregunta = "Si encontrás una pista en cada uno de 4 estantes y luego duplicás la cantidad, ¿cuántas pistas tenés?",
            opciones = listOf("8 pistas", "4 pistas", "10 pistas"),
            respuestaCorrecta = "8 pistas",
            recompensa = 20
        )
    )

    val listaRetos = if (nivel == "biblioteca") retosBiblioteca else retosEdificioA
    val retoElegido = listaRetos.random()

    return retoElegido.copy(
        opciones = retoElegido.opciones.shuffled()
    )
}

@Composable
fun PantallaReto(
    nivel: String,
    onCorrecto: () -> Unit,
    onIncorrecto: () -> Unit,
    onBack: () -> Unit
) {
    val celeste = Color(0xFF32A0A6)
    val celesteOscuro = Color(0xFF187C84)
    val fondoClaro = Color(0xFFF3FBFC)
    val textoPrincipal = Color(0xFF1F2937)
    val textoSecundario = Color(0xFF64748B)
    val bordeSuave = Color(0xFFD6E3E6)
    val verdeCorrecto = Color(0xFF2E7D32)
    val rojoIncorrecto = Color(0xFFC62828)

    val reto = remember(nivel) {
        generarRetoIA(nivel)
    }

    var opcionSeleccionada by remember { mutableStateOf<String?>(null) }
    var respuestaCorrecta by remember { mutableStateOf<Boolean?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        fondoClaro,
                        Color(0xFFE4F5F7)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 26.dp, vertical = 34.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Reto generado por IA",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = celesteOscuro
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = reto.titulo,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = textoPrincipal,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = reto.dificultad,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = celeste
            )

            Spacer(modifier = Modifier.height(22.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(26.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(22.dp)
                ) {
                    Text(
                        text = "Pista inteligente",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = textoPrincipal
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = reto.pista,
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        color = textoSecundario
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(26.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(22.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Recompensa: ${reto.recompensa} puntos",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = celesteOscuro
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = reto.pregunta,
                        fontSize = 18.sp,
                        lineHeight = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = textoPrincipal,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(22.dp))

                    reto.opciones.forEach { opcion ->
                        val seleccionada = opcionSeleccionada == opcion
                        val yaRespondio = opcionSeleccionada != null

                        Button(
                            onClick = {
                                if (!yaRespondio) {
                                    opcionSeleccionada = opcion
                                    respuestaCorrecta = opcion == reto.respuestaCorrecta
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(54.dp),
                            shape = RoundedCornerShape(17.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = when {
                                    seleccionada && respuestaCorrecta == true -> verdeCorrecto
                                    seleccionada && respuestaCorrecta == false -> rojoIncorrecto
                                    else -> Color.White
                                },
                                contentColor = when {
                                    seleccionada -> Color.White
                                    else -> textoPrincipal
                                }
                            ),
                            border = BorderStroke(
                                width = 1.dp,
                                color = when {
                                    seleccionada && respuestaCorrecta == true -> verdeCorrecto
                                    seleccionada && respuestaCorrecta == false -> rojoIncorrecto
                                    else -> bordeSuave
                                }
                            )
                        ) {
                            Text(
                                text = opcion,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                    }

                    if (respuestaCorrecta != null) {
                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = if (respuestaCorrecta == true) {
                                "¡Correcto! Ganaste ${reto.recompensa} puntos y avanzás en el juego."
                            } else {
                                "Respuesta incorrecta. Perdiste una vida, pero podés seguir intentando."
                            },
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = if (respuestaCorrecta == true) verdeCorrecto else rojoIncorrecto,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(18.dp))

                        Button(
                            onClick = {
                                if (respuestaCorrecta == true) {
                                    onCorrecto()
                                } else {
                                    onIncorrecto()
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(54.dp),
                            shape = RoundedCornerShape(17.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = celeste
                            )
                        ) {
                            Text(
                                text = "Continuar",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            OutlinedButton(
                onClick = onBack,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(18.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = bordeSuave
                )
            ) {
                Text(
                    text = "Volver a niveles",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = celesteOscuro
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}