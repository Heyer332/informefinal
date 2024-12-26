package com.sistemas.informefinal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Componente básico de DropdownMenu
@Composable
fun SimpleDropdownMenu() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Opción 1") }

    Box(modifier = Modifier.padding(16.dp)) {
        TextButton(
            onClick = { expanded = !expanded },
            modifier = Modifier.background(Color(0xFFE1F5FE),
                RoundedCornerShape(8.dp)).padding(8.dp)
        ) {
            Text(text = "Selecciona una opción: $selectedOption",
                color = Color(0xFF0277BD))
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(Color(0xFFB3E5FC),
                RoundedCornerShape(8.dp))
        ) {
            DropdownMenuItem(
                onClick = {
                    selectedOption = "Opción 1"
                    expanded = false
                },
                text = {
                    Text("Opción 1", color = Color.Black)
                }
            )
            DropdownMenuItem(
                onClick = {
                    selectedOption = "Opción 2"
                    expanded = false
                },
                text = {
                    Text("Opción 2", color = Color.Black)
                }
            )
            DropdownMenuItem(
                onClick = {
                    selectedOption = "Opción 3"
                    expanded = false
                },
                text = {
                    Text("Opción 3", color = Color.Black)
                }
            )
        }
    }
}

// Componente de DropdownMenu con fondo personalizado
@Composable
fun CustomizedDropdownMenu() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Opción A") }

    Box(modifier = Modifier.padding(16.dp)) {
        TextButton(
            onClick = { expanded = !expanded },
            modifier = Modifier.background(Color(0xFF81D4FA), RoundedCornerShape(8.dp)).padding(8.dp)
        ) {
            Text(text = "Selecciona una opción: $selectedOption", color = Color(0xFF01579B))
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(Color(0xFF80DEEA), RoundedCornerShape(8.dp))
        ) {
            DropdownMenuItem(
                onClick = {
                    selectedOption = "Opción A"
                    expanded = false
                },
                text = {
                    Text("Opción A", color = Color.Black)
                }
            )
            DropdownMenuItem(
                onClick = {
                    selectedOption = "Opción B"
                    expanded = false
                },
                text = {
                    Text("Opción B", color = Color.Black)
                }
            )
            DropdownMenuItem(
                onClick = {
                    selectedOption = "Opción C"
                    expanded = false
                },
                text = {
                    Text("Opción C", color = Color.Black)
                }
            )
        }
    }
}

// Componente de DropdownMenu con iconos
@Composable
fun DropdownMenuWithIcons() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Editar") }

    Box(modifier = Modifier.padding(16.dp)) {
        TextButton(
            onClick = { expanded = !expanded },
            modifier = Modifier.background(Color(0xFFFFF59D), RoundedCornerShape(8.dp)).padding(8.dp)
        ) {
            Text(text = "Selecciona una acción: $selectedOption", color = Color(0xFF827717))
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(Color(0xFFFFEB3B), RoundedCornerShape(8.dp))
        ) {
            DropdownMenuItem(
                onClick = {
                    selectedOption = "Editar"
                    expanded = false
                },
                text = {
                    Icon(Icons.Filled.Edit, contentDescription = "Editar", tint = Color(0xFF827717))
                    Spacer(modifier = Modifier.width(12.dp))
                    Text("Editar", color = Color.Black)
                }
            )
            DropdownMenuItem(
                onClick = {
                    selectedOption = "Eliminar"
                    expanded = false
                },
                text = {
                    Icon(Icons.Filled.Delete, contentDescription = "Eliminar", tint = Color(0xFF827717))
                    Spacer(modifier = Modifier.width(12.dp))
                    Text("Eliminar", color = Color.Black)
                }
            )
        }
    }
}

// Componente con lista que tiene un DropdownMenu
@Composable
fun ListWithDropdownMenus() {
    val items = listOf("Elemento 1", "Elemento 2", "Elemento 3")
    var expandedIndex by remember { mutableStateOf<Int?>(null) }
    var selectedOption by remember { mutableStateOf("Ninguna") }

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(items.size) { index ->
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = items[index], style = MaterialTheme.typography.bodyLarge)
                TextButton(
                    onClick = {
                        expandedIndex = if (expandedIndex == index) null else index
                    },
                    modifier = Modifier.background(Color(0xFFB2DFDB), RoundedCornerShape(8.dp)).padding(8.dp)
                ) {
                    Text("Mostrar opciones", color = Color(0xFF004D40))
                }
                if (expandedIndex == index) {
                    DropdownMenu(
                        expanded = true,
                        onDismissRequest = { expandedIndex = null },
                        modifier = Modifier.background(Color(0xFFB2DFDB), RoundedCornerShape(8.dp))
                    ) {
                        DropdownMenuItem(
                            onClick = {
                                selectedOption = "Opción A"
                                expandedIndex = null
                            },
                            text = {
                                Text("Opción A", color = Color.Black)
                            }
                        )
                        DropdownMenuItem(
                            onClick = {
                                selectedOption = "Opción B"
                                expandedIndex = null
                            },
                            text = {
                                Text("Opción B", color = Color.Black)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewDropdownMenus() {
    Column {
        SimpleDropdownMenu()
        CustomizedDropdownMenu()
        DropdownMenuWithIcons()
        ListWithDropdownMenus()
    }
}
