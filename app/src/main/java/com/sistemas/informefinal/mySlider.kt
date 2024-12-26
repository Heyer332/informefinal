package com.sistemas.informefinal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun mySlider(){
    val sliderValue = remember { mutableStateOf(0.5f) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Valor actual: ${sliderValue.value}")
        Slider(
            value = sliderValue.value,
            onValueChange = { sliderValue.value = it },
            valueRange = 0f..1f, // Rango de valores
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun DiscreteSliderExample() {
    val sliderValue = remember { mutableStateOf(2f) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Valor actual: ${sliderValue.value.toInt()}")
        Slider(
            value = sliderValue.value,
            onValueChange = { sliderValue.value = it },
            valueRange = 0f..5f, // Rango de valores
            steps = 4, // Cantidad de pasos (5 valores totales: 0, 1, 2, 3, 4, 5)
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun RangeSliderExample() {
    val sliderValues = remember { mutableStateOf(
        0.2f..0.8f) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Rango actual: ${sliderValues
                .value.start} a ${sliderValues.value
                    .endInclusive}"
        )
        RangeSlider(
            value = sliderValues.value,
            onValueChange = { sliderValues.value = it },
            valueRange = 0f..1f, // Rango de valores
            modifier = Modifier.fillMaxWidth()
        )
    }
}
