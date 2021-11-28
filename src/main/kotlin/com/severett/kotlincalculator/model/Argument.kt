package com.severett.kotlincalculator.model

class Argument {
    private var doubleState = DoubleState.UNINITIALIZED
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

    fun reset(newValue: String? = null) {
        value = newValue ?: "0"
        doubleState = if (value.contains('.')) DoubleState.POPULATED else DoubleState.UNINITIALIZED
    }
}
