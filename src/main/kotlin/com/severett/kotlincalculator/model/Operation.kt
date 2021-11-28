package com.severett.kotlincalculator.model

import kotlin.math.pow

interface Operation {
    val firstArgument: Number
    val secondArgument: Number

    val result: Number
    fun isIntOperation() = (firstArgument is Int && secondArgument is Int)
}

class AddOperation(override val firstArgument: Number, override val secondArgument: Number) : Operation {
    override val result: Number = if (isIntOperation()) {
        firstArgument.toInt() + secondArgument.toInt()
    } else {
        firstArgument.toDouble() + secondArgument.toDouble()
    }
}

class SubtractOperation(override val firstArgument: Number, override val secondArgument: Number) : Operation {
    override val result: Number = if (isIntOperation()) {
        firstArgument.toInt() - secondArgument.toInt()
    } else {
        firstArgument.toDouble() - secondArgument.toDouble()
    }
}

class MultiplyOperation(override val firstArgument: Number, override val secondArgument: Number) : Operation {
    override val result: Number = if (isIntOperation()) {
        firstArgument.toInt() * secondArgument.toInt()
    } else {
        firstArgument.toDouble() * secondArgument.toDouble()
    }
}

class DivideOperation(override val firstArgument: Number, override val secondArgument: Number) : Operation {
    override val result: Number = if (isIntOperation()) {
        firstArgument.toInt() / secondArgument.toInt()
    } else {
        firstArgument.toDouble() / secondArgument.toDouble()
    }
}

class ExponentOperation(override val firstArgument: Number, override val secondArgument: Number) : Operation {
    override val result: Number = firstArgument.toDouble().pow(secondArgument.toDouble())
}
