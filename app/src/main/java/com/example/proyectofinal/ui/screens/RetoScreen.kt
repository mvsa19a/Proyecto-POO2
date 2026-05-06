package com.example.proyectofinal.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaReto(
    nivel: String,
    onCorrecto: () -> Unit,
    onIncorrecto: () -> Unit,
    onBack: () -> Unit
) {
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF450A0A),
            Color(0xFF991B1B),
            Color(0xFFF97316)
        )
    )

    val titulo: String
    val pregunta: String
    val opcionCorrecta: String
    val opcionIncorrecta: String
    val puntos: String

    if (nivel == "biblioteca") {
        titulo = "Biblioteca Central"
        pregunta = "Para avanzar, resolvé esta pista: si cada sala tiene 4 mesas y cada mesa tiene 3 pistas, ¿cuántas pistas hay en 5 salas?"
        opcionCorrecta = "60 pistas"
        opcionIncorrecta = "35 pistas"
        puntos = "Recompensa: 20 puntos"
    } else {
        titulo = "Edificio A"
        pregunta = "¿Cuál es un hábito saludable?"
        opcionCorrecta = "Beber agua"
        opcionIncorrecta = "No dormir"
        puntos = "Recompensa: 10 puntos"
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(22.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("🧠 $titulo", fontSize = 32.sp)

                Spacer(modifier = Modifier.height(10.dp))

                Text(puntos)

                Spacer(modifier = Modifier.height(20.dp))

                Text(pregunta)

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = onCorrecto,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50)
                ) {
                    Text(opcionCorrecta)
                }

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedButton(
                    onClick = onIncorrecto,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50)
                ) {
                    Text(opcionIncorrecta)
                }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedButton(
                    onClick = onBack,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50)
                ) {
                    Text("⬅ Volver a niveles")
                }
            }
        }
    }
}