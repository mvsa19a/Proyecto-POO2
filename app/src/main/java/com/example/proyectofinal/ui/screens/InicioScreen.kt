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
fun PantallaInicio(
    onStart: () -> Unit
) {

    // Fondo degradado
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF5B4BFF),
            Color(0xFFE96BA8)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient),
        contentAlignment = Alignment.Center
    ) {

        // 🪪 Tarjeta central
        Card(
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Escape UAM",
                    fontSize = 24.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Explorá edificios, resolvé retos y desbloqueá pistas para avanzar al siguiente nivel.",
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Botón principal
                Button(
                    onClick = onStart,
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Comenzar juego")
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Botón secundario
                OutlinedButton(
                    onClick = { },
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Ver instrucciones")
                }
            }
        }
    }
}
