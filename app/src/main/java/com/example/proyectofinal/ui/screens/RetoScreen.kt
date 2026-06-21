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

fun preguntasEdificioE(): List<RetoIA> {
    return listOf(
        // 9 preguntas fáciles - Medicina
        RetoIA(
            id = 1,
            titulo = "Edificio E",
            dificultad = "Fácil",
            pista = "Pensá en una acción básica de higiene.",
            pregunta = "¿Qué hábito ayuda a prevenir enfermedades comunes?",
            opciones = listOf("Lavarse las manos", "Compartir vasos", "No descansar"),
            respuestaCorrecta = "Lavarse las manos",
            recompensa = 10
        ),
        RetoIA(
            id = 2,
            titulo = "Edificio E",
            dificultad = "Fácil",
            pista = "El descanso ayuda al cuerpo a recuperarse.",
            pregunta = "¿Qué hábito favorece una buena salud física y mental?",
            opciones = listOf("Dormir bien", "Dormir solo una hora", "No tomar agua"),
            respuestaCorrecta = "Dormir bien",
            recompensa = 10
        ),
        RetoIA(
            id = 3,
            titulo = "Edificio E",
            dificultad = "Fácil",
            pista = "El agua es importante para el funcionamiento del cuerpo.",
            pregunta = "¿Qué bebida es más recomendable para mantenerse hidratado?",
            opciones = listOf("Agua", "Solo gaseosa", "Bebidas con exceso de azúcar"),
            respuestaCorrecta = "Agua",
            recompensa = 10
        ),
        RetoIA(
            id = 4,
            titulo = "Edificio E",
            dificultad = "Fácil",
            pista = "Pensá en una acción responsable ante síntomas fuertes.",
            pregunta = "¿Qué conviene hacer si una persona se siente muy mal de salud?",
            opciones = listOf("Buscar ayuda médica", "Ignorar los síntomas", "Automedicarse sin orientación"),
            respuestaCorrecta = "Buscar ayuda médica",
            recompensa = 10
        ),
        RetoIA(
            id = 5,
            titulo = "Edificio E",
            dificultad = "Fácil",
            pista = "Una alimentación variada ayuda al cuerpo.",
            pregunta = "¿Qué opción representa un hábito alimenticio saludable?",
            opciones = listOf("Comer frutas y verduras", "Saltarse todas las comidas", "Comer solo dulces"),
            respuestaCorrecta = "Comer frutas y verduras",
            recompensa = 10
        ),
        RetoIA(
            id = 6,
            titulo = "Edificio E",
            dificultad = "Fácil",
            pista = "La prevención evita complicaciones.",
            pregunta = "¿Para qué sirven los chequeos médicos preventivos?",
            opciones = listOf("Detectar problemas a tiempo", "Evitar toda actividad física", "Reemplazar el descanso"),
            respuestaCorrecta = "Detectar problemas a tiempo",
            recompensa = 10
        ),
        RetoIA(
            id = 7,
            titulo = "Edificio E",
            dificultad = "Fácil",
            pista = "La actividad física es parte del bienestar.",
            pregunta = "¿Qué ayuda a mantener un cuerpo activo y saludable?",
            opciones = listOf("Hacer ejercicio moderado", "No moverse nunca", "Dormir todo el día"),
            respuestaCorrecta = "Hacer ejercicio moderado",
            recompensa = 10
        ),
        RetoIA(
            id = 8,
            titulo = "Edificio E",
            dificultad = "Fácil",
            pista = "Pensá en una medida de cuidado hacia los demás.",
            pregunta = "¿Qué acción ayuda a evitar contagios al toser o estornudar?",
            opciones = listOf("Cubrirse con el antebrazo", "Toser frente a otros", "Compartir pañuelos usados"),
            respuestaCorrecta = "Cubrirse con el antebrazo",
            recompensa = 10
        ),
        RetoIA(
            id = 9,
            titulo = "Edificio E",
            dificultad = "Fácil",
            pista = "El cuerpo necesita energía para funcionar.",
            pregunta = "¿Por qué es importante alimentarse adecuadamente?",
            opciones = listOf("Para tener energía", "Para enfermarse más rápido", "Para evitar estudiar"),
            respuestaCorrecta = "Para tener energía",
            recompensa = 10
        ),

        // 8 preguntas medias - Medicina
        RetoIA(
            id = 10,
            titulo = "Edificio E",
            dificultad = "Media",
            pista = "Pensá en una acción inicial ante una emergencia.",
            pregunta = "Si una persona se desmaya, ¿qué es lo primero que se debería hacer?",
            opciones = listOf("Pedir ayuda", "Dejarla sola", "Darle comida de inmediato"),
            respuestaCorrecta = "Pedir ayuda",
            recompensa = 15
        ),
        RetoIA(
            id = 11,
            titulo = "Edificio E",
            dificultad = "Media",
            pista = "El pulso se relaciona con el corazón.",
            pregunta = "¿Qué indica principalmente el pulso?",
            opciones = listOf("La frecuencia del corazón", "El color de los ojos", "La estatura exacta"),
            respuestaCorrecta = "La frecuencia del corazón",
            recompensa = 15
        ),
        RetoIA(
            id = 12,
            titulo = "Edificio E",
            dificultad = "Media",
            pista = "La fiebre suele ser una señal del cuerpo.",
            pregunta = "¿Qué puede indicar una temperatura corporal elevada?",
            opciones = listOf("Una posible infección o enfermedad", "Que la persona siempre está sana", "Que no necesita agua"),
            respuestaCorrecta = "Una posible infección o enfermedad",
            recompensa = 15
        ),
        RetoIA(
            id = 13,
            titulo = "Edificio E",
            dificultad = "Media",
            pista = "El botiquín sirve para atención básica.",
            pregunta = "¿Qué elemento es común en un botiquín de primeros auxilios?",
            opciones = listOf("Gasas limpias", "Zapatos deportivos", "Cuadernos"),
            respuestaCorrecta = "Gasas limpias",
            recompensa = 15
        ),
        RetoIA(
            id = 14,
            titulo = "Edificio E",
            dificultad = "Media",
            pista = "Pensá en órganos principales del cuerpo.",
            pregunta = "¿Qué órgano se encarga de bombear la sangre?",
            opciones = listOf("Corazón", "Estómago", "Piel"),
            respuestaCorrecta = "Corazón",
            recompensa = 15
        ),
        RetoIA(
            id = 15,
            titulo = "Edificio E",
            dificultad = "Media",
            pista = "La respiración permite entrada de oxígeno.",
            pregunta = "¿Qué sistema participa principalmente en la respiración?",
            opciones = listOf("Sistema respiratorio", "Sistema óseo", "Sistema digestivo"),
            respuestaCorrecta = "Sistema respiratorio",
            recompensa = 15
        ),
        RetoIA(
            id = 16,
            titulo = "Edificio E",
            dificultad = "Media",
            pista = "No todos los medicamentos sirven para todo.",
            pregunta = "¿Por qué no es recomendable automedicarse?",
            opciones = listOf("Porque puede ser peligroso", "Porque siempre cura todo", "Porque reemplaza al médico"),
            respuestaCorrecta = "Porque puede ser peligroso",
            recompensa = 15
        ),
        RetoIA(
            id = 17,
            titulo = "Edificio E",
            dificultad = "Media",
            pista = "La prevención también depende de hábitos diarios.",
            pregunta = "¿Qué combinación favorece una vida saludable?",
            opciones = listOf("Buena alimentación, descanso y ejercicio", "Estrés, desvelo y mala alimentación", "Sedentarismo y exceso de azúcar"),
            respuestaCorrecta = "Buena alimentación, descanso y ejercicio",
            recompensa = 15
        ),

        // 8 preguntas difíciles - Medicina
        RetoIA(
            id = 18,
            titulo = "Edificio E",
            dificultad = "Difícil",
            pista = "Analizá cuál acción protege mejor a la persona afectada.",
            pregunta = "Si alguien presenta dolor fuerte en el pecho, ¿qué acción es más responsable?",
            opciones = listOf("Buscar atención médica urgente", "Esperar varios días sin avisar", "Hacer ejercicio intenso"),
            respuestaCorrecta = "Buscar atención médica urgente",
            recompensa = 20
        ),
        RetoIA(
            id = 19,
            titulo = "Edificio E",
            dificultad = "Difícil",
            pista = "Pensá en el orden de atención ante una herida.",
            pregunta = "Ante una herida leve, ¿qué acción es más adecuada inicialmente?",
            opciones = listOf("Lavar la zona y cubrirla con material limpio", "Ensuciar la herida", "Tocarla con manos sucias"),
            respuestaCorrecta = "Lavar la zona y cubrirla con material limpio",
            recompensa = 20
        ),
        RetoIA(
            id = 20,
            titulo = "Edificio E",
            dificultad = "Difícil",
            pista = "La presión arterial se relaciona con la circulación.",
            pregunta = "¿Qué mide la presión arterial?",
            opciones = listOf("La fuerza de la sangre contra las arterias", "La cantidad de comida ingerida", "La temperatura del ambiente"),
            respuestaCorrecta = "La fuerza de la sangre contra las arterias",
            recompensa = 20
        ),
        RetoIA(
            id = 21,
            titulo = "Edificio E",
            dificultad = "Difícil",
            pista = "Pensá en una medida básica de bioseguridad.",
            pregunta = "¿Por qué es importante usar guantes al atender una herida?",
            opciones = listOf("Para reducir riesgo de contaminación", "Para decorar las manos", "Para evitar hablar con el paciente"),
            respuestaCorrecta = "Para reducir riesgo de contaminación",
            recompensa = 20
        ),
        RetoIA(
            id = 22,
            titulo = "Edificio E",
            dificultad = "Difícil",
            pista = "El cuerpo da señales que no deben ignorarse.",
            pregunta = "¿Qué representa una señal de alerta que requiere atención?",
            opciones = listOf("Dificultad para respirar", "Tener sueño después de estudiar", "Sentir hambre antes de comer"),
            respuestaCorrecta = "Dificultad para respirar",
            recompensa = 20
        ),
        RetoIA(
            id = 23,
            titulo = "Edificio E",
            dificultad = "Difícil",
            pista = "El sistema inmune protege el organismo.",
            pregunta = "¿Cuál es una función general del sistema inmunológico?",
            opciones = listOf("Defender el cuerpo de agentes dañinos", "Producir tareas académicas", "Cambiar el color del cabello"),
            respuestaCorrecta = "Defender el cuerpo de agentes dañinos",
            recompensa = 20
        ),
        RetoIA(
            id = 24,
            titulo = "Edificio E",
            dificultad = "Difícil",
            pista = "Pensá en una decisión responsable ante medicamentos.",
            pregunta = "Si un medicamento fue indicado a otra persona, ¿qué debería hacerse?",
            opciones = listOf("No tomarlo sin orientación profesional", "Tomarlo sin preguntar", "Mezclarlo con cualquier sustancia"),
            respuestaCorrecta = "No tomarlo sin orientación profesional",
            recompensa = 20
        ),
        RetoIA(
            id = 25,
            titulo = "Edificio E",
            dificultad = "Difícil",
            pista = "La prevención se basa en observar riesgos.",
            pregunta = "¿Qué acción ayuda a reducir accidentes en un laboratorio o área clínica?",
            opciones = listOf("Seguir normas de seguridad", "Ignorar instrucciones", "Jugar con materiales delicados"),
            respuestaCorrecta = "Seguir normas de seguridad",
            recompensa = 20
        )
    )
}

