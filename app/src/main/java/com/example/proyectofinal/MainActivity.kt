package com.example.proyectofinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectofinal.ui.screens.PantallaMenu

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val pantallaActual = remember { mutableStateOf("inicio") }

            when (pantallaActual.value) {

                "inicio" -> PantallaInicio(
                    onIrInstrucciones = { pantallaActual.value = "instrucciones" },
                    onIrMenu = { pantallaActual.value = "menu" }
                )

                "instrucciones" -> PantallaInstrucciones(
                    onBack = { pantallaActual.value = "inicio" }
                )

                "menu" -> PantallaMenu(
                    onIrNiveles = { },
                    onBack = { pantallaActual.value = "inicio" }
                )
            }
        }
    }
}

@Composable
fun PantallaInicio(
    onIrInstrucciones: () -> Unit,
    onIrMenu: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1B1B3A),
                        Color(0xFF693668),
                        Color(0xFFA74482)
                    )
                )
            )
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.92f)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {
            Column(
                modifier = Modifier.padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Escape UAM",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1B1B3A),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Explorá edificios, resolvé retos y desbloqueá pistas para avanzar al siguiente nivel.",
                    fontSize = 16.sp,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(28.dp))

                Button(
                    onClick = { onIrMenu() },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text("Comenzar juego")
                }

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedButton(
                    onClick = { onIrInstrucciones() },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text("Ver instrucciones")
                }
            }
        }
    }
}

@Composable
fun PantallaInstrucciones(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Instrucciones",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "En este juego, el usuario recorrerá diferentes habitaciones representadas por edificios de la UAM. Deberá completar retos para avanzar, ganar puntos y desbloquear pistas.",
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { onBack() }) {
            Text("Volver")
        }
    }
}