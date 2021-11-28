package com.severett.kotlincalculator.model

import androidx.compose.runtime.MutableState

class Calculator(private var currentDisplay: MutableState<String>) {
    private var operation: Operation? = null
    private var firstArgument = Argument()
    private var operand: Operand? = null
    private var secondArgument = Argument()

    fun updateOperand(operand: Operand?) {
        this.operand = operand
        updateCurrentDisplay()
    }

    fun updateArgument(addition: String) {
        if (operand == null) {
            firstArgument.update(addition)
        } else {
            secondArgument.update(addition)
        }
        updateCurrentDisplay()
    }

    fun setOperation() {
        when (operand) {
            Operand.ADD -> operation = AddOperation(firstArgument.numValue, secondArgument.numValue)
            Operand.SUBTRACT -> operation = SubtractOperation(firstArgument.numValue, secondArgument.numValue)
            Operand.MULTIPLY -> operation = MultiplyOperation(firstArgument.numValue, secondArgument.numValue)
            Operand.DIVIDE -> operation = DivideOperation(firstArgument.numValue, secondArgument.numValue)
            null -> { /* No-Op */
            }
        }
        updateCurrentDisplay()
    }

    private fun updateCurrentDisplay() {
        currentDisplay.value = operation?.result?.toString()
            ?: operand?.let { "${firstArgument.value} ${it.symbol} ${secondArgument.value}" }
                    ?: firstArgument.value
    }
}
