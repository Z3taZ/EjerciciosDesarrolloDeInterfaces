package com.example.Clase.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable

//Esta función recibirá un string el cual tendrá de nombre texto que tiene valor por defecto "Texto"
//hay que ponerle valor por defecto porque sino el @Preview no funciona
fun MyText(texto: String = "Texto", modifier: Modifier = Modifier){

    //safeDrawingPadding() hace que el column y sus componentes no se
    //solapen con la barra de arriba del movil la que muestra la hora,etc
    Column(modifier = Modifier.safeDrawingPadding()){

        Text(texto)
        Text(texto, color = Color.Red)
        Text(texto, fontSize = 40.sp)
        Text(texto, fontStyle = FontStyle.Italic)
        Text(texto, fontSize = 40.sp, fontWeight = FontWeight.ExtraBold)
        Text(texto, fontSize = 40.sp, letterSpacing = 10.sp)
        Text(texto, fontSize = 40.sp, textDecoration = TextDecoration.Underline)
        Text(texto, fontSize = 40.sp, textDecoration = TextDecoration.combine(



            listOf(TextDecoration.Underline,
                    TextDecoration.LineThrough))
        )

        Text(texto, fontSize = 40.sp, modifier= Modifier
            .fillMaxWidth()
            .background(Color.Green),
            textAlign = TextAlign.Center)

        Text("\n", fontSize = 40.sp, modifier= Modifier
            .fillMaxWidth()
            .background(Color.Red),
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.StartEllipsis)

    }
}