package com.sistemas.informefinal


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.lang.reflect.Modifier


@Composable
fun BasicRadioButtonPreview() {
    val isSelected = remember { mutableStateOf(false) }

    RadioButton(
        selected = isSelected.value,
        onClick = { isSelected.value = !isSelected.value }
    )
}


@Composable
fun RadioButtonWithCustomColors() {
    val isSelected = remember { mutableStateOf(false) }

    RadioButton(
        selected = isSelected.value,
        onClick = { isSelected.value = !isSelected.value },
        colors = RadioButtonDefaults.colors(
            selectedColor = Color.Green,
            unselectedColor = Color.Red,
            disabledSelectedColor = Color.LightGray,
            disabledUnselectedColor = Color.Gray
        )
    )
}

@Composable
fun RadioGroupPreview() {
    val options = listOf("Option 1", "Option 2", "Option 3")
    val selectedOption = remember { mutableStateOf(options[0]) }

    Column {
        options.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                RadioButton(
                    selected = (option == selectedOption.value),
                    onClick = { selectedOption.value = option }
                )
                Text(
                    text = option,
                )
            }
        }
    }
}

@Composable
fun DisabledRadioButton() {
    RadioButton(
        selected = true,
        onClick = null, // Deshabilitado
        enabled = false
    )
}

@Preview
@Composable
fun FullyCustomRadioButton() {
    val isSelected = remember { mutableStateOf(false) }

    RadioButton(
        selected = isSelected.value,
        onClick = { isSelected.value = !isSelected.value },
        colors = RadioButtonDefaults.colors(
            selectedColor = Color.Blue,
            unselectedColor = Color.Gray,
            disabledSelectedColor = Color.DarkGray,
            disabledUnselectedColor = Color.LightGray
        ),
        enabled = true
    )
}

