package com.severett.kotlincalculator.model

class Argument {
    private var doubleState = DoubleState.UNINITIALIZED
    private var isPositive = true
    var value: String = "0"
        private set
    val numValue: Number
        get() = if (doubleState != DoubleState.UNINITIALIZED) value.toDouble() else value.toInt()

    fun update(addition: String) {
        if (addition == ".") {
            if (doubleState == DoubleState.UNINITIALIZED) {
                doubleState = DoubleState.INITIALIZED
                value = "$value.0"
            }
        } else {
            value = value.let {
                if (it == "0") {
                    addition
                } else if (doubleState == DoubleState.INITIALIZED) {
                    doubleState = DoubleState.POPULATED
                    "${it.substringBeforeLast("0")}$addition"
                } else {
                    "$it$addition"
                }
            }
        }
    }

    fun flipPositivity() {
        if (isPositive && value[0] != '-') {
            value = "-$value"
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
            "0"
        }
    }

    fun reset(newValue: String? = null) {
        value = newValue ?: "0"
        isPositive = value[0] != '-'
        doubleState = if (value.contains('.')) DoubleState.POPULATED else DoubleState.UNINITIALIZED
    }
}
