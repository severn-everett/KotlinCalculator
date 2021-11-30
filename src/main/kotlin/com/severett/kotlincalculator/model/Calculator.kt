package com.severett.kotlincalculator.model

import androidx.compose.runtime.MutableState
import com.severett.kotlincalculator.util.checkForInt
import kotlin.math.pow

class Calculator(private var currentDisplay: MutableState<String>) {
    private val firstArgument = Argument()
    private var operand: Operand? = null
    private val secondArgument = Argument()

    fun updateOperand(operand: Operand?) {
        this.operand?.let { op ->
            if (secondArgument.isInitialized) {
                try {
                    firstArgument.reset(op.operation(firstArgument.numValue, secondArgument.numValue).toString())
                } catch (ae: ArithmeticException) {
                    firstArgument.reset()
                    secondArgument.reset()
                    this.operand = null
                    currentDisplay.value = ERROR_STR
                    return
                }
                secondArgument.reset()
            }
        }
        if (!firstArgument.isInitialized) {
            firstArgument.update("0")
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

    fun setPercentage() {
        if (secondArgument.isInitialized) {
            operand?.let { operand ->
                val percentage = when (operand) {
                    Operand.ADD, Operand.SUBTRACT -> {
                        val percentNum = secondArgument.numValue.toDouble() / 100.0
                        (firstArgument.numValue.toDouble() * percentNum).checkForInt()
                    }
                    Operand.MULTIPLY, Operand.DIVIDE -> {
                        secondArgument.numValue.toDouble() / 100.0
                    }
                }
                secondArgument.reset(percentage.toString())
                updateCurrentDisplay()
            }
        }
    }

    fun setExponentOperation(power: Double) {
        val argumentToUpdate = if (operand == null) firstArgument else secondArgument
        if (argumentToUpdate.isInitialized) {
            val newValue = argumentToUpdate.numValue.toDouble().pow(power)
            argumentToUpdate.reset(newValue.checkForInt().toString())
        }
        updateCurrentDisplay()
    }

    fun finalizeOperation() {
        if (firstArgument.isInitialized && secondArgument.isInitialized) {
            operand?.let { op ->
                currentDisplay.value = try {
                    op.operation(firstArgument.numValue, secondArgument.numValue).toString()
                } catch (ae: ArithmeticException) {
                    ERROR_STR
                }
                firstArgument.reset()
                secondArgument.reset()
                operand = null
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

    private companion object {
        private const val ERROR_STR = "ERR"
    }
}