fun preguntasEdificioJ(): List<RetoIA> {
    return listOf(
        // 9 preguntas fáciles - Odontología
        RetoIA(
            id = 1,
            titulo = "Edificio J",
            dificultad = "Fácil",
            pista = "Pensá en el hábito más básico de higiene bucal.",
            pregunta = "¿Qué hábito ayuda a mantener los dientes limpios?",
            opciones = listOf("Cepillarse los dientes", "Comer solo dulces", "No usar cepillo"),
            respuestaCorrecta = "Cepillarse los dientes",
            recompensa = 10
        ),
        RetoIA(
            id = 2,
            titulo = "Edificio J",
            dificultad = "Fácil",
            pista = "El hilo dental ayuda donde el cepillo no siempre llega.",
            pregunta = "¿Qué ayuda a limpiar entre los dientes?",
            opciones = listOf("Hilo dental", "Cinta adhesiva", "Papel mojado"),
            respuestaCorrecta = "Hilo dental",
            recompensa = 10
        ),
        RetoIA(
            id = 3,
            titulo = "Edificio J",
            dificultad = "Fácil",
            pista = "El exceso de azúcar puede dañar los dientes.",
            pregunta = "¿Qué conviene limitar para cuidar la salud bucal?",
            opciones = listOf("Azúcar en exceso", "Agua", "Verduras"),
            respuestaCorrecta = "Azúcar en exceso",
            recompensa = 10
        ),
        RetoIA(
            id = 4,
            titulo = "Edificio J",
            dificultad = "Fácil",
            pista = "El odontólogo revisa la salud de la boca.",
            pregunta = "¿A qué profesional se acude para revisar los dientes?",
            opciones = listOf("Odontólogo", "Arquitecto", "Entrenador"),
            respuestaCorrecta = "Odontólogo",
            recompensa = 10
        ),
        RetoIA(
            id = 5,
            titulo = "Edificio J",
            dificultad = "Fácil",
            pista = "Pensá en una sustancia usada para limpiar dientes.",
            pregunta = "¿Qué producto se usa normalmente junto con el cepillo dental?",
            opciones = listOf("Pasta dental", "Aceite de motor", "Pegamento"),
            respuestaCorrecta = "Pasta dental",
            recompensa = 10
        ),
        RetoIA(
            id = 6,
            titulo = "Edificio J",
            dificultad = "Fácil",
            pista = "Las encías también forman parte de la salud bucal.",
            pregunta = "¿Qué parte de la boca sostiene y protege los dientes?",
            opciones = listOf("Encías", "Rodillas", "Codos"),
            respuestaCorrecta = "Encías",
            recompensa = 10
        ),
        RetoIA(
            id = 7,
            titulo = "Edificio J",
            dificultad = "Fácil",
            pista = "El mal hábito puede causar problemas.",
            pregunta = "¿Qué puede pasar si no se cuidan los dientes?",
            opciones = listOf("Aparecen caries", "Los dientes se fortalecen solos", "No ocurre nada nunca"),
            respuestaCorrecta = "Aparecen caries",
            recompensa = 10
        ),
        RetoIA(
            id = 8,
            titulo = "Edificio J",
            dificultad = "Fácil",
            pista = "El agua es mejor que bebidas con exceso de azúcar.",
            pregunta = "¿Qué bebida es mejor para cuidar los dientes durante el día?",
            opciones = listOf("Agua", "Refresco todo el día", "Bebidas muy azucaradas"),
            respuestaCorrecta = "Agua",
            recompensa = 10
        ),
        RetoIA(
            id = 9,
            titulo = "Edificio J",
            dificultad = "Fácil",
            pista = "La revisión ayuda a prevenir.",
            pregunta = "¿Para qué sirve una revisión odontológica?",
            opciones = listOf("Detectar problemas bucales", "Reparar computadoras", "Hacer planos"),
            respuestaCorrecta = "Detectar problemas bucales",
            recompensa = 10
        ),

        // 8 preguntas medias - Odontología
        RetoIA(
            id = 10,
            titulo = "Edificio J",
            dificultad = "Media",
            pista = "La placa se relaciona con restos y bacterias.",
            pregunta = "¿Qué puede acumularse en los dientes si no hay buena higiene?",
            opciones = listOf("Placa bacteriana", "Arena limpia", "Pintura escolar"),
            respuestaCorrecta = "Placa bacteriana",
            recompensa = 15
        ),
        RetoIA(
            id = 11,
            titulo = "Edificio J",
            dificultad = "Media",
            pista = "Las caries dañan la estructura dental.",
            pregunta = "¿Qué es una caries?",
            opciones = listOf("Daño en el diente", "Una parte normal del cepillo", "Un tipo de cuaderno"),
            respuestaCorrecta = "Daño en el diente",
            recompensa = 15
        ),
        RetoIA(
            id = 12,
            titulo = "Edificio J",
            dificultad = "Media",
            pista = "La prevención evita tratamientos más complicados.",
            pregunta = "¿Qué ayuda más a prevenir caries?",
            opciones = listOf("Cepillado, hilo dental y control odontológico", "No lavarse la boca", "Comer dulces antes de dormir"),
            respuestaCorrecta = "Cepillado, hilo dental y control odontológico",
            recompensa = 15
        ),
        RetoIA(
            id = 13,
            titulo = "Edificio J",
            dificultad = "Media",
            pista = "El esmalte es una capa protectora.",
            pregunta = "¿Qué función cumple el esmalte dental?",
            opciones = listOf("Proteger el diente", "Mover la lengua", "Producir saliva"),
            respuestaCorrecta = "Proteger el diente",
            recompensa = 15
        ),
        RetoIA(
            id = 14,
            titulo = "Edificio J",
            dificultad = "Media",
            pista = "La limpieza profesional remueve acumulaciones.",
            pregunta = "¿Qué objetivo tiene una limpieza dental profesional?",
            opciones = listOf("Eliminar placa y sarro", "Pintar los labios", "Cambiar la voz"),
            respuestaCorrecta = "Eliminar placa y sarro",
            recompensa = 15
        ),
        RetoIA(
            id = 15,
            titulo = "Edificio J",
            dificultad = "Media",
            pista = "Pensá en una señal de alerta en las encías.",
            pregunta = "¿Qué puede indicar sangrado frecuente en las encías?",
            opciones = listOf("Un problema de salud bucal", "Que todo está perfecto", "Que no se necesita higiene"),
            respuestaCorrecta = "Un problema de salud bucal",
            recompensa = 15
        ),
        RetoIA(
            id = 16,
            titulo = "Edificio J",
            dificultad = "Media",
            pista = "La saliva también protege la boca.",
            pregunta = "¿Qué ayuda a mantener limpia la boca de forma natural?",
            opciones = listOf("Saliva", "Polvo", "Pegamento"),
            respuestaCorrecta = "Saliva",
            recompensa = 15
        ),
        RetoIA(
            id = 17,
            titulo = "Edificio J",
            dificultad = "Media",
            pista = "Los hábitos nocturnos también importan.",
            pregunta = "¿Qué conviene hacer antes de dormir?",
            opciones = listOf("Cepillarse los dientes", "Comer dulces y no lavarse", "No cuidar la boca"),
            respuestaCorrecta = "Cepillarse los dientes",
            recompensa = 15
        ),

        // 8 preguntas difíciles - Odontología
        RetoIA(
            id = 18,
            titulo = "Edificio J",
            dificultad = "Difícil",
            pista = "Analizá la mejor acción ante dolor persistente.",
            pregunta = "Si una persona tiene dolor dental fuerte por varios días, ¿qué debería hacer?",
            opciones = listOf("Consultar al odontólogo", "Ignorarlo siempre", "Masticar objetos duros"),
            respuestaCorrecta = "Consultar al odontólogo",
            recompensa = 20
        ),
        RetoIA(
            id = 19,
            titulo = "Edificio J",
            dificultad = "Difícil",
            pista = "El sarro no se quita fácilmente con cepillado común.",
            pregunta = "¿Por qué es importante retirar el sarro dental?",
            opciones = listOf("Porque puede afectar encías y dientes", "Porque mejora la señal del celular", "Porque reemplaza la alimentación"),
            respuestaCorrecta = "Porque puede afectar encías y dientes",
            recompensa = 20
        ),
        RetoIA(
            id = 20,
            titulo = "Edificio J",
            dificultad = "Difícil",
            pista = "Pensá en el cuidado integral de la boca.",
            pregunta = "¿Cuál combinación es más adecuada para mantener salud bucal?",
            opciones = listOf("Cepillado, hilo dental y revisiones", "Solo dulces y gaseosa", "No usar cepillo nunca"),
            respuestaCorrecta = "Cepillado, hilo dental y revisiones",
            recompensa = 20
        ),
        RetoIA(
            id = 21,
            titulo = "Edificio J",
            dificultad = "Difícil",
            pista = "Las encías inflamadas son una señal importante.",
            pregunta = "¿Qué puede causar una mala higiene bucal prolongada?",
            opciones = listOf("Inflamación de encías", "Mejor visión", "Más resistencia física inmediata"),
            respuestaCorrecta = "Inflamación de encías",
            recompensa = 20
        ),
        RetoIA(
            id = 22,
            titulo = "Edificio J",
            dificultad = "Difícil",
            pista = "La prevención comienza antes del dolor.",
            pregunta = "¿Por qué no se debe visitar al odontólogo solo cuando hay dolor?",
            opciones = listOf("Porque la prevención detecta problemas temprano", "Porque el dolor siempre es falso", "Porque los dientes no cambian nunca"),
            respuestaCorrecta = "Porque la prevención detecta problemas temprano",
            recompensa = 20
        ),
        RetoIA(
            id = 23,
            titulo = "Edificio J",
            dificultad = "Difícil",
            pista = "El desgaste dental puede relacionarse con hábitos.",
            pregunta = "¿Qué hábito puede afectar los dientes con el tiempo?",
            opciones = listOf("Morder objetos duros", "Tomar agua", "Usar hilo dental"),
            respuestaCorrecta = "Morder objetos duros",
            recompensa = 20
        ),
        RetoIA(
            id = 24,
            titulo = "Edificio J",
            dificultad = "Difícil",
            pista = "La boca también requiere observación.",
            pregunta = "¿Qué acción es responsable si aparece una lesión en la boca que no mejora?",
            opciones = listOf("Consultar a un profesional", "Rasparla constantemente", "Ignorarla por meses"),
            respuestaCorrecta = "Consultar a un profesional",
            recompensa = 20
        ),
        RetoIA(
            id = 25,
            titulo = "Edificio J",
            dificultad = "Difícil",
            pista = "Pensá en la relación entre alimento y bacterias.",
            pregunta = "¿Por qué el exceso de azúcar favorece problemas dentales?",
            opciones = listOf("Porque alimenta bacterias que producen daño", "Porque limpia los dientes", "Porque reemplaza el cepillado"),
            respuestaCorrecta = "Porque alimenta bacterias que producen daño",
            recompensa = 20
        )
    )
}

