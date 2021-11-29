package com.severett.kotlincalculator.model

class Argument {
    private var doubleState = DoubleState.UNINITIALIZED
    private var isPositive = true
    var value: String = EMPTY
        private set
    val isInitialized: Boolean
        get() = value.isNotEmpty()
    val numValue: Number
        get() = if (doubleState != DoubleState.UNINITIALIZED) value.toDouble() else value.toInt()

    fun update(addition: String) {
        if (addition == ".") {
            if (doubleState == DoubleState.UNINITIALIZED) {
                doubleState = DoubleState.INITIALIZED
                value = if (isInitialized) "$value.0" else "0.0"
            }
        } else {
            value = if (!isInitialized || value == "0") {
                addition
            } else {
                if (doubleState == DoubleState.INITIALIZED) {
                    doubleState = DoubleState.POPULATED
                    "${value.substringBeforeLast("0")}$addition"
                } else if (value == "-0") {
                    "-$addition"
                } else {
                    "$value$addition"
                }
            }
        }
    }

    fun flipPositivity() {
        if (isPositive && (!isInitialized || value[0] != '-')) {
            value = if (isInitialized) "-$value" else "-0"
        } else if (!isPositive && value[0] == '-') {
            value = value.substring(1)
        }
        isPositive = !isPositive
    }

    fun backspace() {
        value = if (value.length > 1) {
            if (value[value.length - 2] == '.') {
                doubleState = DoubleState.UNINITIALIZED
                value.substring(0, value.length - 2)
            } else if (value[0] == '-') {
                isPositive = true
                value.substring(1)
            } else {
                value.substring(0, value.length - 1)
            }
        } else {
            EMPTY
        }
    }

    fun reset(newValue: String = EMPTY) {
        value = newValue
        isPositive = !isInitialized || value[0] != '-'
        doubleState = if (value.contains('.')) DoubleState.POPULATED else DoubleState.UNINITIALIZED
    }

    private companion object {
        const val EMPTY = ""
    }
}

private enum class DoubleState {
    UNINITIALIZED,
    INITIALIZED,
    POPULATED
}
