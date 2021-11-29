package com.severett.kotlincalculator.model

import androidx.compose.runtime.MutableState
import kotlin.math.floor
import kotlin.math.pow

class Calculator(private var currentDisplay: MutableState<String>) {
    private var operation: Operation? = null
    private val firstArgument = Argument()
    private var operand: Operand? = null
    private val secondArgument = Argument()

    fun updateOperand(operand: Operand?) {
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
        val newValue = argumentToUpdate.numValue.toDouble().pow(power)
        argumentToUpdate.reset(if (newValue == floor(newValue)) newValue.toInt().toString() else newValue.toString())
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

    fun clear() {
        firstArgument.reset()
        operand = null
        secondArgument.reset()
        operation = null
        updateCurrentDisplay()
    }

    fun clearEntry() {
        if (secondArgument.numValue != 0) {
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
        } else if (secondArgument.numValue != 0) {
            secondArgument.backspace()
        } else {
            operand = null
        }
        updateCurrentDisplay()
    }

    private fun updateCurrentDisplay() {
        currentDisplay.value = operation?.result?.toString()
            ?: operand?.let { "${firstArgument.value} ${it.symbol} ${secondArgument.value}" }
                    ?: firstArgument.value
    }
}