fun preguntasEdificioP(): List<RetoIA> {
    return listOf(
        // 9 preguntas fáciles - Copérnico
        RetoIA(
            id = 1,
            titulo = "Edificio P",
            dificultad = "Fácil",
            pista = "Copérnico se relaciona con astronomía.",
            pregunta = "¿Qué ciencia estudia los astros y el universo?",
            opciones = listOf("Astronomía", "Odontología", "Contabilidad"),
            respuestaCorrecta = "Astronomía",
            recompensa = 10
        ),
        RetoIA(
            id = 2,
            titulo = "Edificio P",
            dificultad = "Fácil",
            pista = "Pensá en el centro del sistema solar.",
            pregunta = "¿Qué estrella está en el centro del sistema solar?",
            opciones = listOf("El Sol", "La Luna", "Júpiter"),
            respuestaCorrecta = "El Sol",
            recompensa = 10
        ),
        RetoIA(
            id = 3,
            titulo = "Edificio P",
            dificultad = "Fácil",
            pista = "La Tierra es el planeta donde vivimos.",
            pregunta = "¿Cómo se llama nuestro planeta?",
            opciones = listOf("Tierra", "Marte", "Venus"),
            respuestaCorrecta = "Tierra",
            recompensa = 10
        ),
        RetoIA(
            id = 4,
            titulo = "Edificio P",
            dificultad = "Fácil",
            pista = "La Luna acompaña a la Tierra.",
            pregunta = "¿Qué cuerpo celeste gira alrededor de la Tierra?",
            opciones = listOf("La Luna", "El Sol", "Saturno"),
            respuestaCorrecta = "La Luna",
            recompensa = 10
        ),
        RetoIA(
            id = 5,
            titulo = "Edificio P",
            dificultad = "Fácil",
            pista = "Un telescopio permite observar objetos lejanos.",
            pregunta = "¿Qué instrumento ayuda a observar estrellas y planetas?",
            opciones = listOf("Telescopio", "Microscopio", "Martillo"),
            respuestaCorrecta = "Telescopio",
            recompensa = 10
        ),
        RetoIA(
            id = 6,
            titulo = "Edificio P",
            dificultad = "Fácil",
            pista = "El día y la noche se relacionan con el giro terrestre.",
            pregunta = "¿Qué movimiento de la Tierra produce el día y la noche?",
            opciones = listOf("Rotación", "Respiración", "Digestión"),
            respuestaCorrecta = "Rotación",
            recompensa = 10
        ),
        RetoIA(
            id = 7,
            titulo = "Edificio P",
            dificultad = "Fácil",
            pista = "Los planetas se mueven alrededor del Sol.",
            pregunta = "¿Qué hacen los planetas en el sistema solar?",
            opciones = listOf("Orbitan alrededor del Sol", "Se quedan completamente inmóviles", "Giran alrededor de una silla"),
            respuestaCorrecta = "Orbitan alrededor del Sol",
            recompensa = 10
        ),
        RetoIA(
            id = 8,
            titulo = "Edificio P",
            dificultad = "Fácil",
            pista = "Marte es conocido por su color rojizo.",
            pregunta = "¿Qué planeta es conocido como el planeta rojo?",
            opciones = listOf("Marte", "Mercurio", "Neptuno"),
            respuestaCorrecta = "Marte",
            recompensa = 10
        ),
        RetoIA(
            id = 9,
            titulo = "Edificio P",
            dificultad = "Fácil",
            pista = "La observación ayuda a aprender sobre el cielo.",
            pregunta = "¿Qué se puede observar mejor con un telescopio?",
            opciones = listOf("La Luna y planetas", "El sonido", "El sabor de la comida"),
            respuestaCorrecta = "La Luna y planetas",
            recompensa = 10
        ),

        // 8 preguntas medias - Copérnico
        RetoIA(
            id = 10,
            titulo = "Edificio P",
            dificultad = "Media",
            pista = "Copérnico defendió una idea sobre el Sol.",
            pregunta = "¿Qué modelo defendió Nicolás Copérnico?",
            opciones = listOf("Heliocéntrico", "Geocéntrico", "Submarino"),
            respuestaCorrecta = "Heliocéntrico",
            recompensa = 15
        ),
        RetoIA(
            id = 11,
            titulo = "Edificio P",
            dificultad = "Media",
            pista = "Helio se relaciona con el Sol.",
            pregunta = "¿Qué significa que un modelo sea heliocéntrico?",
            opciones = listOf("Que el Sol está en el centro", "Que la Tierra no existe", "Que la Luna es una estrella"),
            respuestaCorrecta = "Que el Sol está en el centro",
            recompensa = 15
        ),
        RetoIA(
            id = 12,
            titulo = "Edificio P",
            dificultad = "Media",
            pista = "La traslación se relaciona con el año.",
            pregunta = "¿Qué movimiento de la Tierra alrededor del Sol se relaciona con el año?",
            opciones = listOf("Traslación", "Parpadeo", "Evaporación"),
            respuestaCorrecta = "Traslación",
            recompensa = 15
        ),
        RetoIA(
            id = 13,
            titulo = "Edificio P",
            dificultad = "Media",
            pista = "La ciencia se basa en observar y comprobar.",
            pregunta = "¿Qué acción es clave en el trabajo científico?",
            opciones = listOf("Observar y analizar evidencias", "Inventar sin revisar", "Ignorar resultados"),
            respuestaCorrecta = "Observar y analizar evidencias",
            recompensa = 15
        ),
        RetoIA(
            id = 14,
            titulo = "Edificio P",
            dificultad = "Media",
            pista = "Un eclipse ocurre por alineación de cuerpos celestes.",
            pregunta = "¿Qué fenómeno puede ocurrir cuando la Luna se interpone entre el Sol y la Tierra?",
            opciones = listOf("Eclipse solar", "Terremoto seguro", "Arcoíris nocturno"),
            respuestaCorrecta = "Eclipse solar",
            recompensa = 15
        ),
        RetoIA(
            id = 15,
            titulo = "Edificio P",
            dificultad = "Media",
            pista = "Los planetas no tienen luz propia como las estrellas.",
            pregunta = "¿Por qué vemos algunos planetas brillando en el cielo?",
            opciones = listOf("Porque reflejan luz del Sol", "Porque son lámparas", "Porque producen sonido"),
            respuestaCorrecta = "Porque reflejan luz del Sol",
            recompensa = 15
        ),
        RetoIA(
            id = 16,
            titulo = "Edificio P",
            dificultad = "Media",
            pista = "La gravedad influye en el movimiento de los cuerpos.",
            pregunta = "¿Qué fuerza ayuda a mantener a los planetas en órbita?",
            opciones = listOf("Gravedad", "Ruido", "Electricidad doméstica"),
            respuestaCorrecta = "Gravedad",
            recompensa = 15
        ),
        RetoIA(
            id = 17,
            titulo = "Edificio P",
            dificultad = "Media",
            pista = "La curiosidad científica permite descubrir.",
            pregunta = "¿Qué actitud favorece el aprendizaje científico?",
            opciones = listOf("Curiosidad y pensamiento crítico", "Rechazar toda evidencia", "Copiar sin comprender"),
            respuestaCorrecta = "Curiosidad y pensamiento crítico",
            recompensa = 15
        ),

        // 8 preguntas difíciles - Copérnico
        RetoIA(
            id = 18,
            titulo = "Edificio P",
            dificultad = "Difícil",
            pista = "Compará dos modelos astronómicos.",
            pregunta = "¿Qué diferencia principal hay entre el modelo geocéntrico y el heliocéntrico?",
            opciones = listOf("Uno pone a la Tierra en el centro y el otro al Sol", "Ambos dicen que no existen planetas", "Ambos son sobre medicina"),
            respuestaCorrecta = "Uno pone a la Tierra en el centro y el otro al Sol",
            recompensa = 20
        ),
        RetoIA(
            id = 19,
            titulo = "Edificio P",
            dificultad = "Difícil",
            pista = "Pensá en cómo cambia el conocimiento científico.",
            pregunta = "¿Por qué las ideas de Copérnico fueron importantes?",
            opciones = listOf("Porque cambiaron la forma de entender el sistema solar", "Porque eliminaron la observación", "Porque negaron toda ciencia"),
            respuestaCorrecta = "Porque cambiaron la forma de entender el sistema solar",
            recompensa = 20
        ),
        RetoIA(
            id = 20,
            titulo = "Edificio P",
            dificultad = "Difícil",
            pista = "La evidencia ayuda a sostener teorías.",
            pregunta = "¿Qué necesita una explicación científica para ser aceptada?",
            opciones = listOf("Evidencia y razonamiento", "Solo opiniones", "Rumores sin comprobar"),
            respuestaCorrecta = "Evidencia y razonamiento",
            recompensa = 20
        ),
        RetoIA(
            id = 21,
            titulo = "Edificio P",
            dificultad = "Difícil",
            pista = "La rotación y la traslación no son lo mismo.",
            pregunta = "¿Cuál opción describe correctamente la rotación terrestre?",
            opciones = listOf("La Tierra gira sobre su propio eje", "La Tierra desaparece de noche", "El Sol gira alrededor de una nube"),
            respuestaCorrecta = "La Tierra gira sobre su propio eje",
            recompensa = 20
        ),
        RetoIA(
            id = 22,
            titulo = "Edificio P",
            dificultad = "Difícil",
            pista = "Un año se relaciona con una vuelta completa.",
            pregunta = "¿Qué representa aproximadamente una vuelta completa de la Tierra alrededor del Sol?",
            opciones = listOf("Un año", "Un minuto", "Un parpadeo"),
            respuestaCorrecta = "Un año",
            recompensa = 20
        ),
        RetoIA(
            id = 23,
            titulo = "Edificio P",
            dificultad = "Difícil",
            pista = "Pensá en la forma correcta de investigar.",
            pregunta = "Si una observación contradice una idea previa, ¿qué debería hacer un científico?",
            opciones = listOf("Revisar la explicación con base en evidencias", "Ignorar la observación", "Ocultar los datos"),
            respuestaCorrecta = "Revisar la explicación con base en evidencias",
            recompensa = 20
        ),
        RetoIA(
            id = 24,
            titulo = "Edificio P",
            dificultad = "Difícil",
            pista = "Las fases lunares dependen de la luz solar.",
            pregunta = "¿Por qué vemos diferentes fases de la Luna?",
            opciones = listOf("Por la parte iluminada visible desde la Tierra", "Porque la Luna cambia de material", "Porque el Sol se apaga cada semana"),
            respuestaCorrecta = "Por la parte iluminada visible desde la Tierra",
            recompensa = 20
        ),
        RetoIA(
            id = 25,
            titulo = "Edificio P",
            dificultad = "Difícil",
            pista = "La astronomía combina observación y cálculo.",
            pregunta = "¿Qué habilidad ayuda más a interpretar fenómenos astronómicos?",
            opciones = listOf("Razonamiento lógico y observación", "Adivinar sin mirar", "Repetir sin analizar"),
            respuestaCorrecta = "Razonamiento lógico y observación",
            recompensa = 20
        )
    )
}

