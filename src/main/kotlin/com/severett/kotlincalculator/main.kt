package com.severett.kotlincalculator

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.severett.kotlincalculator.model.Operation

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Kotlin Calculator",
        state = rememberWindowState(width = 300.dp, height = 350.dp),
        resizable = false,
    ) {
        // val count = remember { mutableStateOf(0) }
        MaterialTheme {
            Column {
                Row(modifier = Modifier.padding(vertical = 5.dp)) {
                    Text(text = "0")
                }
                Row {
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text(Operation.MODULO.symbol)
                    }
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text("CE")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text("C")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text("⌫")
                    }
                }
                Row {
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text("x⁻¹")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text("x²")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text("√")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text(Operation.ADD.symbol)
                    }
                }
                Row {
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text("1")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text("2")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text("3")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text(Operation.SUBTRACT.symbol)
                    }
                }
                Row {
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text("4")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text("5")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text("6")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text(Operation.MULTIPLY.symbol)
                    }
                }
                Row {
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text("7")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text("8")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text("9")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text(Operation.DIVIDE.symbol)
                    }
                }
                Row {
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text("±")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text("0")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text(".")
                    }
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text("=")
                    }
                }
            }
        }
    }
}
