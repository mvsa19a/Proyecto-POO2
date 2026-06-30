package com.example.proyectofinal.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.proyectofinal.network.JugadorRanking
import com.example.proyectofinal.network.RetrofitClient

@Composable
fun LeaderboardScreen(
    onBack: () -> Unit
) {
    var ranking by remember { mutableStateOf<List<JugadorRanking>>(emptyList()) }
    var cargando by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        try {
            ranking = RetrofitClient.api.obtenerRanking()
            cargando = false
        } catch (e: Exception) {
            e.printStackTrace()
            error = "No se pudo cargar el ranking"
            cargando = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "🏆 Leaderboard",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }

        Spacer(modifier = Modifier.height(24.dp))

        when {
            cargando -> {
                Text("Cargando ranking...")
            }

            error.isNotEmpty() -> {
                Text(error)
            }

            ranking.isEmpty() -> {
                Text("No hay jugadores en el ranking.")
            }

            else -> {
                LazyColumn {
                    itemsIndexed(ranking) { index, jugador ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 6.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "${index + 1}. ${jugador.nombre}"
                                )

                                Text(
                                    text = "${jugador.puntos} pts"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}