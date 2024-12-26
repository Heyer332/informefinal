package com.sistemas.informefinal

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

// Componente básico de CheckBox
@Preview
@Composable
fun BasicCheckBox() {
    var checked by remember { mutableStateOf(false) }

    Checkbox(
        checked = checked,
        onCheckedChange = { checked = it }
    )
}

// Componente con CheckBox personalizado
@Preview
@Composable
fun CustomizedCheckBox() {
    var checked by remember { mutableStateOf(false) }

    Checkbox(
        checked = checked,
        onCheckedChange = { checked = it },
        colors = CheckboxDefaults.colors(
            // Color cuando está seleccionado
            checkedColor = Color.Green,
            // Color cuando está deseleccionado
            uncheckedColor = Color.Red,
            // Color de la marca de verificación
            checkmarkColor = Color.White
        ),
        modifier = Modifier
    )
}

// Lista de CheckBoxes con opciones
@Preview
@Composable
fun CheckBoxList() {
    val options = listOf("Opción 1", "Opción 2", "Opción 3")
    val selectedOptions = remember { mutableStateOf(setOf<String>()) }

    Column {
        options.forEach { option ->
            val isChecked = option in selectedOptions.value
            Checkbox(
                checked = isChecked,
                onCheckedChange = {
                    selectedOptions.value = if (it) {
                        selectedOptions.value + option
                    } else {
                        selectedOptions.value - option
                    }
                }
            )
            Text(text = option)
        }
    }
}

// CheckBox con texto asociado
@Preview
@Composable
fun CheckBoxWithText() {
    var checked by remember { mutableStateOf(false) }

    Row {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )
        Text("Aceptar términos y condiciones")
    }
}

// CheckBox condicionado (habilitar/deshabilitar)
@Preview
@Composable
fun ConditionalCheckBox() {
    var checked by remember { mutableStateOf(false) }
    var enableCheckBox by remember { mutableStateOf(true) }

    Column {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it },
            enabled = enableCheckBox
        )
        Text("Desactivar CheckBox si está desmarcado")
        Checkbox(
            checked = enableCheckBox,
            onCheckedChange = { enableCheckBox = it }
        )
    }
}