fun preguntasEdificioO(): List<RetoIA> {
    return listOf(
        // 9 preguntas fáciles - Ingeniería y Arquitectura
        RetoIA(
            id = 1,
            titulo = "Edificio O",
            dificultad = "Fácil",
            pista = "Pensá en una carrera relacionada con crear soluciones.",
            pregunta = "¿Qué área se relaciona con diseñar y construir soluciones técnicas?",
            opciones = listOf("Ingeniería", "Odontología", "Deporte"),
            respuestaCorrecta = "Ingeniería",
            recompensa = 10
        ),
        RetoIA(
            id = 2,
            titulo = "Edificio O",
            dificultad = "Fácil",
            pista = "La arquitectura se relaciona con espacios y edificios.",
            pregunta = "¿Qué profesión diseña espacios y edificios?",
            opciones = listOf("Arquitectura", "Medicina", "Derecho penal"),
            respuestaCorrecta = "Arquitectura",
            recompensa = 10
        ),
        RetoIA(
            id = 3,
            titulo = "Edificio O",
            dificultad = "Fácil",
            pista = "Los planos ayudan antes de construir.",
            pregunta = "¿Qué documento visual ayuda a representar una construcción antes de hacerla?",
            opciones = listOf("Plano", "Receta", "Acta deportiva"),
            respuestaCorrecta = "Plano",
            recompensa = 10
        ),
        RetoIA(
            id = 4,
            titulo = "Edificio O",
            dificultad = "Fácil",
            pista = "Las matemáticas ayudan a resolver problemas técnicos.",
            pregunta = "¿Qué materia es muy útil en ingeniería?",
            opciones = listOf("Matemática", "Adivinanza", "Improvisación sin cálculo"),
            respuestaCorrecta = "Matemática",
            recompensa = 10
        ),
        RetoIA(
            id = 5,
            titulo = "Edificio O",
            dificultad = "Fácil",
            pista = "Pensá en un material resistente.",
            pregunta = "¿Qué material se usa comúnmente para dar resistencia en estructuras?",
            opciones = listOf("Acero", "Papel higiénico", "Algodón"),
            respuestaCorrecta = "Acero",
            recompensa = 10
        ),
        RetoIA(
            id = 6,
            titulo = "Edificio O",
            dificultad = "Fácil",
            pista = "Programar es dar instrucciones.",
            pregunta = "¿Qué se crea al escribir instrucciones para una computadora?",
            opciones = listOf("Programa", "Zapato", "Cepillo dental"),
            respuestaCorrecta = "Programa",
            recompensa = 10
        ),
        RetoIA(
            id = 7,
            titulo = "Edificio O",
            dificultad = "Fácil",
            pista = "La seguridad es importante en construcción.",
            pregunta = "¿Qué se debe usar en una zona de construcción para proteger la cabeza?",
            opciones = listOf("Casco", "Sombrero de papel", "Audífonos solamente"),
            respuestaCorrecta = "Casco",
            recompensa = 10
        ),
        RetoIA(
            id = 8,
            titulo = "Edificio O",
            dificultad = "Fácil",
            pista = "El diseño debe ser útil y seguro.",
            pregunta = "¿Qué debe buscar una buena construcción?",
            opciones = listOf("Seguridad y funcionalidad", "Desorden y peligro", "Improvisación total"),
            respuestaCorrecta = "Seguridad y funcionalidad",
            recompensa = 10
        ),
        RetoIA(
            id = 9,
            titulo = "Edificio O",
            dificultad = "Fácil",
            pista = "La lógica ayuda a resolver problemas.",
            pregunta = "¿Qué habilidad es útil para resolver problemas de programación?",
            opciones = listOf("Pensamiento lógico", "Memorizar sin entender", "Ignorar errores"),
            respuestaCorrecta = "Pensamiento lógico",
            recompensa = 10
        ),

        // 8 preguntas medias
        RetoIA(
            id = 10,
            titulo = "Edificio O",
            dificultad = "Media",
            pista = "Una estructura necesita soportes.",
            pregunta = "¿Qué elemento ayuda a soportar y distribuir cargas en un edificio?",
            opciones = listOf("Vigas", "Cortinas", "Carteles"),
            respuestaCorrecta = "Vigas",
            recompensa = 15
        ),
        RetoIA(
            id = 11,
            titulo = "Edificio O",
            dificultad = "Media",
            pista = "Antes de construir se debe planificar.",
            pregunta = "¿Qué conviene hacer antes de iniciar una construcción?",
            opciones = listOf("Diseñar planos y calcular", "Construir sin medir", "Ignorar el terreno"),
            respuestaCorrecta = "Diseñar planos y calcular",
            recompensa = 15
        ),
        RetoIA(
            id = 12,
            titulo = "Edificio O",
            dificultad = "Media",
            pista = "El algoritmo es una secuencia de pasos.",
            pregunta = "¿Qué es un algoritmo?",
            opciones = listOf("Un conjunto ordenado de pasos", "Un tipo de cemento", "Una enfermedad"),
            respuestaCorrecta = "Un conjunto ordenado de pasos",
            recompensa = 15
        ),
        RetoIA(
            id = 13,
            titulo = "Edificio O",
            dificultad = "Media",
            pista = "La escala permite representar objetos grandes en papel.",
            pregunta = "¿Para qué sirve la escala en un plano?",
            opciones = listOf("Para representar medidas proporcionalmente", "Para cambiar el clima", "Para borrar una construcción"),
            respuestaCorrecta = "Para representar medidas proporcionalmente",
            recompensa = 15
        ),
        RetoIA(
            id = 14,
            titulo = "Edificio O",
            dificultad = "Media",
            pista = "El concreto se usa mucho en construcción.",
            pregunta = "¿Qué material se usa comúnmente en columnas y losas?",
            opciones = listOf("Concreto", "Tela", "Cartón mojado"),
            respuestaCorrecta = "Concreto",
            recompensa = 15
        ),
        RetoIA(
            id = 15,
            titulo = "Edificio O",
            dificultad = "Media",
            pista = "Depurar significa buscar errores.",
            pregunta = "¿Qué significa depurar un programa?",
            opciones = listOf("Buscar y corregir errores", "Cambiar el color de la pantalla", "Apagar la computadora"),
            respuestaCorrecta = "Buscar y corregir errores",
            recompensa = 15
        ),
        RetoIA(
            id = 16,
            titulo = "Edificio O",
            dificultad = "Media",
            pista = "La arquitectura también considera a las personas.",
            pregunta = "¿Qué debe tomar en cuenta un diseño arquitectónico?",
            opciones = listOf("Necesidades de los usuarios", "Solo el azar", "Ignorar accesos"),
            respuestaCorrecta = "Necesidades de los usuarios",
            recompensa = 15
        ),
        RetoIA(
            id = 17,
            titulo = "Edificio O",
            dificultad = "Media",
            pista = "La ingeniería busca soluciones prácticas.",
            pregunta = "¿Qué caracteriza una solución de ingeniería?",
            opciones = listOf("Resolver un problema de forma eficiente", "Crear más problemas", "Evitar toda prueba"),
            respuestaCorrecta = "Resolver un problema de forma eficiente",
            recompensa = 15
        ),

        // 8 preguntas difíciles
        RetoIA(
            id = 18,
            titulo = "Edificio O",
            dificultad = "Difícil",
            pista = "Analizá el orden correcto de trabajo.",
            pregunta = "¿Cuál sería un proceso adecuado para desarrollar una solución técnica?",
            opciones = listOf("Analizar, diseñar, construir y probar", "Construir sin pensar", "Copiar sin revisar"),
            respuestaCorrecta = "Analizar, diseñar, construir y probar",
            recompensa = 20
        ),
        RetoIA(
            id = 19,
            titulo = "Edificio O",
            dificultad = "Difícil",
            pista = "La seguridad estructural depende de cálculos.",
            pregunta = "¿Por qué son importantes los cálculos estructurales?",
            opciones = listOf("Porque ayudan a que la construcción sea segura", "Porque decoran el plano", "Porque evitan usar materiales"),
            respuestaCorrecta = "Porque ayudan a que la construcción sea segura",
            recompensa = 20
        ),
        RetoIA(
            id = 20,
            titulo = "Edificio O",
            dificultad = "Difícil",
            pista = "Pensá en la lógica de programación.",
            pregunta = "Si un programa falla, ¿qué debe hacer primero el programador?",
            opciones = listOf("Revisar el error y analizar la causa", "Borrar todo sin mirar", "Ignorar el problema"),
            respuestaCorrecta = "Revisar el error y analizar la causa",
            recompensa = 20
        ),
        RetoIA(
            id = 21,
            titulo = "Edificio O",
            dificultad = "Difícil",
            pista = "Un buen diseño piensa en uso y acceso.",
            pregunta = "¿Qué significa accesibilidad en arquitectura?",
            opciones = listOf("Diseñar espacios que puedan usar más personas", "Cerrar todos los accesos", "Construir sin entradas"),
            respuestaCorrecta = "Diseñar espacios que puedan usar más personas",
            recompensa = 20
        ),
        RetoIA(
            id = 22,
            titulo = "Edificio O",
            dificultad = "Difícil",
            pista = "La sostenibilidad busca reducir impacto.",
            pregunta = "¿Qué acción se relaciona con una construcción sostenible?",
            opciones = listOf("Aprovechar iluminación natural", "Desperdiciar energía", "Ignorar ventilación"),
            respuestaCorrecta = "Aprovechar iluminación natural",
            recompensa = 20
        ),
        RetoIA(
            id = 23,
            titulo = "Edificio O",
            dificultad = "Difícil",
            pista = "La prueba permite comprobar funcionamiento.",
            pregunta = "¿Por qué se prueban los sistemas antes de entregarlos?",
            opciones = listOf("Para detectar fallos y mejorar calidad", "Para perder tiempo sin razón", "Para evitar que funcionen"),
            respuestaCorrecta = "Para detectar fallos y mejorar calidad",
            recompensa = 20
        ),
        RetoIA(
            id = 24,
            titulo = "Edificio O",
            dificultad = "Difícil",
            pista = "Los planos técnicos deben ser claros.",
            pregunta = "¿Qué problema puede causar un plano mal elaborado?",
            opciones = listOf("Errores en la construcción", "Mejor comprensión automática", "Más seguridad garantizada"),
            respuestaCorrecta = "Errores en la construcción",
            recompensa = 20
        ),
        RetoIA(
            id = 25,
            titulo = "Edificio O",
            dificultad = "Difícil",
            pista = "Pensá en el trabajo en equipo.",
            pregunta = "¿Por qué es importante la coordinación entre ingenieros y arquitectos?",
            opciones = listOf("Para integrar diseño, seguridad y funcionalidad", "Para evitar comunicarse", "Para duplicar errores"),
            respuestaCorrecta = "Para integrar diseño, seguridad y funcionalidad",
            recompensa = 20
        )
    )
}

