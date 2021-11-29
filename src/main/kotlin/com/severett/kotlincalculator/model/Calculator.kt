package com.severett.kotlincalculator.model

import androidx.compose.runtime.MutableState
import kotlin.math.floor
import kotlin.math.pow

class Calculator(private var currentDisplay: MutableState<String>) {
    private val firstArgument = Argument()
    private var operand: Operand? = null
    private val secondArgument = Argument()

    fun updateOperand(operand: Operand?) {
        if (this.operand != null && secondArgument.isInitialized) {
            setOperation()
        }
        this.operand = operand
        updateCurrentDisplay()
    }

    fun updateArgument(addition: Int) {
        if (operand == null) {
            firstArgument.update(addition.toString())
        } else {
            secondArgument.update(addition.toString())
        }
        updateCurrentDisplay()
    }

    fun setDecimal() {
        if (operand == null) {
            firstArgument.update(".")
        } else {
            secondArgument.update(".")
        }
        updateCurrentDisplay()
    }

    fun flipPositive() {
        if (operand == null) {
            firstArgument.flipPositivity()
        } else {
            secondArgument.flipPositivity()
        }
        updateCurrentDisplay()
    }

    fun setExponentOperation(power: Double) {
        val argumentToUpdate = if (operand == null) firstArgument else secondArgument
        if (argumentToUpdate.isInitialized) {
            val newValue = argumentToUpdate.numValue.toDouble().pow(power)
            argumentToUpdate.reset(
                if (newValue == floor(newValue)) newValue.toInt().toString() else newValue.toString()
            )
        }
        updateCurrentDisplay()
    }

    fun setOperation() {
        if (firstArgument.isInitialized && secondArgument.isInitialized) {
            operand?.let { op ->
                firstArgument.reset(op.operation(firstArgument.numValue, secondArgument.numValue).toString())
                secondArgument.reset()
                operand = null
                updateCurrentDisplay()
            }
        }
    }

    fun clear() {
        firstArgument.reset()
        operand = null
        secondArgument.reset()
        updateCurrentDisplay()
    }

    fun clearEntry() {
        if (secondArgument.isInitialized) {
            secondArgument.reset()
        } else if (operand != null) {
            operand = null
        } else {
            firstArgument.reset()
        }
        updateCurrentDisplay()
    }

    fun backspace() {
        if (operand == null) {
            firstArgument.backspace()
        } else if (secondArgument.isInitialized) {
            secondArgument.backspace()
        } else {
            operand = null
        }
        updateCurrentDisplay()
    }

    private fun updateCurrentDisplay() {
        currentDisplay.value = operand?.let { "${firstArgument.value} ${it.symbol} ${secondArgument.value}" }
                    ?: firstArgument.value
    }
}
