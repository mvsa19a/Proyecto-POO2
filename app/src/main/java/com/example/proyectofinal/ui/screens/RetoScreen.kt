package com.example.proyectofinal.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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

fun generarRetoIA(nivel: String, numeroNivel: Int): RetoIA {
    val retosPorNivel = mapOf(
        "edificioA" to listOf(
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
        ),
        "edificioE" to listOf(
            RetoIA(
                titulo = "Edificio E",
                dificultad = "Nivel medio",
                pista = "La IA creó un reto sobre bienestar y salud.",
                pregunta = "¿Qué práctica ayuda a prevenir enfermedades en un entorno universitario?",
                opciones = listOf("Lavarse las manos", "Compartir vasos", "Ignorar síntomas"),
                respuestaCorrecta = "Lavarse las manos",
                recompensa = 15
            ),
            RetoIA(
                titulo = "Edificio E",
                dificultad = "Nivel medio",
                pista = "La IA generó una pregunta sobre atención básica.",
                pregunta = "Si alguien se desmaya, ¿qué deberías hacer primero?",
                opciones = listOf("Pedir ayuda", "Moverlo rápido", "Dejarlo solo"),
                respuestaCorrecta = "Pedir ayuda",
                recompensa = 15
            ),
            RetoIA(
                titulo = "Edificio E",
                dificultad = "Nivel medio",
                pista = "La IA seleccionó un reto sobre hábitos saludables.",
                pregunta = "¿Cuál de estas opciones apoya mejor una buena salud?",
                opciones = listOf("Dormir bien", "Saltarse el descanso", "Beber solo refresco"),
                respuestaCorrecta = "Dormir bien",
                recompensa = 15
            )
        ),
        "edificioJ" to listOf(
            RetoIA(
                titulo = "Edificio J",
                dificultad = "Nivel medio",
                pista = "La IA pensó en cuidado dental preventivo.",
                pregunta = "¿Cuántas veces al día se recomienda cepillarse los dientes?",
                opciones = listOf("2 veces", "1 vez al mes", "5 veces"),
                respuestaCorrecta = "2 veces",
                recompensa = 15
            ),
            RetoIA(
                titulo = "Edificio J",
                dificultad = "Nivel medio",
                pista = "La IA generó un reto sobre higiene bucal.",
                pregunta = "¿Qué elemento ayuda a limpiar entre los dientes?",
                opciones = listOf("Hilo dental", "Papel", "Cinta adhesiva"),
                respuestaCorrecta = "Hilo dental",
                recompensa = 15
            ),
            RetoIA(
                titulo = "Edificio J",
                dificultad = "Nivel medio",
                pista = "La IA seleccionó una pregunta sobre alimentación y dientes.",
                pregunta = "¿Qué alimento conviene limitar para cuidar el esmalte dental?",
                opciones = listOf("Azúcar en exceso", "Agua", "Verduras"),
                respuestaCorrecta = "Azúcar en exceso",
                recompensa = 15
            )
        ),
        "edificioP" to listOf(
            RetoIA(
                titulo = "Edificio P",
                dificultad = "Nivel medio",
                pista = "La IA creó un reto inspirado en Copérnico.",
                pregunta = "¿Qué modelo defendió Copérnico?",
                opciones = listOf("Heliocéntrico", "Geocéntrico", "Lunar"),
                respuestaCorrecta = "Heliocéntrico",
                recompensa = 15
            ),
            RetoIA(
                titulo = "Edificio P",
                dificultad = "Nivel medio",
                pista = "La IA generó una pregunta astronómica.",
                pregunta = "¿Qué cuerpo celeste gira alrededor de la Tierra?",
                opciones = listOf("La Luna", "El Sol", "Marte"),
                respuestaCorrecta = "La Luna",
                recompensa = 15
            ),
            RetoIA(
                titulo = "Edificio P",
                dificultad = "Nivel medio",
                pista = "La IA eligió una cuestión sobre observación del cielo.",
                pregunta = "¿Cuál instrumento ayuda a observar estrellas y planetas?",
                opciones = listOf("Telescopio", "Microscopio", "Termómetro"),
                respuestaCorrecta = "Telescopio",
                recompensa = 15
            )
        ),
        "edificioO" to listOf(
            RetoIA(
                titulo = "Edificio O",
                dificultad = "Nivel avanzado",
                pista = "La IA generó un reto de ingeniería estructural.",
                pregunta = "¿Qué material suele usarse para dar resistencia a una estructura?",
                opciones = listOf("Acero", "Papel", "Algodón"),
                respuestaCorrecta = "Acero",
                recompensa = 20
            ),
            RetoIA(
                titulo = "Edificio O",
                dificultad = "Nivel avanzado",
                pista = "La IA pensó en diseño arquitectónico.",
                pregunta = "¿Qué elemento ayuda a distribuir cargas en un edificio?",
                opciones = listOf("Vigas", "Cortinas", "Pintura"),
                respuestaCorrecta = "Vigas",
                recompensa = 20
            ),
            RetoIA(
                titulo = "Edificio O",
                dificultad = "Nivel avanzado",
                pista = "La IA generó una pregunta de planificación.",
                pregunta = "¿Qué paso conviene hacer antes de construir?",
                opciones = listOf("Diseñar planos", "Ignorar medidas", "Empezar sin calcular"),
                respuestaCorrecta = "Diseñar planos",
                recompensa = 20
            )
        ),
        "edificioK" to listOf(
            RetoIA(
                titulo = "Edificio K",
                dificultad = "Nivel medio",
                pista = "La IA creó un reto sobre actividad física.",
                pregunta = "¿Qué acción conviene hacer antes de entrenar?",
                opciones = listOf("Calentar", "Dormir en el piso", "No moverse"),
                respuestaCorrecta = "Calentar",
                recompensa = 15
            ),
            RetoIA(
                titulo = "Edificio K",
                dificultad = "Nivel medio",
                pista = "La IA generó una pregunta sobre hidratación.",
                pregunta = "¿Qué bebida es mejor durante una actividad deportiva?",
                opciones = listOf("Agua", "Solo gaseosa", "Solo café"),
                respuestaCorrecta = "Agua",
                recompensa = 15
            ),
            RetoIA(
                titulo = "Edificio K",
                dificultad = "Nivel medio",
                pista = "La IA seleccionó un reto de coordinación.",
                pregunta = "¿Qué cualidad ayuda más en una disciplina deportiva?",
                opciones = listOf("Disciplina", "Desorden", "Falta de práctica"),
                respuestaCorrecta = "Disciplina",
                recompensa = 15
            )
        ),
        "edificioF" to listOf(
            RetoIA(
                titulo = "Edificio F",
                dificultad = "Nivel avanzado",
                pista = "La IA creó un reto sobre ciencias jurídicas.",
                pregunta = "¿Qué documento reúne normas fundamentales de un país?",
                opciones = listOf("Constitución", "Recibo", "Inventario"),
                respuestaCorrecta = "Constitución",
                recompensa = 20
            ),
            RetoIA(
                titulo = "Edificio F",
                dificultad = "Nivel avanzado",
                pista = "La IA generó una pregunta sobre convivencia y leyes.",
                pregunta = "¿Qué acción es correcta si querés resolver un conflicto legal?",
                opciones = listOf("Buscar asesoría", "Ignorar el problema", "Romper documentos"),
                respuestaCorrecta = "Buscar asesoría",
                recompensa = 20
            ),
            RetoIA(
                titulo = "Edificio F",
                dificultad = "Nivel avanzado",
                pista = "La IA seleccionó un reto de pensamiento crítico.",
                pregunta = "¿Qué prueba suele ser importante en un proceso?",
                opciones = listOf("Evidencia", "Rumor", "Adivinanza"),
                respuestaCorrecta = "Evidencia",
                recompensa = 20
            )
        ),
        "edificioI" to listOf(
            RetoIA(
                titulo = "Edificio I",
                dificultad = "Nivel avanzado",
                pista = "La IA creó un reto sobre administración y economía.",
                pregunta = "¿Qué ayuda a controlar ingresos y gastos?",
                opciones = listOf("Un presupuesto", "Un rumor", "Un cartel"),
                respuestaCorrecta = "Un presupuesto",
                recompensa = 25
            ),
            RetoIA(
                titulo = "Edificio I",
                dificultad = "Nivel avanzado",
                pista = "La IA generó una pregunta de gestión.",
                pregunta = "¿Qué acción mejora la organización de una empresa?",
                opciones = listOf("Planificar", "Improvisar todo", "Ignorar objetivos"),
                respuestaCorrecta = "Planificar",
                recompensa = 25
            ),
            RetoIA(
                titulo = "Edificio I",
                dificultad = "Nivel avanzado",
                pista = "La IA seleccionó una pregunta sobre economía básica.",
                pregunta = "¿Cómo se llama el dinero que entra a una organización?",
                opciones = listOf("Ingreso", "Pérdida", "Deuda"),
                respuestaCorrecta = "Ingreso",
                recompensa = 25
            )
        )
    )

    val listaRetos = retosPorNivel[nivel] ?: retosPorNivel.getValue("edificioA")
    val retoElegido = listaRetos[numeroNivel % listaRetos.size]

    return retoElegido.copy(
        opciones = retoElegido.opciones.shuffled()
    )
}

