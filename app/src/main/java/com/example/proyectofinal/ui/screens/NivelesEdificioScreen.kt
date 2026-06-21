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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.LinearProgressIndicator

@Composable
fun NivelesEdificioScreen(
    edificioCodigo: String,
    nombreEdificio: String,
    descripcionEdificio: String,
    progresoActual: Int,
    totalNiveles: Int,
    onNivelSeleccionado: (Int) -> Unit,
    onBack: () -> Unit
) {
    val celeste = Color(0xFF32A0A6)
    val celesteOscuro = Color(0xFF187C84)
    val fondoClaro = Color(0xFFF3FBFC)
    val textoPrincipal = Color(0xFF1F2937)
    val textoSecundario = Color(0xFF64748B)
    val bordeSuave = Color(0xFFD6E3E6)

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

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Escape UAM",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = celesteOscuro
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = nombreEdificio,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = textoPrincipal,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = descripcionEdificio,
                fontSize = 15.sp,
                lineHeight = 22.sp,
                color = textoSecundario,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Progreso: $progresoActual de $totalNiveles niveles",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = celesteOscuro,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            LinearProgressIndicator(
                progress = { progresoActual.toFloat() / totalNiveles.toFloat() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = celesteOscuro,
                trackColor = Color(0xFFDCECEF)
            )

            Spacer(modifier = Modifier.height(26.dp))

            for (i in 0 until totalNiveles) {
                val completado = i < progresoActual
                val disponible = i == progresoActual
                val bloqueado = i > progresoActual

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(22.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (bloqueado) Color(0xFFF1F5F9) else Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = if (bloqueado) 2.dp else 5.dp
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(18.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Card(
                            modifier = Modifier.size(48.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = when {
                                    completado -> Color(0xFFE8F5E9)
                                    disponible -> Color(0xFFE4F5F7)
                                    else -> Color(0xFFE2E8F0)
                                }
                            )
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = when {
                                        completado -> "✓"
                                        disponible -> "▶"
                                        else -> "🔒"
                                    },
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = when {
                                        completado -> Color(0xFF2E7D32)
                                        disponible -> celesteOscuro
                                        else -> Color(0xFF64748B)
                                    }
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Nivel ${i + 1}",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (bloqueado) Color(0xFF64748B) else textoPrincipal
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = when {
                                    completado -> "Completado"
                                    disponible -> "Disponible"
                                    else -> "Bloqueado"
                                },
                                fontSize = 14.sp,
                                color = when {
                                    disponible -> celesteOscuro
                                    completado -> Color(0xFF2E7D32)
                                    else -> textoSecundario
                                }
                            )
                        }

                        if (disponible) {
                            Button(
                                onClick = {
                                    onNivelSeleccionado(i)
                                },
                                shape = RoundedCornerShape(14.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = celeste
                                )
                            ) {
                                Text(
                                    text = "Entrar",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))
            }

            Spacer(modifier = Modifier.height(10.dp))

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
                    text = "Volver a edificios",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = celesteOscuro
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}