fun preguntasEdificioK(): List<RetoIA> {
    return listOf(
        // 9 preguntas fáciles - Sección Deportiva
        RetoIA(
            id = 1,
            titulo = "Edificio K",
            dificultad = "Fácil",
            pista = "Antes de entrenar, el cuerpo debe prepararse.",
            pregunta = "¿Qué se recomienda hacer antes de practicar deporte?",
            opciones = listOf("Calentar", "Quedarse inmóvil", "Comer demasiado"),
            respuestaCorrecta = "Calentar",
            recompensa = 10
        ),
        RetoIA(
            id = 2,
            titulo = "Edificio K",
            dificultad = "Fácil",
            pista = "La hidratación es importante.",
            pregunta = "¿Qué bebida es recomendable durante la actividad física?",
            opciones = listOf("Agua", "Solo gaseosa", "Bebidas muy azucaradas siempre"),
            respuestaCorrecta = "Agua",
            recompensa = 10
        ),
        RetoIA(
            id = 3,
            titulo = "Edificio K",
            dificultad = "Fácil",
            pista = "El deporte también forma disciplina.",
            pregunta = "¿Qué valor se fortalece al entrenar con constancia?",
            opciones = listOf("Disciplina", "Desorden", "Pereza"),
            respuestaCorrecta = "Disciplina",
            recompensa = 10
        ),
        RetoIA(
            id = 4,
            titulo = "Edificio K",
            dificultad = "Fácil",
            pista = "El equipo trabaja unido.",
            pregunta = "¿Qué es importante en un deporte de equipo?",
            opciones = listOf("Trabajo en equipo", "Egoísmo total", "No comunicarse"),
            respuestaCorrecta = "Trabajo en equipo",
            recompensa = 10
        ),
        RetoIA(
            id = 5,
            titulo = "Edificio K",
            dificultad = "Fácil",
            pista = "El cuerpo necesita recuperarse.",
            pregunta = "¿Qué ayuda después de una actividad física intensa?",
            opciones = listOf("Descansar", "No dormir", "Entrenar sin parar"),
            respuestaCorrecta = "Descansar",
            recompensa = 10
        ),
        RetoIA(
            id = 6,
            titulo = "Edificio K",
            dificultad = "Fácil",
            pista = "Un buen deportista respeta reglas.",
            pregunta = "¿Qué debe respetarse durante una competencia?",
            opciones = listOf("Reglas del juego", "Trampas", "Golpes innecesarios"),
            respuestaCorrecta = "Reglas del juego",
            recompensa = 10
        ),
        RetoIA(
            id = 7,
            titulo = "Edificio K",
            dificultad = "Fácil",
            pista = "La ropa también ayuda al rendimiento.",
            pregunta = "¿Qué conviene usar al hacer deporte?",
            opciones = listOf("Ropa cómoda", "Zapatos dañados", "Ropa incómoda"),
            respuestaCorrecta = "Ropa cómoda",
            recompensa = 10
        ),
        RetoIA(
            id = 8,
            titulo = "Edificio K",
            dificultad = "Fácil",
            pista = "Moverse ayuda a la salud.",
            pregunta = "¿Qué beneficio tiene la actividad física regular?",
            opciones = listOf("Mejora la condición física", "Siempre debilita el cuerpo", "Evita todo descanso"),
            respuestaCorrecta = "Mejora la condición física",
            recompensa = 10
        ),
        RetoIA(
            id = 9,
            titulo = "Edificio K",
            dificultad = "Fácil",
            pista = "El respeto también forma parte del deporte.",
            pregunta = "¿Cómo se debe tratar a los compañeros durante un juego?",
            opciones = listOf("Con respeto", "Con insultos", "Con empujones innecesarios"),
            respuestaCorrecta = "Con respeto",
            recompensa = 10
        ),

        // 8 preguntas medias
        RetoIA(
            id = 10,
            titulo = "Edificio K",
            dificultad = "Media",
            pista = "La coordinación mejora con práctica.",
            pregunta = "¿Qué capacidad ayuda a realizar movimientos ordenados?",
            opciones = listOf("Coordinación", "Confusión", "Descuido"),
            respuestaCorrecta = "Coordinación",
            recompensa = 15
        ),
        RetoIA(
            id = 11,
            titulo = "Edificio K",
            dificultad = "Media",
            pista = "La resistencia permite mantener esfuerzo.",
            pregunta = "¿Qué capacidad permite realizar actividad física por más tiempo?",
            opciones = listOf("Resistencia", "Sueño inmediato", "Desinterés"),
            respuestaCorrecta = "Resistencia",
            recompensa = 15
        ),
        RetoIA(
            id = 12,
            titulo = "Edificio K",
            dificultad = "Media",
            pista = "Estirar puede ayudar después del esfuerzo.",
            pregunta = "¿Qué puede ayudar a relajar los músculos después de entrenar?",
            opciones = listOf("Estiramiento", "Golpearlos", "No moverlos nunca"),
            respuestaCorrecta = "Estiramiento",
            recompensa = 15
        ),
        RetoIA(
            id = 13,
            titulo = "Edificio K",
            dificultad = "Media",
            pista = "La alimentación influye en el rendimiento.",
            pregunta = "¿Qué ayuda a tener energía para entrenar?",
            opciones = listOf("Alimentación adecuada", "No comer nunca", "Solo dulces siempre"),
            respuestaCorrecta = "Alimentación adecuada",
            recompensa = 15
        ),
        RetoIA(
            id = 14,
            titulo = "Edificio K",
            dificultad = "Media",
            pista = "El calentamiento reduce riesgos.",
            pregunta = "¿Por qué es importante calentar antes de ejercitarse?",
            opciones = listOf("Prepara músculos y articulaciones", "Evita todo movimiento", "Cansa sin razón"),
            respuestaCorrecta = "Prepara músculos y articulaciones",
            recompensa = 15
        ),
        RetoIA(
            id = 15,
            titulo = "Edificio K",
            dificultad = "Media",
            pista = "La comunicación ayuda al equipo.",
            pregunta = "¿Qué mejora el desempeño en un equipo deportivo?",
            opciones = listOf("Comunicación y cooperación", "Desorden y gritos", "Jugar sin reglas"),
            respuestaCorrecta = "Comunicación y cooperación",
            recompensa = 15
        ),
        RetoIA(
            id = 16,
            titulo = "Edificio K",
            dificultad = "Media",
            pista = "El deporte también enseña autocontrol.",
            pregunta = "¿Qué actitud debe tener un jugador ante una derrota?",
            opciones = listOf("Aprender y mejorar", "Agredir al rival", "Abandonar siempre"),
            respuestaCorrecta = "Aprender y mejorar",
            recompensa = 15
        ),
        RetoIA(
            id = 17,
            titulo = "Edificio K",
            dificultad = "Media",
            pista = "Cuidar el cuerpo evita lesiones.",
            pregunta = "¿Qué se debe hacer si aparece dolor fuerte durante el ejercicio?",
            opciones = listOf("Detenerse y buscar orientación", "Forzar más el cuerpo", "Ignorar el dolor"),
            respuestaCorrecta = "Detenerse y buscar orientación",
            recompensa = 15
        ),

        // 8 preguntas difíciles
        RetoIA(
            id = 18,
            titulo = "Edificio K",
            dificultad = "Difícil",
            pista = "Analizá una decisión responsable ante una lesión.",
            pregunta = "Si un jugador se lesiona durante un partido, ¿qué acción es más adecuada?",
            opciones = listOf("Detener la actividad y recibir atención", "Seguir jugando sin revisar", "Ocultar la lesión"),
            respuestaCorrecta = "Detener la actividad y recibir atención",
            recompensa = 20
        ),
        RetoIA(
            id = 19,
            titulo = "Edificio K",
            dificultad = "Difícil",
            pista = "La estrategia también importa.",
            pregunta = "¿Qué ayuda a mejorar el rendimiento de un equipo?",
            opciones = listOf("Plan de juego y roles claros", "Improvisar todo", "No escuchar indicaciones"),
            respuestaCorrecta = "Plan de juego y roles claros",
            recompensa = 20
        ),
        RetoIA(
            id = 20,
            titulo = "Edificio K",
            dificultad = "Difícil",
            pista = "El exceso sin descanso puede ser negativo.",
            pregunta = "¿Qué riesgo existe al entrenar intensamente sin descanso?",
            opciones = listOf("Lesiones o agotamiento", "Mejora garantizada inmediata", "Nunca ocurre nada"),
            respuestaCorrecta = "Lesiones o agotamiento",
            recompensa = 20
        ),
        RetoIA(
            id = 21,
            titulo = "Edificio K",
            dificultad = "Difícil",
            pista = "La ética también aplica al deporte.",
            pregunta = "¿Qué representa el juego limpio?",
            opciones = listOf("Competir respetando reglas y rivales", "Hacer trampa para ganar", "Insultar al oponente"),
            respuestaCorrecta = "Competir respetando reglas y rivales",
            recompensa = 20
        ),
        RetoIA(
            id = 22,
            titulo = "Edificio K",
            dificultad = "Difícil",
            pista = "La condición física se mejora poco a poco.",
            pregunta = "¿Cuál es una forma adecuada de mejorar resistencia física?",
            opciones = listOf("Entrenar de forma progresiva", "Exigirse al máximo sin preparación", "No moverse nunca"),
            respuestaCorrecta = "Entrenar de forma progresiva",
            recompensa = 20
        ),
        RetoIA(
            id = 23,
            titulo = "Edificio K",
            dificultad = "Difícil",
            pista = "La preparación mental influye en el rendimiento.",
            pregunta = "¿Qué actitud ayuda antes de una competencia?",
            opciones = listOf("Concentración y confianza", "Pánico y desorden", "No conocer las reglas"),
            respuestaCorrecta = "Concentración y confianza",
            recompensa = 20
        ),
        RetoIA(
            id = 24,
            titulo = "Edificio K",
            dificultad = "Difícil",
            pista = "El liderazgo deportivo guía al grupo.",
            pregunta = "¿Qué debe hacer un buen capitán de equipo?",
            opciones = listOf("Motivar y organizar al equipo", "Crear conflictos", "Ignorar a todos"),
            respuestaCorrecta = "Motivar y organizar al equipo",
            recompensa = 20
        ),
        RetoIA(
            id = 25,
            titulo = "Edificio K",
            dificultad = "Difícil",
            pista = "La actividad física debe ser segura.",
            pregunta = "¿Qué condición ayuda a practicar deporte de forma segura?",
            opciones = listOf("Espacio adecuado y reglas claras", "Lugar peligroso", "Falta total de supervisión"),
            respuestaCorrecta = "Espacio adecuado y reglas claras",
            recompensa = 20
        )
    )
}

