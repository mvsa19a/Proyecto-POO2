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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.random.Random

data class PosicionJuego(
    val fila: Int,
    val columna: Int
)

fun moverPersonajeAutomatico(posicionActual: PosicionJuego): PosicionJuego {
    val movimientos = listOf(
        PosicionJuego(posicionActual.fila - 1, posicionActual.columna),
        PosicionJuego(posicionActual.fila + 1, posicionActual.columna),
        PosicionJuego(posicionActual.fila, posicionActual.columna - 1),
        PosicionJuego(posicionActual.fila, posicionActual.columna + 1)
    ).filter { nuevaPosicion ->
        nuevaPosicion.fila in 0..3 && nuevaPosicion.columna in 0..3
    }

    return movimientos.random()
}

@Composable
fun PantallaExploracion(
    onPistaEncontrada: () -> Unit,
    onBack: () -> Unit
) {
    val celeste = Color(0xFF32A0A6)
    val celesteOscuro = Color(0xFF187C84)
    val fondoClaro = Color(0xFFF3FBFC)
    val textoPrincipal = Color(0xFF1F2937)
    val textoSecundario = Color(0xFF64748B)
    val bordeSuave = Color(0xFFD6E3E6)
    val verdeCorrecto = Color(0xFF2E7D32)

    var personaje by remember { mutableStateOf(PosicionJuego(0, 0)) }
    var lupa by remember { mutableStateOf(PosicionJuego(3, 3)) }
    var encontrada by remember { mutableStateOf(false) }
    var movimientos by remember { mutableStateOf(0) }

    LaunchedEffect(encontrada) {
        while (!encontrada) {
            delay(650)
            personaje = moverPersonajeAutomatico(personaje)
        }
    }

    LaunchedEffect(personaje, lupa) {
        if (!encontrada && personaje.fila == lupa.fila && personaje.columna == lupa.columna) {
            encontrada = true
            delay(900)
            onPistaEncontrada()
        }
    }

    fun moverLupa(nuevaFila: Int, nuevaColumna: Int) {
        if (encontrada) return

        val filaValida = nuevaFila in 0..3
        val columnaValida = nuevaColumna in 0..3

        if (filaValida && columnaValida) {
            lupa = PosicionJuego(nuevaFila, nuevaColumna)
            movimientos++
        }
    }

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
                .padding(horizontal = 24.dp, vertical = 26.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Mini juego de persecución",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = celesteOscuro
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Edificio A",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = textoPrincipal,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "El personaje se mueve solo. Controlá la lupa y alcanzalo para descubrir la pista.",
                fontSize = 14.sp,
                lineHeight = 20.sp,
                color = textoSecundario,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(18.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ExploracionInfoCard(
                    titulo = "Movimientos",
                    valor = movimientos.toString(),
                    modifier = Modifier.weight(1f)
                )

                ExploracionInfoCard(
                    titulo = "Estado",
                    valor = if (encontrada) "Alcanzado" else "Persiguiendo",
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

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
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Mapa del edificio",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = textoPrincipal
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Usá la lupa para alcanzar al personaje.",
                        fontSize = 13.sp,
                        color = textoSecundario,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    Column(
                        verticalArrangement = Arrangement.spacedBy(9.dp)
                    ) {
                        for (fila in 0..3) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(9.dp)
                            ) {
                                for (columna in 0..3) {
                                    val esPersonaje = personaje.fila == fila && personaje.columna == columna
                                    val esLupa = lupa.fila == fila && lupa.columna == columna

                                    CasillaMapa(
                                        contenido = when {
                                            esPersonaje && esLupa -> "✅"
                                            esPersonaje -> "🧍"
                                            esLupa -> "🔎"
                                            else -> ""
                                        },
                                        activa = esPersonaje || esLupa
                                    )
                                }
                            }
                        }
                    }

                    if (encontrada) {
                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "¡Lo alcanzaste! Pista encontrada...",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = verdeCorrecto,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            ControlMovimientoRapido(
                celeste = celeste,
                onArriba = {
                    moverLupa(lupa.fila - 1, lupa.columna)
                },
                onAbajo = {
                    moverLupa(lupa.fila + 1, lupa.columna)
                },
                onIzquierda = {
                    moverLupa(lupa.fila, lupa.columna - 1)
                },
                onDerecha = {
                    moverLupa(lupa.fila, lupa.columna + 1)
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(
                onClick = onBack,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(18.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = bordeSuave
                )
            ) {
                Text(
                    text = "Volver a niveles",
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
fun ExploracionInfoCard(
    titulo: String,
    valor: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.height(82.dp),
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
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = valor,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1F2937)
            )

            Spacer(modifier = Modifier.height(3.dp))

            Text(
                text = titulo,
                fontSize = 12.sp,
                color = Color(0xFF64748B),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun CasillaMapa(
    contenido: String,
    activa: Boolean
) {
    Card(
        modifier = Modifier.size(46.dp),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (activa) Color(0xFFE4F5F7) else Color(0xFFF1F5F9)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (activa) 4.dp else 1.dp
        ),
        border = BorderStroke(
            width = 1.dp,
            color = if (activa) Color(0xFF32A0A6) else Color(0xFFE2E8F0)
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = contenido,
                fontSize = 22.sp
            )
        }
    }
}

@Composable
fun ControlMovimientoRapido(
    celeste: Color,
    onArriba: () -> Unit,
    onAbajo: () -> Unit,
    onIzquierda: () -> Unit,
    onDerecha: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Controlá la lupa",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1F2937)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                BotonMovimiento(
                    texto = "←",
                    celeste = celeste,
                    modifier = Modifier.weight(1f),
                    onClick = onIzquierda
                )

                BotonMovimiento(
                    texto = "↑",
                    celeste = celeste,
                    modifier = Modifier.weight(1f),
                    onClick = onArriba
                )

                BotonMovimiento(
                    texto = "↓",
                    celeste = celeste,
                    modifier = Modifier.weight(1f),
                    onClick = onAbajo
                )

                BotonMovimiento(
                    texto = "→",
                    celeste = celeste,
                    modifier = Modifier.weight(1f),
                    onClick = onDerecha
                )
            }
        }
    }
}

@Composable
fun BotonMovimiento(
    texto: String,
    celeste: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(46.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = celeste
        )
    ) {
        Text(
            text = texto,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}