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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaMenu(
    puntos: Int,
    vidas: Int,
    onIrNiveles: () -> Unit,
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
                .padding(horizontal = 26.dp, vertical = 34.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "Escape UAM",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = celesteOscuro
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Menú Principal",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = textoPrincipal,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Continuá tu recorrido por el campus y completá los retos para avanzar.",
                fontSize = 15.sp,
                lineHeight = 22.sp,
                color = textoSecundario,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                MenuInfoCard(
                    titulo = "Puntos",
                    valor = puntos.toString(),
                    emoji = "⭐",
                    modifier = Modifier.weight(1f)
                )

                MenuInfoCard(
                    titulo = "Vidas",
                    valor = vidas.toString(),
                    emoji = "❤️",
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(26.dp))

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
                        .padding(24.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "¿Qué querés hacer?",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold,
                        color = textoPrincipal
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Elegí una opción para seguir jugando, revisar tu avance o regresar al inicio.",
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        color = textoSecundario
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = onIrNiveles,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(58.dp),
                        shape = RoundedCornerShape(18.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = celeste
                        )
                    ) {
                        Text(
                            text = "Ir a niveles",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedButton(
                        onClick = { },
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
                            text = "Ver progreso",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            color = celesteOscuro
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

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
                            text = "Volver al inicio",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            color = textoPrincipal
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Completá los niveles para desbloquear nuevas zonas.",
                fontSize = 13.sp,
                color = textoSecundario,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun MenuInfoCard(
    titulo: String,
    valor: String,
    emoji: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.height(118.dp),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = emoji,
                fontSize = 25.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = valor,
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1F2937)
            )

            Text(
                text = titulo,
                fontSize = 13.sp,
                color = Color(0xFF64748B)
            )
        }
    }
}