fun preguntasEdificioF(): List<RetoIA> {
    return listOf(
        // 9 preguntas fáciles - Ciencias Jurídicas
        RetoIA(
            id = 1,
            titulo = "Edificio F",
            dificultad = "Fácil",
            pista = "Pensá en normas que ordenan una sociedad.",
            pregunta = "¿Qué son las leyes?",
            opciones = listOf("Normas que regulan la convivencia", "Juegos deportivos", "Recetas de cocina"),
            respuestaCorrecta = "Normas que regulan la convivencia",
            recompensa = 10
        ),
        RetoIA(
            id = 2,
            titulo = "Edificio F",
            dificultad = "Fácil",
            pista = "Los derechos protegen a las personas.",
            pregunta = "¿Qué debe respetarse en una sociedad justa?",
            opciones = listOf("Los derechos de las personas", "Solo la opinión de uno", "El desorden"),
            respuestaCorrecta = "Los derechos de las personas",
            recompensa = 10
        ),
        RetoIA(
            id = 3,
            titulo = "Edificio F",
            dificultad = "Fácil",
            pista = "Un abogado trabaja con normas y conflictos.",
            pregunta = "¿Qué profesional brinda orientación legal?",
            opciones = listOf("Abogado", "Dentista", "Arquitecto"),
            respuestaCorrecta = "Abogado",
            recompensa = 10
        ),
        RetoIA(
            id = 4,
            titulo = "Edificio F",
            dificultad = "Fácil",
            pista = "La convivencia requiere respeto.",
            pregunta = "¿Qué valor ayuda a resolver conflictos de forma pacífica?",
            opciones = listOf("Respeto", "Violencia", "Amenazas"),
            respuestaCorrecta = "Respeto",
            recompensa = 10
        ),
        RetoIA(
            id = 5,
            titulo = "Edificio F",
            dificultad = "Fácil",
            pista = "La justicia busca equilibrio.",
            pregunta = "¿Qué busca la justicia?",
            opciones = listOf("Dar a cada quien lo que corresponde", "Crear desigualdad", "Ignorar los derechos"),
            respuestaCorrecta = "Dar a cada quien lo que corresponde",
            recompensa = 10
        ),
        RetoIA(
            id = 6,
            titulo = "Edificio F",
            dificultad = "Fácil",
            pista = "Un contrato genera acuerdos.",
            pregunta = "¿Qué es un contrato?",
            opciones = listOf("Un acuerdo con obligaciones", "Un juego de azar", "Una comida rápida"),
            respuestaCorrecta = "Un acuerdo con obligaciones",
            recompensa = 10
        ),
        RetoIA(
            id = 7,
            titulo = "Edificio F",
            dificultad = "Fácil",
            pista = "La evidencia ayuda a demostrar hechos.",
            pregunta = "¿Qué puede servir para demostrar un hecho en un conflicto?",
            opciones = listOf("Evidencia", "Rumor", "Adivinanza"),
            respuestaCorrecta = "Evidencia",
            recompensa = 10
        ),
        RetoIA(
            id = 8,
            titulo = "Edificio F",
            dificultad = "Fácil",
            pista = "Todos deben cumplir normas.",
            pregunta = "¿Qué pasa cuando una norma se incumple?",
            opciones = listOf("Puede haber consecuencias", "Siempre se premia", "No importa nunca"),
            respuestaCorrecta = "Puede haber consecuencias",
            recompensa = 10
        ),
        RetoIA(
            id = 9,
            titulo = "Edificio F",
            dificultad = "Fácil",
            pista = "La ética orienta decisiones correctas.",
            pregunta = "¿Qué ayuda a actuar correctamente aunque nadie observe?",
            opciones = listOf("Ética", "Trampa", "Desinterés"),
            respuestaCorrecta = "Ética",
            recompensa = 10
        ),

        // 8 preguntas medias
        RetoIA(
            id = 10,
            titulo = "Edificio F",
            dificultad = "Media",
            pista = "Pensá en normas fundamentales.",
            pregunta = "¿Qué documento reúne principios y normas fundamentales de un país?",
            opciones = listOf("Constitución", "Recibo", "Horario de gimnasio"),
            respuestaCorrecta = "Constitución",
            recompensa = 15
        ),
        RetoIA(
            id = 11,
            titulo = "Edificio F",
            dificultad = "Media",
            pista = "La mediación busca acuerdo.",
            pregunta = "¿Qué busca la mediación en un conflicto?",
            opciones = listOf("Facilitar un acuerdo entre partes", "Aumentar el problema", "Evitar escuchar"),
            respuestaCorrecta = "Facilitar un acuerdo entre partes",
            recompensa = 15
        ),
        RetoIA(
            id = 12,
            titulo = "Edificio F",
            dificultad = "Media",
            pista = "Los deberes también forman parte de la convivencia.",
            pregunta = "¿Qué relación existe entre derechos y deberes?",
            opciones = listOf("Ambos ayudan a ordenar la convivencia", "No tienen ninguna relación", "Solo existen los derechos"),
            respuestaCorrecta = "Ambos ayudan a ordenar la convivencia",
            recompensa = 15
        ),
        RetoIA(
            id = 13,
            titulo = "Edificio F",
            dificultad = "Media",
            pista = "Una denuncia informa un hecho a la autoridad correspondiente.",
            pregunta = "¿Qué se debe hacer ante una situación legal grave?",
            opciones = listOf("Buscar orientación o denunciar ante la autoridad", "Ocultar todo siempre", "Responder con violencia"),
            respuestaCorrecta = "Buscar orientación o denunciar ante la autoridad",
            recompensa = 15
        ),
        RetoIA(
            id = 14,
            titulo = "Edificio F",
            dificultad = "Media",
            pista = "La imparcialidad evita favoritismos.",
            pregunta = "¿Qué significa actuar con imparcialidad?",
            opciones = listOf("Decidir sin favorecer injustamente a alguien", "Elegir siempre al amigo", "Ignorar las pruebas"),
            respuestaCorrecta = "Decidir sin favorecer injustamente a alguien",
            recompensa = 15
        ),
        RetoIA(
            id = 15,
            titulo = "Edificio F",
            dificultad = "Media",
            pista = "La prueba debe relacionarse con el hecho.",
            pregunta = "¿Qué característica debe tener una buena evidencia?",
            opciones = listOf("Ser relevante y verificable", "Ser inventada", "Ser un rumor sin fuente"),
            respuestaCorrecta = "Ser relevante y verificable",
            recompensa = 15
        ),
        RetoIA(
            id = 16,
            titulo = "Edificio F",
            dificultad = "Media",
            pista = "El derecho busca orden social.",
            pregunta = "¿Cuál es una finalidad general del derecho?",
            opciones = listOf("Regular la convivencia social", "Eliminar toda norma", "Crear caos"),
            respuestaCorrecta = "Regular la convivencia social",
            recompensa = 15
        ),
        RetoIA(
            id = 17,
            titulo = "Edificio F",
            dificultad = "Media",
            pista = "Los acuerdos deben entenderse antes de firmarse.",
            pregunta = "¿Qué se debe hacer antes de firmar un contrato?",
            opciones = listOf("Leer y comprender su contenido", "Firmar sin leer", "Romperlo de inmediato"),
            respuestaCorrecta = "Leer y comprender su contenido",
            recompensa = 15
        ),

        // 8 preguntas difíciles
        RetoIA(
            id = 18,
            titulo = "Edificio F",
            dificultad = "Difícil",
            pista = "Analizá la forma correcta de resolver un conflicto.",
            pregunta = "Si dos personas tienen un conflicto legal, ¿qué acción es más adecuada?",
            opciones = listOf("Buscar asesoría y usar medios legales", "Amenazar a la otra persona", "Ocultar documentos"),
            respuestaCorrecta = "Buscar asesoría y usar medios legales",
            recompensa = 20
        ),
        RetoIA(
            id = 19,
            titulo = "Edificio F",
            dificultad = "Difícil",
            pista = "El debido proceso protege derechos.",
            pregunta = "¿Por qué es importante el debido proceso?",
            opciones = listOf("Porque garantiza reglas justas en un procedimiento", "Porque evita escuchar a las partes", "Porque elimina toda defensa"),
            respuestaCorrecta = "Porque garantiza reglas justas en un procedimiento",
            recompensa = 20
        ),
        RetoIA(
            id = 20,
            titulo = "Edificio F",
            dificultad = "Difícil",
            pista = "La legalidad limita acciones arbitrarias.",
            pregunta = "¿Qué significa actuar conforme a la legalidad?",
            opciones = listOf("Actuar de acuerdo con la ley", "Hacer cualquier cosa sin reglas", "Ignorar normas"),
            respuestaCorrecta = "Actuar de acuerdo con la ley",
            recompensa = 20
        ),
        RetoIA(
            id = 21,
            titulo = "Edificio F",
            dificultad = "Difícil",
            pista = "La responsabilidad surge por acciones.",
            pregunta = "¿Qué puede generar una acción que causa daño a otra persona?",
            opciones = listOf("Responsabilidad legal", "Premio automático", "Ausencia total de consecuencias"),
            respuestaCorrecta = "Responsabilidad legal",
            recompensa = 20
        ),
        RetoIA(
            id = 22,
            titulo = "Edificio F",
            dificultad = "Difícil",
            pista = "Pensá en la importancia de la prueba.",
            pregunta = "¿Por qué las pruebas son importantes en un proceso?",
            opciones = listOf("Porque ayudan a comprobar los hechos", "Porque reemplazan la verdad automáticamente", "Porque no sirven nunca"),
            respuestaCorrecta = "Porque ayudan a comprobar los hechos",
            recompensa = 20
        ),
        RetoIA(
            id = 23,
            titulo = "Edificio F",
            dificultad = "Difícil",
            pista = "La ética profesional guía la conducta.",
            pregunta = "¿Qué conducta refleja ética en el ejercicio jurídico?",
            opciones = listOf("Actuar con honestidad y confidencialidad", "Mentir para ganar siempre", "Manipular pruebas"),
            respuestaCorrecta = "Actuar con honestidad y confidencialidad",
            recompensa = 20
        ),
        RetoIA(
            id = 24,
            titulo = "Edificio F",
            dificultad = "Difícil",
            pista = "La igualdad ante la ley es un principio importante.",
            pregunta = "¿Qué implica la igualdad ante la ley?",
            opciones = listOf("Que las personas deben ser tratadas sin discriminación", "Que solo algunos tienen derechos", "Que la ley no aplica a nadie"),
            respuestaCorrecta = "Que las personas deben ser tratadas sin discriminación",
            recompensa = 20
        ),
        RetoIA(
            id = 25,
            titulo = "Edificio F",
            dificultad = "Difícil",
            pista = "Los conflictos deben resolverse con vías adecuadas.",
            pregunta = "¿Qué opción demuestra mejor cultura jurídica?",
            opciones = listOf("Usar diálogo, pruebas y procedimientos legales", "Hacer justicia por cuenta propia", "Destruir evidencia"),
            respuestaCorrecta = "Usar diálogo, pruebas y procedimientos legales",
            recompensa = 20
        )
    )
}

