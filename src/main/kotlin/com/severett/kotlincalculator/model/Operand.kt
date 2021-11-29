package com.severett.kotlincalculator.model

enum class Operand(val symbol: String, val operation: (Number, Number) -> Number) {
    ADD("+", { first, second ->
        if (first is Int && second is Int) {
            first.toInt() + second
        } else {
            first.toDouble() + second.toDouble()
        }
    }),
    SUBTRACT("-", { first, second ->
        if (first is Int && second is Int) {
            first.toInt() - second
        } else {
            first.toDouble() - second.toDouble()
        }
    }),
    MULTIPLY("×", { first, second ->
        if (first is Int && second is Int) {
            first.toInt() * second
        } else {
            first.toDouble() * second.toDouble()
        }
    }),
    DIVIDE("/", { first, second ->
        if (first is Int && second is Int) {
            first.toInt() / second
        } else {
            first.toDouble() / second.toDouble()
        }
    }),
}
