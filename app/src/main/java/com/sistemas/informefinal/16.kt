package com.sistemas.informefinal

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.SliderDefaults.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement

// Slider básico
@Composable
@Preview
fun BasicSlider() {
    var sliderPosition by remember { mutableStateOf(0.5f) }

    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        valueRange = 0f..1f,
        modifier = Modifier.fillMaxWidth(),
        colors = colors(
            thumbColor = Color.Green,
            activeTrackColor = Color.Blue,
            inactiveTrackColor = Color.Gray
        )
    )
}

// Slider con etiqueta
@Composable
@Preview
fun SliderWithLabel() {
    var sliderPosition by remember { mutableStateOf(0f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Value: ${sliderPosition * 100}%", style = MaterialTheme.typography.bodyLarge)
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..1f,
            modifier = Modifier.fillMaxWidth(),
            colors = colors(
                thumbColor = Color.Cyan,
                activeTrackColor = Color.Green,
                inactiveTrackColor = Color.Gray
            )
        )
    }
}


// Slider personalizado con colores
@Composable
@Preview
fun CustomSlider() {
    var sliderPosition by remember { mutableStateOf(0.5f) }

    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        valueRange = 0f..1f,
        modifier = Modifier.fillMaxWidth(),
        colors = colors(
            thumbColor = Color.Red,
            activeTrackColor = Color.Blue,
            inactiveTrackColor = Color.Gray
        )
    )
}

// Slider de volumen con pasos
@Preview
@Composable
fun VolumeSlider() {
    var volume by remember { mutableStateOf(0.5f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Volume", style = MaterialTheme.typography.bodyLarge)
        Slider(
            value = volume,
            onValueChange = { volume = it },
            valueRange = 0f..1f,
            steps = 10,
            modifier = Modifier.fillMaxWidth(),
            colors = colors(
                thumbColor = Color.Yellow,
                activeTrackColor = Color.Cyan,
                inactiveTrackColor = Color.LightGray
            )
        )
    }
}

// Demo general con todos los sliders
@Preview
@Composable
fun SliderDemo() {
    // Estado para los Sliders y RangeSlider
    var sliderPosition by remember { mutableStateOf(0.5f) }
    var rangeSliderValues by remember { mutableStateOf(0f..1f) }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Slider Básico
        Text("Basic Slider", style = MaterialTheme.typography.bodySmall)
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..1f,
            modifier = Modifier.fillMaxWidth(),
            colors = colors(
                thumbColor = Color.Green,
                activeTrackColor = Color.Blue,
                inactiveTrackColor = Color.Gray
            )
        )
        Text("Value: ${sliderPosition * 100}%", style = MaterialTheme.typography.bodyLarge)
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..1f,
            modifier = Modifier.fillMaxWidth(),
            steps = 5,
            colors = colors(
                thumbColor = Color.Red,
                activeTrackColor = Color.Cyan,
                inactiveTrackColor = Color.LightGray
            )
        )
        Text("Slider with Label", style = MaterialTheme.typography.bodyLarge)
        Text("Current Value: ${sliderPosition * 100}%", style = MaterialTheme.typography.bodySmall)
        Text("Range Slider", style = MaterialTheme.typography.bodyLarge)
        Text("Selected Range: ${"%.2f".format(rangeSliderValues.start)} - ${"%.2f".format(rangeSliderValues.endInclusive)}", style = MaterialTheme.typography.bodyLarge)
    }
}
