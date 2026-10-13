package com.example.Clase.ejerciciosLayouts1

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Ejercicio2 (modifier: Modifier = Modifier){

    Column(modifier = Modifier.border(20.dp, color = Color.Black).padding(20.dp)
        .background(Color.Black)
        .fillMaxSize()
        ) {

        Box(modifier= Modifier
            .background(Color.Blue).weight(1f).fillMaxSize().padding(10.dp),
            contentAlignment = Alignment.TopStart
        ){
            Text("Indigo", color = Color.White, fontSize = 24.sp)
        }
        Box(modifier= Modifier
            .background(Color.Magenta).weight(1f).fillMaxSize().padding(10.dp),
            contentAlignment = Alignment.TopStart

        ){
            Text("Pink", color = Color.White, fontSize = 24.sp)

        }
        Box(modifier= Modifier
            .background(Color.Yellow).weight(1f).fillMaxSize().padding(10.dp),
            contentAlignment = Alignment.TopStart

        ){
            Text("Yellow", color = Color.White, fontSize = 24.sp)

        }
        Box(modifier= Modifier
            .background(Color.Green).weight(1f).fillMaxSize().padding(10.dp),
                contentAlignment = Alignment.TopStart

        ){
            Text("Green", color = Color.White, fontSize = 24.sp)

        }

    }
}