fun preguntasEdificioI(): List<RetoIA> {
    return listOf(
        // 9 preguntas fáciles - Comerciales, Administrativas y Económicas
        RetoIA(
            id = 1,
            titulo = "Edificio I",
            dificultad = "Fácil",
            pista = "Pensá en organizar recursos.",
            pregunta = "¿Qué área se encarga de organizar recursos en una empresa?",
            opciones = listOf("Administración", "Astronomía", "Odontología"),
            respuestaCorrecta = "Administración",
            recompensa = 10
        ),
        RetoIA(
            id = 2,
            titulo = "Edificio I",
            dificultad = "Fácil",
            pista = "El dinero que entra se llama ingreso.",
            pregunta = "¿Cómo se llama el dinero que recibe una persona o empresa?",
            opciones = listOf("Ingreso", "Pérdida", "Ruido"),
            respuestaCorrecta = "Ingreso",
            recompensa = 10
        ),
        RetoIA(
            id = 3,
            titulo = "Edificio I",
            dificultad = "Fácil",
            pista = "Planificar ayuda a evitar improvisación.",
            pregunta = "¿Qué acción mejora la organización de una empresa?",
            opciones = listOf("Planificar", "Improvisar todo", "Ignorar objetivos"),
            respuestaCorrecta = "Planificar",
            recompensa = 10
        ),
        RetoIA(
            id = 4,
            titulo = "Edificio I",
            dificultad = "Fácil",
            pista = "Un presupuesto ordena ingresos y gastos.",
            pregunta = "¿Qué ayuda a controlar ingresos y gastos?",
            opciones = listOf("Presupuesto", "Adivinanza", "Rumor"),
            respuestaCorrecta = "Presupuesto",
            recompensa = 10
        ),
        RetoIA(
            id = 5,
            titulo = "Edificio I",
            dificultad = "Fácil",
            pista = "El cliente es importante en los negocios.",
            pregunta = "¿A quién busca satisfacer una empresa con sus productos o servicios?",
            opciones = listOf("Cliente", "Solo a la competencia", "A nadie"),
            respuestaCorrecta = "Cliente",
            recompensa = 10
        ),
        RetoIA(
            id = 6,
            titulo = "Edificio I",
            dificultad = "Fácil",
            pista = "El ahorro ayuda a prepararse.",
            pregunta = "¿Qué hábito financiero es recomendable?",
            opciones = listOf("Ahorrar", "Gastar sin control", "No registrar nada"),
            respuestaCorrecta = "Ahorrar",
            recompensa = 10
        ),
        RetoIA(
            id = 7,
            titulo = "Edificio I",
            dificultad = "Fácil",
            pista = "La economía estudia recursos.",
            pregunta = "¿Qué estudia la economía de forma general?",
            opciones = listOf("Uso de recursos", "Cepillado dental", "Eclipses solamente"),
            respuestaCorrecta = "Uso de recursos",
            recompensa = 10
        ),
        RetoIA(
            id = 8,
            titulo = "Edificio I",
            dificultad = "Fácil",
            pista = "Vender es parte del comercio.",
            pregunta = "¿Qué actividad se relaciona con el comercio?",
            opciones = listOf("Compra y venta", "Dormir todo el día", "Ignorar clientes"),
            respuestaCorrecta = "Compra y venta",
            recompensa = 10
        ),
        RetoIA(
            id = 9,
            titulo = "Edificio I",
            dificultad = "Fácil",
            pista = "Los objetivos guían el trabajo.",
            pregunta = "¿Para qué sirven los objetivos en una organización?",
            opciones = listOf("Para orientar acciones", "Para crear confusión", "Para evitar trabajar"),
            respuestaCorrecta = "Para orientar acciones",
            recompensa = 10
        ),

        // 8 preguntas medias
        RetoIA(
            id = 10,
            titulo = "Edificio I",
            dificultad = "Media",
            pista = "Los costos afectan las ganancias.",
            pregunta = "¿Qué representa un costo para una empresa?",
            opciones = listOf("Un gasto necesario para producir o vender", "Dinero que aparece sin razón", "Un premio deportivo"),
            respuestaCorrecta = "Un gasto necesario para producir o vender",
            recompensa = 15
        ),
        RetoIA(
            id = 11,
            titulo = "Edificio I",
            dificultad = "Media",
            pista = "La ganancia aparece cuando ingresos superan gastos.",
            pregunta = "¿Cuándo una empresa obtiene ganancia?",
            opciones = listOf("Cuando sus ingresos superan sus costos", "Cuando nunca vende", "Cuando todo es pérdida"),
            respuestaCorrecta = "Cuando sus ingresos superan sus costos",
            recompensa = 15
        ),
        RetoIA(
            id = 12,
            titulo = "Edificio I",
            dificultad = "Media",
            pista = "El liderazgo guía personas.",
            pregunta = "¿Qué hace un buen líder en una organización?",
            opciones = listOf("Orienta y motiva al equipo", "Confunde al grupo", "Evita comunicarse"),
            respuestaCorrecta = "Orienta y motiva al equipo",
            recompensa = 15
        ),
        RetoIA(
            id = 13,
            titulo = "Edificio I",
            dificultad = "Media",
            pista = "El mercado reúne compradores y vendedores.",
            pregunta = "¿Qué es un mercado en términos económicos?",
            opciones = listOf("Espacio donde se intercambian bienes o servicios", "Un salón vacío", "Un tipo de enfermedad"),
            respuestaCorrecta = "Espacio donde se intercambian bienes o servicios",
            recompensa = 15
        ),
        RetoIA(
            id = 14,
            titulo = "Edificio I",
            dificultad = "Media",
            pista = "La demanda se relaciona con lo que quieren comprar.",
            pregunta = "¿Qué representa la demanda?",
            opciones = listOf("Cantidad que los consumidores desean comprar", "Cantidad de ruido", "Número de sillas rotas"),
            respuestaCorrecta = "Cantidad que los consumidores desean comprar",
            recompensa = 15
        ),
        RetoIA(
            id = 15,
            titulo = "Edificio I",
            dificultad = "Media",
            pista = "El inventario ayuda a controlar productos.",
            pregunta = "¿Para qué sirve llevar inventario?",
            opciones = listOf("Controlar existencias", "Olvidar productos", "Evitar vender"),
            respuestaCorrecta = "Controlar existencias",
            recompensa = 15
        ),
        RetoIA(
            id = 16,
            titulo = "Edificio I",
            dificultad = "Media",
            pista = "El marketing comunica valor al cliente.",
            pregunta = "¿Qué busca el marketing?",
            opciones = listOf("Promover productos o servicios", "Ocultar la empresa", "Eliminar clientes"),
            respuestaCorrecta = "Promover productos o servicios",
            recompensa = 15
        ),
        RetoIA(
            id = 17,
            titulo = "Edificio I",
            dificultad = "Media",
            pista = "La toma de decisiones requiere información.",
            pregunta = "¿Qué ayuda a tomar mejores decisiones administrativas?",
            opciones = listOf("Analizar información", "Adivinar siempre", "Ignorar datos"),
            respuestaCorrecta = "Analizar información",
            recompensa = 15
        ),

        // 8 preguntas difíciles
        RetoIA(
            id = 18,
            titulo = "Edificio I",
            dificultad = "Difícil",
            pista = "Analizá ingresos y costos.",
            pregunta = "Si una empresa vende mucho pero sus costos son mayores que sus ingresos, ¿qué ocurre?",
            opciones = listOf("Tiene pérdida", "Tiene ganancia segura", "No pasa nada"),
            respuestaCorrecta = "Tiene pérdida",
            recompensa = 20
        ),
        RetoIA(
            id = 19,
            titulo = "Edificio I",
            dificultad = "Difícil",
            pista = "La estrategia define el camino.",
            pregunta = "¿Qué es una estrategia empresarial?",
            opciones = listOf("Plan para alcanzar objetivos", "Acción sin propósito", "Lista de excusas"),
            respuestaCorrecta = "Plan para alcanzar objetivos",
            recompensa = 20
        ),
        RetoIA(
            id = 20,
            titulo = "Edificio I",
            dificultad = "Difícil",
            pista = "El punto de equilibrio se relaciona con no ganar ni perder.",
            pregunta = "¿Qué indica el punto de equilibrio?",
            opciones = listOf("El nivel donde ingresos cubren costos", "El momento de cerrar siempre", "La cantidad de empleados enfermos"),
            respuestaCorrecta = "El nivel donde ingresos cubren costos",
            recompensa = 20
        ),
        RetoIA(
            id = 21,
            titulo = "Edificio I",
            dificultad = "Difícil",
            pista = "La inversión busca retorno futuro.",
            pregunta = "¿Qué se espera al realizar una inversión?",
            opciones = listOf("Obtener beneficio futuro", "Perder siempre", "No recibir nada nunca"),
            respuestaCorrecta = "Obtener beneficio futuro",
            recompensa = 20
        ),
        RetoIA(
            id = 22,
            titulo = "Edificio I",
            dificultad = "Difícil",
            pista = "La productividad relaciona recursos y resultados.",
            pregunta = "¿Qué significa mejorar la productividad?",
            opciones = listOf("Lograr mejores resultados con recursos adecuados", "Trabajar más sin resultados", "Usar recursos sin control"),
            respuestaCorrecta = "Lograr mejores resultados con recursos adecuados",
            recompensa = 20
        ),
        RetoIA(
            id = 23,
            titulo = "Edificio I",
            dificultad = "Difícil",
            pista = "El flujo de caja muestra movimiento de dinero.",
            pregunta = "¿Por qué es importante controlar el flujo de caja?",
            opciones = listOf("Para saber entradas y salidas de dinero", "Para decorar informes", "Para evitar registrar ventas"),
            respuestaCorrecta = "Para saber entradas y salidas de dinero",
            recompensa = 20
        ),
        RetoIA(
            id = 24,
            titulo = "Edificio I",
            dificultad = "Difícil",
            pista = "La competencia obliga a mejorar.",
            pregunta = "¿Qué puede hacer una empresa para diferenciarse de la competencia?",
            opciones = listOf("Ofrecer valor y buen servicio", "Copiar sin mejorar", "Tratar mal al cliente"),
            respuestaCorrecta = "Ofrecer valor y buen servicio",
            recompensa = 20
        ),
        RetoIA(
            id = 25,
            titulo = "Edificio I",
            dificultad = "Difícil",
            pista = "El análisis financiero orienta decisiones.",
            pregunta = "¿Para qué sirve analizar estados financieros?",
            opciones = listOf("Para evaluar la situación económica", "Para adivinar sin datos", "Para ocultar resultados"),
            respuestaCorrecta = "Para evaluar la situación económica",
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
        "edificioE" -> preguntasEdificioE()
        "edificioJ" -> preguntasEdificioJ()
        "edificioP" -> preguntasEdificioP()
        "edificioO" -> preguntasEdificioO()
        "edificioK" -> preguntasEdificioK()
        "edificioF" -> preguntasEdificioF()
        "edificioI" -> preguntasEdificioI()
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

    val preguntasKey = preguntasUsadas.joinToString()
    val reto = remember(nivel, numeroNivel, preguntasKey) {
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

    LaunchedEffect(nivel, numeroNivel, preguntasKey) {
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