package com.sistemas.informefinalimport

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SectionSlider() {
    var sliderValue by remember { mutableStateOf(0f) }
    val sections = 5 // Número de secciones
    val step = 1f / sections // Valor por sección
    val steps = sections - 1

    Column(modifier = Modifier.padding(16.dp)) {

        Text(text = "Selecciona una sección: ${sliderValue.toInt()}")

        Slider(
            value = sliderValue,
            onValueChange = { newValue ->
                // Ajuste para que el valor del slider se quede dentro de las secciones
                sliderValue = (newValue / step).toInt() * step
            },
            valueRange = 0f..1f, // Rango de 0 a 1
            steps = steps, // Número de pasos entre secciones
            onValueChangeFinished = {
                println("Valor final del slider: ${sliderValue.toInt()}")
            },
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            for (i in 0 until sections) {
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .height(4.dp)
                        .background(
                            if (sliderValue / step >= i) Color.Blue else Color.Gray
                        )
                )
            }
        }

        Text(text = "Valor actual: ${sliderValue.toInt()}", modifier = Modifier.
            padding(top = 16.dp))
    }
}

@Preview
@Composable
fun PreviewSectionSlider() {
    SectionSlider()
}
