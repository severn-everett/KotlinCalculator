package com.severett.kotlincalculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.severett.kotlincalculator.model.Calculator
import com.severett.kotlincalculator.model.Operand

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Kotlin Calculator",
        state = rememberWindowState(width = 300.dp, height = 350.dp),
        resizable = false,
    ) {
        val currentDisplay = remember { mutableStateOf("") }
        val calculator = remember { Calculator(currentDisplay) }
        MaterialTheme {
            Column {
                Row(modifier = Modifier.padding(vertical = 5.dp)) {
                    Text(text = currentDisplay.value)
                }
                Row {
                    Button(modifier = Modifier.align(Alignment.CenterVertically), onClick = {}) {
                        Text("%")
                    }
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.clearEntry() }
                    ) {
                        Text("CE")
                    }
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.clear() }
                    ) {
                        Text("C")
                    }
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.backspace() }
                    ) {
                        Text("⌫")
                    }
                }
                Row {
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.setExponentOperation(-1.0) }
                    ) {
                        Text("x⁻¹")
                    }
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.setExponentOperation(2.0) }
                    ) {
                        Text("x²")
                    }
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.setExponentOperation(0.5) }
                    ) {
                        Text("√")
                    }
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.updateOperand(Operand.ADD) }
                    ) {
                        Text(Operand.ADD.symbol)
                    }
                }
                Row {
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.updateArgument(1) }
                    ) {
                        Text("1")
                    }
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.updateArgument(2) }
                    ) {
                        Text("2")
                    }
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.updateArgument(3) }
                    ) {
                        Text("3")
                    }
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.updateOperand(Operand.SUBTRACT) }
                    ) {
                        Text(Operand.SUBTRACT.symbol)
                    }
                }
                Row {
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.updateArgument(4) }
                    ) {
                        Text("4")
                    }
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.updateArgument(5) }
                    ) {
                        Text("5")
                    }
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.updateArgument(6) }
                    ) {
                        Text("6")
                    }
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.updateOperand(Operand.MULTIPLY) }
                    ) {
                        Text(Operand.MULTIPLY.symbol)
                    }
                }
                Row {
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.updateArgument(7) }
                    ) {
                        Text("7")
                    }
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.updateArgument(8) }
                    ) {
                        Text("8")
                    }
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.updateArgument(9) }
                    ) {
                        Text("9")
                    }
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.updateOperand(Operand.DIVIDE) }
                    ) {
                        Text(Operand.DIVIDE.symbol)
                    }
                }
                Row {
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.flipPositive() }
                    ) {
                        Text("±")
                    }
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.updateArgument(0) }
                    ) {
                        Text("0")
                    }
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.setDecimal() }
                    ) {
                        Text(".")
                    }
                    Button(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = { calculator.setOperation() }
                    ) {
                        Text("=")
                    }
                }
            }
        }
    }
}
