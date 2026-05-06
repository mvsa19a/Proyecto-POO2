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
fun PantallaNiveles(
    onNivelSeleccionado: (String) -> Unit,
    onBack: () -> Unit
) {
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF052E16),
            Color(0xFF166534),
            Color(0xFF4ADE80)
        )
    )

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
                Text("🗺 Habitaciones", fontSize = 32.sp)

                Spacer(modifier = Modifier.height(8.dp))

                Text("Seleccioná un lugar para resolver el reto.")

                Spacer(modifier = Modifier.height(22.dp))

                Button(
                    onClick = { onNivelSeleccionado("edificioA") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50)
                ) {
                    Text("🏢 Edificio A - Reto basico")
                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = { onNivelSeleccionado("biblioteca") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50)
                ) {
                    Text("📚 Biblioteca Central - Reto avanzado")
                }

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedButton(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50)
                ) {
                    Text("🔒 Edificio B bloqueado")
                }

                Spacer(modifier = Modifier.height(20.dp))

                OutlinedButton(
                    onClick = onBack,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50)
                ) {
                    Text("⬅ Volver")
                }
            }
        }
    }
}