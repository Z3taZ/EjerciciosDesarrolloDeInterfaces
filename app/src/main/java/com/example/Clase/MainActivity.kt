package com.example.Clase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.Clase.Calculadora.Calculadora
import com.example.Clase.componentes.CalculadoraEjemplo
import com.example.Clase.ui.theme.Ejemplo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

//Dentro de esta función indicaremos lo que queremos que se vea por pantalla
//indicandole el archivo .kt que queremos que se vea
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    //MyColumn se refiere al archivo MyColumn.kt dentro del package componentes
    //MyColumn(modifier)
    //MyText("Textos...",modifier)
    //MyButton(modifier)
    //MyTextField(modifier)
    //CalculadoraEjemplo(modifier)
    Calculadora(modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ejemplo1Theme {
        Greeting("Android")
    }
}