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

@Composable
fun PantallaNiveles(
    bibliotecaDesbloqueada: Boolean,
    edificioBDesbloqueado: Boolean,
    onNivelSeleccionado: (String) -> Unit,
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
                text = "Habitaciones",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = textoPrincipal,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Seleccioná una zona del campus. Completá retos para desbloquear nuevas habitaciones.",
                fontSize = 15.sp,
                lineHeight = 22.sp,
                color = textoSecundario,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(30.dp))

            NivelDisponibleCard(
                emoji = "🏢",
                titulo = "Edificio A",
                descripcion = "Reto inicial para comenzar tu recorrido por el campus.",
                etiqueta = "Disponible",
                boton = "Entrar al Edificio A",
                colorPrincipal = celeste,
                onClick = { onNivelSeleccionado("edificioA") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (bibliotecaDesbloqueada) {
                NivelDisponibleCard(
                    emoji = "📚",
                    titulo = "Biblioteca Central",
                    descripcion = "Reto avanzado con preguntas generadas por IA local.",
                    etiqueta = "Desbloqueado",
                    boton = "Entrar a Biblioteca",
                    colorPrincipal = celeste,
                    onClick = { onNivelSeleccionado("biblioteca") }
                )
            } else {
                NivelBloqueadoCard(
                    emoji = "🔒",
                    titulo = "Biblioteca Central",
                    descripcion = "Completá el reto del Edificio A para desbloquear esta zona."
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (edificioBDesbloqueado) {
                NivelDisponibleCard(
                    emoji = "🏛️",
                    titulo = "Edificio B",
                    descripcion = "Zona desbloqueada después de completar la Biblioteca Central.",
                    etiqueta = "Desbloqueado",
                    boton = "Entrar al Edificio B",
                    colorPrincipal = celeste,
                    onClick = { onNivelSeleccionado("edificioB") }
                )
            } else {
                NivelBloqueadoCard(
                    emoji = "🔒",
                    titulo = "Edificio B",
                    descripcion = "Completá el reto de la Biblioteca para desbloquear esta zona."
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

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
                    text = "Volver al menú",
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
fun NivelDisponibleCard(
    emoji: String,
    titulo: String,
    descripcion: String,
    etiqueta: String,
    boton: String,
    colorPrincipal: Color,
    onClick: () -> Unit
) {
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
                .padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier.size(54.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFE4F5F7)
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = emoji,
                            fontSize = 27.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column {
                    Text(
                        text = titulo,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1F2937)
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = etiqueta,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = colorPrincipal
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = descripcion,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                color = Color(0xFF64748B)
            )

            Spacer(modifier = Modifier.height(18.dp))

            Button(
                onClick = onClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorPrincipal
                )
            ) {
                Text(
                    text = boton,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun NivelBloqueadoCard(
    emoji: String,
    titulo: String,
    descripcion: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(26.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF1F5F9)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.size(54.dp),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE2E8F0)
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = emoji,
                        fontSize = 26.sp
                    )
                }
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column {
                Text(
                    text = titulo,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF475569)
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = descripcion,
                    fontSize = 13.sp,
                    lineHeight = 19.sp,
                    color = Color(0xFF64748B)
                )
            }
        }
    }
}