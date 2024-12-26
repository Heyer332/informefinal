package com.sistemas.informefinal



import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown

import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun SwitchWithCustomColorsPreview() {
    val isChecked = remember { mutableStateOf(false) }

    Switch(
        // Actualizamos el estado con `.value`
        checked = isChecked.value, // Accedemos al estado con `.value`
        // Actualizamos el estado con `.value`
        onCheckedChange = { isChecked.value = it },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.LightGray,
            uncheckedThumbColor = Color.Red,
            uncheckedTrackColor = Color.Gray
        )
    )
}
@Preview
@Composable
fun SwitchWithThumbContent() {
    val isChecked = remember { mutableStateOf(false) }

    Switch(
        checked = isChecked.value,
        onCheckedChange = { isChecked.value = it },
        thumbContent = {
            Icon(
                imageVector = if (isChecked.value) Icons.Default.Check else Icons.Default.Close,
                contentDescription = null,
                tint = Color.White,
            )
        }
    )
}
@Preview
@Composable
fun DisabledSwitch() {
    val isChecked = remember { mutableStateOf(true) }

    Switch(
        checked = isChecked.value,
        onCheckedChange = null, // Sin callback, lo hace no interactivo
        enabled = false
    )
}
@Preview
@Composable
fun FullyCustomSwitch() {
    val isChecked = remember { mutableStateOf(false) }

    Switch(
        checked = isChecked.value,
        onCheckedChange = { isChecked.value = it },

        thumbContent = {
            Icon(
                imageVector = if (isChecked.value) Icons.Default
                    .ThumbUp else Icons.Default
                        .KeyboardArrowDown,
                contentDescription = null,
                tint = Color.White,

            )
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Blue,
            uncheckedThumbColor = Color.Red,
            checkedTrackColor = Color.Cyan,
            uncheckedTrackColor = Color.Gray
        )
    )
}
