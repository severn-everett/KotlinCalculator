package com.severett.kotlincalculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Kotlin Calculator",
        state = rememberWindowState(width = 400.dp, height = 300.dp)
    ) {
        // val count = remember { mutableStateOf(0) }
        MaterialTheme {
            Row {
                // Buttons 1, 4, and 7
                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Button(modifier = Modifier.align(Alignment.CenterHorizontally), onClick = {}) {
                        Text("1")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterHorizontally), onClick = {}) {
                        Text("4")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterHorizontally), onClick = {}) {
                        Text("7")
                    }
                }
                // Buttons 2, 5, and 8
                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Button(modifier = Modifier.align(Alignment.CenterHorizontally), onClick = {}) {
                        Text("2")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterHorizontally), onClick = {}) {
                        Text("5")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterHorizontally), onClick = {}) {
                        Text("8")
                    }
                }
                // Buttons 3, 6, and 9
                Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                    Button(modifier = Modifier.align(Alignment.CenterHorizontally), onClick = {}) {
                        Text("3")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterHorizontally), onClick = {}) {
                        Text("6")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterHorizontally), onClick = {}) {
                        Text("9")
                    }
                }
            }
        }
    }
}
