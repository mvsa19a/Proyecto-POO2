package com.example.proyectofinal.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectofinal.R

@Composable
fun PantallaInicio(
    onStart: () -> Unit,
    onInstructions: () -> Unit
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

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Universidad Americana",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = celesteOscuro
            )

            Spacer(modifier = Modifier.height(22.dp))

            Image(
                painter = painterResource(id = R.drawable.uam_logo),
                contentDescription = "Logo UAM",
                modifier = Modifier.size(135.dp)
            )

            Spacer(modifier = Modifier.height(26.dp))

            Text(
                text = "Escape UAM",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = textoPrincipal,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Explorá el campus, resolvé retos y descubrí pistas para avanzar de nivel.",
                fontSize = 16.sp,
                lineHeight = 23.sp,
                color = textoSecundario,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(28.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                InfoInicioCard(
                    emoji = "🏫",
                    titulo = "Edificios",
                    modifier = Modifier.weight(1f)
                )

                InfoInicioCard(
                    emoji = "🧩",
                    titulo = "Retos",
                    modifier = Modifier.weight(1f)
                )

                InfoInicioCard(
                    emoji = "🔎",
                    titulo = "Pistas",
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(28.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                )
            ) {
                Column(
                    modifier = Modifier.padding(22.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Tu misión",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = textoPrincipal
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Completá los desafíos de cada zona, ganá puntos y desbloqueá nuevas habitaciones dentro de la UAM.",
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        color = textoSecundario
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onStart,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp),
                shape = RoundedCornerShape(18.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = celeste
                )
            ) {
                Text(
                    text = "Comenzar juego",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedButton(
                onClick = onInstructions,
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
                    text = "Ver instrucciones",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = celesteOscuro
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun InfoInicioCard(
    emoji: String,
    titulo: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.height(82.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = emoji,
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = titulo,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF1F2937),
                textAlign = TextAlign.Center
            )
        }
    }
}