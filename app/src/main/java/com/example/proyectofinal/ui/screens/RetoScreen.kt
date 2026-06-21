package com.example.proyectofinal.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
    val id: Int,
    val titulo: String,
    val dificultad: String,
    val pista: String,
    val pregunta: String,
    val opciones: List<String>,
    val respuestaCorrecta: String,
    val recompensa: Int
)

fun obtenerDificultadPorNivel(numeroNivel: Int): String {
    return when (numeroNivel) {
        in 0..3 -> "Fácil"
        in 4..6 -> "Media"
        else -> "Difícil"
    }
}

fun preguntasEdificioA(): List<RetoIA> {
    return listOf(
        // 9 preguntas fáciles
        RetoIA(
            id = 1,
            titulo = "Edificio A",
            dificultad = "Fácil",
            pista = "Antes de avanzar, revisá bien cada opción.",
            pregunta = "¿Qué documento suele solicitarse para realizar trámites académicos?",
            opciones = listOf("Carné estudiantil", "Receta médica", "Factura de supermercado"),
            respuestaCorrecta = "Carné estudiantil",
            recompensa = 10
        ),
        RetoIA(
            id = 2,
            titulo = "Edificio A",
            dificultad = "Fácil",
            pista = "Pensá en una acción básica antes de iniciar clases.",
            pregunta = "¿Qué acción ayuda a prepararte mejor antes de una clase importante?",
            opciones = listOf("Revisar tus materiales", "Llegar tarde", "No llevar cuaderno"),
            respuestaCorrecta = "Revisar tus materiales",
            recompensa = 10
        ),
        RetoIA(
            id = 3,
            titulo = "Edificio A",
            dificultad = "Fácil",
            pista = "La organización es clave para no perder información.",
            pregunta = "¿Qué es recomendable hacer con los horarios de clase?",
            opciones = listOf("Guardarlos y revisarlos", "Ignorarlos", "Borrarlos de inmediato"),
            respuestaCorrecta = "Guardarlos y revisarlos",
            recompensa = 10
        ),
        RetoIA(
            id = 4,
            titulo = "Edificio A",
            dificultad = "Fácil",
            pista = "Pensá en el área que orienta a los estudiantes.",
            pregunta = "¿Qué función cumple admisión en una universidad?",
            opciones = listOf("Orientar a nuevos estudiantes", "Vender comida", "Reparar computadoras"),
            respuestaCorrecta = "Orientar a nuevos estudiantes",
            recompensa = 10
        ),
        RetoIA(
            id = 5,
            titulo = "Edificio A",
            dificultad = "Fácil",
            pista = "La información académica debe estar ordenada.",
            pregunta = "¿Qué área suele manejar datos como matrícula, notas y expedientes?",
            opciones = listOf("Registro Académico", "Cafetería", "Área deportiva"),
            respuestaCorrecta = "Registro Académico",
            recompensa = 10
        ),
        RetoIA(
            id = 6,
            titulo = "Edificio A",
            dificultad = "Fácil",
            pista = "El respeto en oficinas facilita los trámites.",
            pregunta = "¿Qué actitud es correcta al hacer una consulta en una oficina universitaria?",
            opciones = listOf("Esperar tu turno", "Interrumpir a todos", "Gritar para ser atendido"),
            respuestaCorrecta = "Esperar tu turno",
            recompensa = 10
        ),
        RetoIA(
            id = 7,
            titulo = "Edificio A",
            dificultad = "Fácil",
            pista = "Un buen estudiante confirma su información.",
            pregunta = "¿Qué deberías hacer si tenés dudas sobre tu matrícula?",
            opciones = listOf("Consultar en el área correspondiente", "Inventar el horario", "No preguntar nada"),
            respuestaCorrecta = "Consultar en el área correspondiente",
            recompensa = 10
        ),
        RetoIA(
            id = 8,
            titulo = "Edificio A",
            dificultad = "Fácil",
            pista = "La puntualidad ayuda a evitar problemas.",
            pregunta = "¿Qué hábito mejora el cumplimiento de trámites universitarios?",
            opciones = listOf("Llegar a tiempo", "Llegar siempre tarde", "No revisar fechas"),
            respuestaCorrecta = "Llegar a tiempo",
            recompensa = 10
        ),
        RetoIA(
            id = 9,
            titulo = "Edificio A",
            dificultad = "Fácil",
            pista = "La comunicación clara evita confusiones.",
            pregunta = "¿Qué conviene hacer antes de entregar un documento?",
            opciones = listOf("Revisar que esté completo", "Entregar hojas vacías", "No leer nada"),
            respuestaCorrecta = "Revisar que esté completo",
            recompensa = 10
        ),

        // 8 preguntas medias
        RetoIA(
            id = 10,
            titulo = "Edificio A",
            dificultad = "Media",
            pista = "Relacioná el trámite con el área correcta.",
            pregunta = "Si un estudiante necesita confirmar sus asignaturas inscritas, ¿a qué área debería acudir?",
            opciones = listOf("Registro Académico", "Área deportiva", "Odontología"),
            respuestaCorrecta = "Registro Académico",
            recompensa = 15
        ),
        RetoIA(
            id = 11,
            titulo = "Edificio A",
            dificultad = "Media",
            pista = "Pensá en el proceso de ingreso a la universidad.",
            pregunta = "¿Qué proceso está más relacionado con el área de admisión?",
            opciones = listOf("Ingreso de nuevos estudiantes", "Entrenamiento deportivo", "Atención dental"),
            respuestaCorrecta = "Ingreso de nuevos estudiantes",
            recompensa = 15
        ),
        RetoIA(
            id = 12,
            titulo = "Edificio A",
            dificultad = "Media",
            pista = "Un expediente académico contiene información importante.",
            pregunta = "¿Cuál de estos datos puede formar parte de un expediente académico?",
            opciones = listOf("Historial de notas", "Lista de compras", "Rutina de gimnasio"),
            respuestaCorrecta = "Historial de notas",
            recompensa = 15
        ),
        RetoIA(
            id = 13,
            titulo = "Edificio A",
            dificultad = "Media",
            pista = "Producción audiovisual trabaja con contenido visual y sonoro.",
            pregunta = "¿Qué actividad se relaciona más con producción audiovisual?",
            opciones = listOf("Grabar y editar videos", "Realizar cirugías", "Llevar inventario de alimentos"),
            respuestaCorrecta = "Grabar y editar videos",
            recompensa = 15
        ),
        RetoIA(
            id = 14,
            titulo = "Edificio A",
            dificultad = "Media",
            pista = "Pensá en el orden lógico de un trámite.",
            pregunta = "¿Qué deberías hacer primero si necesitás resolver un problema con tu inscripción?",
            opciones = listOf("Verificar la información y consultar", "Cambiar datos sin permiso", "Ignorar el problema"),
            respuestaCorrecta = "Verificar la información y consultar",
            recompensa = 15
        ),
        RetoIA(
            id = 15,
            titulo = "Edificio A",
            dificultad = "Media",
            pista = "Las fechas importantes deben revisarse con anticipación.",
            pregunta = "¿Por qué es importante revisar el calendario académico?",
            opciones = listOf("Para conocer fechas de matrícula y evaluaciones", "Para decorar el celular", "Para evitar estudiar siempre"),
            respuestaCorrecta = "Para conocer fechas de matrícula y evaluaciones",
            recompensa = 15
        ),
        RetoIA(
            id = 16,
            titulo = "Edificio A",
            dificultad = "Media",
            pista = "En un video, imagen y sonido deben cuidarse.",
            pregunta = "¿Qué elemento es importante en una producción audiovisual universitaria?",
            opciones = listOf("Buena calidad de audio", "Ruido excesivo", "Imagen completamente oscura"),
            respuestaCorrecta = "Buena calidad de audio",
            recompensa = 15
        ),
        RetoIA(
            id = 17,
            titulo = "Edificio A",
            dificultad = "Media",
            pista = "Pensá en una forma responsable de manejar información.",
            pregunta = "¿Qué se debe hacer con la información académica personal?",
            opciones = listOf("Cuidarla y no compartirla sin necesidad", "Publicarla en cualquier lugar", "Regalarla a desconocidos"),
            respuestaCorrecta = "Cuidarla y no compartirla sin necesidad",
            recompensa = 15
        ),

        // 8 preguntas difíciles
        RetoIA(
            id = 18,
            titulo = "Edificio A",
            dificultad = "Difícil",
            pista = "Analizá qué opción muestra mejor orden y responsabilidad.",
            pregunta = "Un estudiante detecta que una asignatura no aparece en su matrícula. ¿Cuál sería la mejor acción?",
            opciones = listOf("Revisar su comprobante y consultar en Registro Académico", "No hacer nada", "Borrar todas sus asignaturas"),
            respuestaCorrecta = "Revisar su comprobante y consultar en Registro Académico",
            recompensa = 20
        ),
        RetoIA(
            id = 19,
            titulo = "Edificio A",
            dificultad = "Difícil",
            pista = "Pensá en la función de cada área.",
            pregunta = "¿Cuál combinación representa mejor las funciones del Edificio A?",
            opciones = listOf("Admisión, registro académico y producción audiovisual", "Medicina, odontología y deporte", "Biblioteca, cafetería y parqueo"),
            respuestaCorrecta = "Admisión, registro académico y producción audiovisual",
            recompensa = 20
        ),
        RetoIA(
            id = 20,
            titulo = "Edificio A",
            dificultad = "Difícil",
            pista = "La producción audiovisual requiere planificación.",
            pregunta = "¿Qué paso debería realizarse antes de grabar un video institucional?",
            opciones = listOf("Planificar el guion y los recursos", "Grabar sin idea previa", "Ignorar el objetivo del video"),
            respuestaCorrecta = "Planificar el guion y los recursos",
            recompensa = 20
        ),
        RetoIA(
            id = 21,
            titulo = "Edificio A",
            dificultad = "Difícil",
            pista = "Pensá en la importancia de los documentos oficiales.",
            pregunta = "¿Por qué un comprobante de matrícula puede ser importante?",
            opciones = listOf("Porque respalda las asignaturas inscritas", "Porque reemplaza todos los exámenes", "Porque permite faltar a clases"),
            respuestaCorrecta = "Porque respalda las asignaturas inscritas",
            recompensa = 20
        ),
        RetoIA(
            id = 22,
            titulo = "Edificio A",
            dificultad = "Difícil",
            pista = "Analizá qué acción evita errores futuros.",
            pregunta = "Si un estudiante cambia de grupo o asignatura, ¿qué debe verificar después?",
            opciones = listOf("Que el cambio aparezca correctamente en su registro", "Que nadie se entere", "Que el horario quede incompleto"),
            respuestaCorrecta = "Que el cambio aparezca correctamente en su registro",
            recompensa = 20
        ),
        RetoIA(
            id = 23,
            titulo = "Edificio A",
            dificultad = "Difícil",
            pista = "La comunicación institucional debe ser clara.",
            pregunta = "¿Qué característica debe tener un video informativo para estudiantes?",
            opciones = listOf("Mensaje claro y fácil de entender", "Información confusa", "Audio imposible de escuchar"),
            respuestaCorrecta = "Mensaje claro y fácil de entender",
            recompensa = 20
        ),
        RetoIA(
            id = 24,
            titulo = "Edificio A",
            dificultad = "Difícil",
            pista = "Pensá en una decisión responsable ante un error académico.",
            pregunta = "Si un estudiante nota un error en sus datos personales, ¿qué debería hacer?",
            opciones = listOf("Solicitar corrección en el área correspondiente", "Dejar el error para siempre", "Cambiarlo de forma informal"),
            respuestaCorrecta = "Solicitar corrección en el área correspondiente",
            recompensa = 20
        ),
        RetoIA(
            id = 25,
            titulo = "Edificio A",
            dificultad = "Difícil",
            pista = "Relacioná tecnología, comunicación y universidad.",
            pregunta = "¿Cuál sería un uso adecuado de producción audiovisual dentro de la universidad?",
            opciones = listOf("Crear material informativo para la comunidad estudiantil", "Crear desorden en clases", "Ocultar información académica"),
            respuestaCorrecta = "Crear material informativo para la comunidad estudiantil",
            recompensa = 20
        )
    )
}

