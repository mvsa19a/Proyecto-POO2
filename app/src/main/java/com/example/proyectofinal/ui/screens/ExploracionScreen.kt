package com.example.proyectofinal.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaExploracion(
    onPistaEncontrada: () -> Unit,
    onBack: () -> Unit
) {
    var fila by remember { mutableStateOf(1) }
    var columna by remember { mutableStateOf(1) }

    val pistaFila = 0
    val pistaColumna = 3

    val encontroPista = fila == pistaFila && columna == pistaColumna

    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF1B1B3A), Color(0xFF693668), Color(0xFFE96BA8))
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(18.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(18.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Exploración del Edificio", fontSize = 24.sp)

                Spacer(modifier = Modifier.height(10.dp))

                Text("Mové al personaje hasta encontrar la pista escondida.")

                Spacer(modifier = Modifier.height(20.dp))

                for (i in 0..3) {
                    Row {
                        for (j in 0..3) {
                            val texto = when {
                                fila == i && columna == j -> "🧍"
                                pistaFila == i && pistaColumna == j -> "🔎"
                                else -> "⬜"
                            }

                            Text(
                                text = texto,
                                fontSize = 28.sp,
                                modifier = Modifier.padding(6.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(onClick = { if (fila > 0) fila-- }) {
                    Text("Arriba")
                }

                Row {
                    Button(onClick = { if (columna > 0) columna-- }) {
                        Text("Izquierda")
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Button(onClick = { if (columna < 3) columna++ }) {
                        Text("Derecha")
                    }
                }

                Button(onClick = { if (fila < 3) fila++ }) {
                    Text("Abajo")
                }

                Spacer(modifier = Modifier.height(16.dp))

                if (encontroPista) {
                    Text("Encontraste la pista. Ganaste 15 puntos.")

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = onPistaEncontrada,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Continuar")
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedButton(
                    onClick = onBack,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Volver")
                }
            }
        }
    }
}