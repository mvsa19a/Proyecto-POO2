package com.example.proyectofinal.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectofinal.network.JugadorRanking
import com.example.proyectofinal.network.RetrofitClient
import kotlinx.coroutines.launch

@Composable
fun LeaderboardScreen(

    onBack: () -> Unit

) {

    var jugadores by remember {

        mutableStateOf<List<JugadorRanking>>(emptyList())

    }

    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit){

        scope.launch{

            try{

                jugadores = RetrofitClient.api.obtenerRanking()

            }catch(e:Exception){

                e.printStackTrace()

            }

        }

    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)

    ){

        Text(

            text="🏆 Leaderboard",

            fontSize=30.sp,

            fontWeight=FontWeight.Bold

        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn{

            itemsIndexed(jugadores){index,jugador->

                Card(

                    modifier=Modifier
                        .fillMaxWidth()
                        .padding(vertical=6.dp)

                ){

                    Row(

                        modifier=Modifier
                            .fillMaxWidth()
                            .padding(18.dp),

                        verticalAlignment=Alignment.CenterVertically

                    ){

                        Text(

                            text="${index+1}",

                            fontSize=22.sp,

                            fontWeight=FontWeight.Bold,

                            color=Color(0xFF32A0A6)

                        )

                        Spacer(modifier=Modifier.width(20.dp))

                        Column{

                            Text(

                                jugador.nombre,

                                fontWeight=FontWeight.Bold

                            )

                            Text("${jugador.puntos} puntos")

                        }

                    }

                }

            }

        }

        Spacer(modifier=Modifier.height(15.dp))

        Button(

            modifier=Modifier.fillMaxWidth(),

            onClick=onBack

        ){

            Text("Volver")

        }

    }

}