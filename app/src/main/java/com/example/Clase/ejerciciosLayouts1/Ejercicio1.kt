package com.example.Clase.ejerciciosLayouts1

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun Ejercicio1(modifier: Modifier = Modifier) {

    Row(modifier = Modifier
        .safeDrawingPadding()
        .fillMaxSize()
        .border(5.dp,Color.Cyan),
        horizontalArrangement = Arrangement.SpaceEvenly
            ) {

        Box(modifier = Modifier

            .width(100.dp)
            .height(180.dp)
            .background(Color.Magenta),
            contentAlignment = Alignment.Center

        ){

            Text("View",
                color = Color.Black)
        }

        Box(modifier = Modifier
            .width(140.dp)
            .height(220.dp)
            .background(Color.Magenta),
            contentAlignment = Alignment.Center
        ){

            Text("View",
                color = Color.Black)
        }
        Box(modifier = Modifier
            .width(100.dp)
            .height(180.dp)
            .background(Color.Magenta),
            contentAlignment = Alignment.Center
        ){

            Text("View",
                color = Color.Black)
        }

    }


}