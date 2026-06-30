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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProgresoScreen(

    puntos:Int,

    vidas:Int,

    edificiosDesbloqueados:Int,

    progresoPorEdificio: Map<String,Int>,

    onBack:()->Unit

){

    val totalEdificios=8
    val nivelesPorEdificio=10

    val nivelesCompletados=progresoPorEdificio.values.sum()

    val totalNiveles=totalEdificios*nivelesPorEdificio

    val porcentaje=((nivelesCompletados.toFloat()/totalNiveles.toFloat())*100)

    Box(

        modifier=Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color.White,
                        Color(0xFFF3FBFC),
                        Color(0xFFE4F5F7)
                    )
                )
            )

    ){

        Column(

            modifier=Modifier
                .fillMaxSize()
                .padding(24.dp),

            horizontalAlignment=Alignment.CenterHorizontally

        ){

            Text(

                text="Mi progreso",

                fontSize=32.sp,

                fontWeight=FontWeight.Bold

            )

            Spacer(modifier=Modifier.height(30.dp))

            Card(
                modifier=Modifier.fillMaxWidth(),
                shape=RoundedCornerShape(20.dp)
            ){

                Column(
                    modifier=Modifier.padding(20.dp)
                ){

                    Text("⭐ Puntos: $puntos")

                    Spacer(modifier=Modifier.height(10.dp))

                    Text("❤️ Vidas: $vidas")

                    Spacer(modifier=Modifier.height(10.dp))

                    Text("🏫 Edificios desbloqueados: $edificiosDesbloqueados / $totalEdificios")

                    Spacer(modifier=Modifier.height(10.dp))

                    Text("🎮 Niveles completados: $nivelesCompletados / $totalNiveles")

                    Spacer(modifier=Modifier.height(18.dp))

                    LinearProgressIndicator(

                        progress = porcentaje/100f,

                        modifier=Modifier
                            .fillMaxWidth()
                            .height(10.dp)

                    )

                    Spacer(modifier=Modifier.height(8.dp))

                    Text(

                        text="${porcentaje.toInt()}% completado",

                        fontWeight=FontWeight.Bold

                    )

                }

            }

            Spacer(modifier=Modifier.height(25.dp))

            Text(

                text="Avance por edificio",

                fontWeight=FontWeight.Bold,

                fontSize=20.sp

            )

            Spacer(modifier=Modifier.height(15.dp))

            progresoPorEdificio.forEach{(edificio,nivel)->

                Card(

                    modifier=Modifier
                        .fillMaxWidth()
                        .padding(vertical=5.dp)

                ){

                    Row(

                        modifier=Modifier
                            .fillMaxWidth()
                            .padding(16.dp),

                        horizontalArrangement=Arrangement.SpaceBetween

                    ){

                        Text(edificio)

                        Text("$nivel / 10")

                    }

                }

            }

            Spacer(modifier=Modifier.weight(1f))

            Button(

                modifier=Modifier.fillMaxWidth(),

                onClick=onBack

            ){

                Text("Volver")

            }

        }

    }

}