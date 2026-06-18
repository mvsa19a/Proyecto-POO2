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
fun PantallaInstrucciones(
    onComenzar: () -> Unit,
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

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Escape UAM",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = celesteOscuro
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Instrucciones",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = textoPrincipal,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Antes de comenzar, conocé cómo avanzar dentro del juego.",
                fontSize = 15.sp,
                lineHeight = 22.sp,
                color = textoSecundario,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(30.dp))

            InstruccionCard(
                numero = "1",
                titulo = "Elegí una zona",
                descripcion = "Seleccioná un edificio o habitación disponible para iniciar el reto."
            )

            Spacer(modifier = Modifier.height(14.dp))

            InstruccionCard(
                numero = "2",
                titulo = "Explorá el campus",
                descripcion = "Leé las pistas, revisá los detalles y prestá atención a la información de cada nivel."
            )

            Spacer(modifier = Modifier.height(14.dp))

            InstruccionCard(
                numero = "3",
                titulo = "Resolvé el reto",
                descripcion = "Respondé correctamente para ganar puntos y avanzar a nuevas zonas."
            )

            Spacer(modifier = Modifier.height(14.dp))

            InstruccionCard(
                numero = "4",
                titulo = "Cuidá tus vidas",
                descripcion = "Si fallás, perdés una vida. Intentá completar los retos antes de quedarte sin vidas."
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onComenzar,
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
                    color = celesteOscuro
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun InstruccionCard(
    numero: String,
    titulo: String,
    descripcion: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.size(42.dp),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE4F5F7)
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = numero,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF187C84)
                    )
                }
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column {
                Text(
                    text = titulo,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1F2937)
                )

                Spacer(modifier = Modifier.height(4.dp))

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