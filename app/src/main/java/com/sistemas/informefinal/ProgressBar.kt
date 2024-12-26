package com.sistemas.informefinal

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview
@Composable
fun IndeterminateProgressBar() {
    CircularProgressIndicator(
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview
@Composable
fun DeterminateProgressBar() {
    LinearProgressIndicator(
        // Valor entre 0 y 1, por ejemplo, 50% de progreso
        progress = 0.3f,
        modifier = Modifier.fillMaxWidth(),
        color = Color.Yellow
    )
}

//custom
@Preview
@Composable
fun CustomizedProgressBar() {
    // Proporcionando un valor predeterminado para `progress`
    val progress = 0.5f
    CircularProgressIndicator(
        progress = progress,
        color = Color.Blue, // Cambia el color
        strokeWidth = 5.dp,  // Cambia el grosor de la barra
        modifier = Modifier.width(50.dp)
    )
}

@Preview
@Composable
fun CustomizedLinearProgressBar() {
    // Proporcionando un valor predeterminado para `progress`
    val progress = 0.5f
    LinearProgressIndicator(
        progress = progress,
        color = Color.DarkGray,  // Cambia el color de la barra de progreso
        trackColor = Color.Red, // Cambia el color de fondo (track)
        modifier = Modifier.width(100.dp)
    )
}

@Preview
@Composable
fun ProgressBarWithCoroutine() {
    var progress by remember { mutableStateOf(0f) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            while (progress < 1f) {
                delay(100)  // Espera 100ms
                progress += 0.01f  // Aumenta el progreso
            }
        }
    }

    LinearProgressIndicator(
        progress = progress,
        modifier = Modifier.width(100.dp)
    )
}
