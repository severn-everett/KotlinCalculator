package com.severett.kotlincalculator.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.type
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.rememberWindowState
import com.severett.kotlincalculator.model.Calculator
import com.severett.kotlincalculator.model.Operand

@Composable
fun calculatorComponent(scope: ApplicationScope) {
    Window(
        onCloseRequest = scope::exitApplication,
        title = "Kotlin Calculator",
        state = rememberWindowState(width = 310.dp, height = 340.dp),
        resizable = false,
        onKeyEvent = { keyEvent ->
            println("TEST: ${keyEvent.key.keyCode} | ${keyEvent.type}")
            true
        }
    ) {
        val currentDisplay = remember { mutableStateOf("") }
        val calculator = remember { Calculator(currentDisplay) }
        val buttonRowModifier = remember { Modifier.height(40.dp) }
        val buttonModifier = remember { Modifier.padding(horizontal = 4.5.dp) }
        MaterialTheme {
            Column {
                Row(
                    modifier = Modifier.padding(vertical = 5.dp, horizontal = 5.dp)
                        .border(1.5.dp, MaterialTheme.colors.secondary, RoundedCornerShape(5.dp))
                ) {
                    TextField(
                        value = currentDisplay.value,
                        modifier = Modifier.fillMaxWidth().height(50.dp),
                        onValueChange = {},
                        readOnly = true
                    )
                }
                Row(modifier = buttonRowModifier) {
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.setPercentage() }
                    ) {
                        Text("%")
                    }
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.clearEntry() }
                    ) {
                        Text("CE")
                    }
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.clear() }
                    ) {
                        Text("C")
                    }
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.backspace() }
                    ) {
                        Text("⌫")
                    }
                }
                Row(modifier = buttonRowModifier) {
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.setExponentOperation(-1.0) }
                    ) {
                        Text("x⁻¹")
                    }
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.setExponentOperation(2.0) }
                    ) {
                        Text("x²")
                    }
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.setExponentOperation(0.5) }
                    ) {
                        Text("√")
                    }
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.updateOperand(Operand.ADD) }
                    ) {
                        Text(Operand.ADD.symbol)
                    }
                }
                Row(modifier = buttonRowModifier) {
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.updateArgument(1) }
                    ) {
                        Text("1")
                    }
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.updateArgument(2) }
                    ) {
                        Text("2")
                    }
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.updateArgument(3) }
                    ) {
                        Text("3")
                    }
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.updateOperand(Operand.SUBTRACT) }
                    ) {
                        Text(Operand.SUBTRACT.symbol)
                    }
                }
                Row(modifier = buttonRowModifier) {
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.updateArgument(4) }
                    ) {
                        Text("4")
                    }
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.updateArgument(5) }
                    ) {
                        Text("5")
                    }
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.updateArgument(6) }
                    ) {
                        Text("6")
                    }
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.updateOperand(Operand.MULTIPLY) }
                    ) {
                        Text(Operand.MULTIPLY.symbol)
                    }
                }
                Row(modifier = buttonRowModifier) {
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.updateArgument(7) }
                    ) {
                        Text("7")
                    }
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.updateArgument(8) }
                    ) {
                        Text("8")
                    }
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.updateArgument(9) }
                    ) {
                        Text("9")
                    }
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.updateOperand(Operand.DIVIDE) }
                    ) {
                        Text(Operand.DIVIDE.symbol)
                    }
                }
                Row(modifier = buttonRowModifier) {
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.flipPositive() }
                    ) {
                        Text("±")
                    }
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.updateArgument(0) }
                    ) {
                        Text("0")
                    }
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.setDecimal() }
                    ) {
                        Text(".")
                    }
                    Button(
                        modifier = buttonModifier,
                        onClick = { calculator.finalizeOperation() }
                    ) {
                        Text("=")
                    }
                }
            }
        }
    }
}
