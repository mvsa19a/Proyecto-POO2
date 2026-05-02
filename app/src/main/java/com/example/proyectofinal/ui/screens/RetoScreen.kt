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
    onCorrecto: () -> Unit,
    onIncorrecto: () -> Unit
) {

    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF5B4BFF), Color(0xFFE96BA8))
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient),
        contentAlignment = Alignment.Center
    ) {

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

                Text("Reto", fontSize = 24.sp)

                Spacer(modifier = Modifier.height(20.dp))

                Text("¿Cuál es un hábito saludable?")

                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    onClick = onCorrecto,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50)
                ) {
                    Text("Beber agua")
                }

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedButton(
                    onClick = onIncorrecto,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50)
                ) {
                    Text("No dormir")
                }
            }
        }
    }
}