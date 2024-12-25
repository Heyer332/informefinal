package com.sistemas.informefinal

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable

fun mySurface(){
    Surface(
        modifier = Modifier.padding(16.dp),
        color = Color.LightGray,
        tonalElevation = 4.dp, // Elevación tonal para efecto visual
        shadowElevation = 8.dp // Sombra para separación visual
    ) {
        Box(modifier = Modifier.padding(16.dp)) {
            Text(text = "Texto adentro de Surface")
        }
    }
}



@Composable
fun SurfaceWithBorderAndShape() {
    Surface(
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(16.dp), // Forma personalizada con bordes redondeados
        border = BorderStroke(2.dp, Color.Blue), // Borde azul
        color = Color.White,
        tonalElevation = 2.dp,
        shadowElevation = 4.dp
    ) {
        Text(
            text = "Surface con borde y forma personalizada",
            modifier = Modifier.padding(16.dp)
        )
    }
}


@Composable
fun ClickableSurfaceExample() {
    val clickedState = remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        color = if (clickedState.value) Color.Green else Color.Red,
        shadowElevation = 4.dp,
        onClick = { clickedState.value = !clickedState.value } // Alterna estado al hacer clic
    ) {
        Text(
            text = if (clickedState.value) "Clickeado" else "Haz clic aquí",
            modifier = Modifier.padding(16.dp)
        )
    }
}
@Preview
@Composable
fun ToggleableSurfaceExample() {
    val isSelected = remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp), // Forma personalizada con bordes redondeados
        border = BorderStroke(2.dp, Color.Blue),
        color = if (isSelected.value) Color.Cyan else Color.Gray,
        onCheckedChange = { isSelected.value = it }, // Cambia el estado al hacer clic
        checked = isSelected.value,
        shadowElevation = 6.dp
    ) {
        Text(
            text = if (isSelected.value) "Activado" else "Desactivado",
            modifier = Modifier.padding(16.dp)
        )
    }
}