fun generarRetoIA(
    nivel: String,
    numeroNivel: Int,
    preguntasUsadas: List<Int>
): RetoIA {
    val bancoPreguntas = when (nivel) {
        "edificioA" -> preguntasEdificioA()
        else -> preguntasEdificioA()
    }

    val dificultadNivel = obtenerDificultadPorNivel(numeroNivel)

    val preguntasDisponibles = bancoPreguntas.filter {
        it.dificultad == dificultadNivel && !preguntasUsadas.contains(it.id)
    }

    val preguntasRespaldo = bancoPreguntas.filter {
        it.dificultad == dificultadNivel
    }

    val retoElegido = if (preguntasDisponibles.isNotEmpty()) {
        preguntasDisponibles.random()
    } else {
        preguntasRespaldo.random()
    }

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
    preguntasUsadas: List<Int>,
    onPreguntaUsada: (Int) -> Unit,
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

    val reto = remember(nivel, numeroNivel, preguntasUsadas.joinToString()) {
        generarRetoIA(
            nivel = nivel,
            numeroNivel = numeroNivel,
            preguntasUsadas = preguntasUsadas
        )
    }

    val progresoEdificio = ((numeroNivel + 1).toFloat() / totalNivelesEdificio.toFloat())
        .coerceIn(0f, 1f)

    var opcionSeleccionada by remember { mutableStateOf<String?>(null) }
    var respuestaCorrecta by remember { mutableStateOf<Boolean?>(null) }
    var botonesHabilitados by remember { mutableStateOf(true) }
    var mostrarResultado by remember { mutableStateOf(false) }

    LaunchedEffect(nivel, numeroNivel) {
        opcionSeleccionada = null
        respuestaCorrecta = null
        botonesHabilitados = true
        mostrarResultado = false
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
                text = "Reto del edificio",
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
                        text = "Pista del nivel",
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
                                    mostrarResultado = true
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

                    if (mostrarResultado) {
                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = if (respuestaCorrecta == true) {
                                if (mostrarSiguienteNivel) {
                                    "¡Correcto! Ganaste ${reto.recompensa} puntos y avanzás en el edificio."
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
                            Column(modifier = Modifier.fillMaxWidth()) {

                                Button(
                                    onClick = {
                                        if (!botonesHabilitados) return@Button

                                        botonesHabilitados = false
                                        onPreguntaUsada(reto.id)
                                        onCorrecto(reto.recompensa)
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
                                            onPreguntaUsada(reto.id)
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
                            Button(
                                onClick = {
                                    if (!botonesHabilitados) return@Button

                                    botonesHabilitados = false
                                    onPreguntaUsada(reto.id)
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