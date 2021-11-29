package com.severett.kotlincalculator.model

import com.severett.kotlincalculator.util.checkForInt

enum class Operand(val symbol: String, val operation: (Number, Number) -> Number) {
    ADD("+", { first, second ->
        if (first is Int && second is Int) {
            first.toInt() + second
        } else {
            (first.toDouble() + second.toDouble()).checkForInt()
        }
    }),
    SUBTRACT("-", { first, second ->
        if (first is Int && second is Int) {
            first.toInt() - second
        } else {
            (first.toDouble() - second.toDouble()).checkForInt()
        }
    }),
    MULTIPLY("×", { first, second ->
        if (first is Int && second is Int) {
            first.toInt() * second
        } else {
            (first.toDouble() * second.toDouble()).checkForInt()
        }
    }),
    DIVIDE("/", { first, second ->
        if (first is Int && second is Int) {
            first.toInt() / second
        } else {
            (first.toDouble() / second.toDouble()).checkForInt()
        }
    });
}