@Composable
fun PantallaReto(
    nivel: String,
    numeroNivel: Int,
    totalNivelesEdificio: Int = 10,
    mostrarSiguienteNivel: Boolean,
    onCorrecto: (Int) -> Unit,
    onIncorrecto: () -> Unit,
    onVolverANiveles: () -> Unit,
    onSiguienteNivel: () -> Unit,
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

    val reto = remember(nivel, numeroNivel) {
        generarRetoIA(nivel, numeroNivel)
    }

    val progresoEdificio = ((numeroNivel + 1).toFloat() / totalNivelesEdificio.toFloat())
        .coerceIn(0f, 1f)

    var opcionSeleccionada by remember { mutableStateOf<String?>(null) }
    var respuestaCorrecta by remember { mutableStateOf<Boolean?>(null) }
    var botonesHabilitados by remember { mutableStateOf(true) }
    var mostrarResultados by remember { mutableStateOf(false) }

    LaunchedEffect(nivel, numeroNivel) {
        opcionSeleccionada = null
        respuestaCorrecta = null
        botonesHabilitados = true
        mostrarResultados = false
    }

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
                .verticalScroll(rememberScrollState())
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

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Nivel ${numeroNivel + 1} de $totalNivelesEdificio",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = textoSecundario
            )

            Spacer(modifier = Modifier.height(10.dp))

            LinearProgressIndicator(
                progress = { progresoEdificio },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = celesteOscuro,
                trackColor = Color(0xFFDCECEF)
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
                                    // mostrar inmediatamente el mensaje y los botones internos
                                    mostrarResultados = true
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

                        if (mostrarResultados) {
                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = if (respuestaCorrecta == true) {
                                if (mostrarSiguienteNivel) {
                                    "¡Correcto! Ganaste ${reto.recompensa} puntos y avanzás en el juego."
                                } else {
                                    "¡Correcto! Ganaste ${reto.recompensa} puntos y completaste este edificio."
                                }
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

                        if (respuestaCorrecta == true) {
                            // Mostrar dos opciones cuando la respuesta es correcta:
                            // - Volver a niveles (o "volver al edificio")
                            // - Siguiente nivel
                            Column(modifier = Modifier.fillMaxWidth()) {
                                Button(
                                    onClick = {
                                        if (!botonesHabilitados) return@Button
                                        botonesHabilitados = false
                                        // Primero aplicar la recompensa / lógica de correcto
                                        onCorrecto(reto.recompensa)
                                        // Luego navegar a la pantalla de niveles
                                        onVolverANiveles()
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
                                        text = "Volver al edificio",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                if (mostrarSiguienteNivel) {
                                    Button(
                                        onClick = {
                                            if (!botonesHabilitados) return@Button
                                            botonesHabilitados = false
                                            // Aplicar recompensa y avanzar al siguiente nivel dentro del mismo edificio
                                            onCorrecto(reto.recompensa)
                                            onSiguienteNivel()
                                        },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(54.dp),
                                        shape = RoundedCornerShape(17.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = celesteOscuro
                                        )
                                    ) {
                                        Text(
                                            text = "Siguiente nivel",
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White
                                        )
                                    }
                                }
                            }
                        } else {
                            // Respuesta incorrecta: mantener la lógica previa
                            Button(
                                onClick = {
                                    if (!botonesHabilitados) return@Button
                                    botonesHabilitados = false
                                    onIncorrecto()
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
            }

            Spacer(modifier = Modifier.weight(1f))

            // Ocultar el botón inferior cuando ya se mostró la respuesta (y los botones internos)
            if (respuestaCorrecta == null) {
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
                        text = "Volver al edificio",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = celesteOscuro
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}