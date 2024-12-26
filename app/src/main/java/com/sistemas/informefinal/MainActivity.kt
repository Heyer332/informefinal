package com.sistemas.informefinal

import android.os.Bundle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.semantics.Role.Companion.Switch
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppContent()
        }
    }
}

@Composable
fun ButtonsDemo() {
    Column {
        Button(onClick = { /* Acción */ }) {
            Text("Botón Normal")
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(onClick = { /* Acción */ }) {
            Text("Text Button")
        }
    }
}

@Composable
fun ImageDemo() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.imagen), // Imagen desde drawable
            contentDescription = "Imagen Normal",
            modifier = Modifier.size(128.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = painterResource(id = R.drawable.imagen), // Imagen circular
            contentDescription = "Imagen Circular",
            modifier = Modifier
                .size(128.dp)
                .clip(CircleShape)
        )
    }
}
@Composable
fun IconsDemo() {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Icon(Icons.Default.Favorite, contentDescription = "Ícono de Favorito")
        Icon(Icons.Default.Settings, contentDescription = "Ícono de Configuración")
    }
}
@Composable
fun ProgressBarDemo() {
    Column {
        CircularProgressIndicator() // Indeterminado
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(progress = 0.5f) // Determinado (50%)
    }
}

@Composable
fun ToggleDemo() {
    var isChecked by remember { mutableStateOf(false) }
    Column {
        Switch(checked = isChecked, onCheckedChange = { isChecked = it })
        Spacer(modifier = Modifier.height(8.dp))
        Checkbox(checked = isChecked, onCheckedChange = { isChecked = it })
    }
}
@Composable
fun RadioButtonDemo() {
    val options = listOf("Opción 1", "Opción 2", "Opción 3")
    var selectedOption by remember { mutableStateOf(options[0]) }
    Column {
        options.forEach { option ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = (selectedOption == option),
                    onClick = { selectedOption = option }
                )
                Text(option, modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}


@Composable
fun AlertDialogDemo() {
    var showDialog by remember { mutableStateOf(false) }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Título") },
            text = { Text("Este es un diálogo de alerta.") },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            }
        )
    }
    Button(
        onClick = { showDialog = true },
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Mostrar AlertDialog")
    }
}
@Composable
fun AppContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ButtonsDemo()
        ImageDemo()
        IconsDemo()
        ProgressBarDemo()
        ToggleDemo()
        RadioButtonDemo()
        AlertDialogDemo()
    }
}