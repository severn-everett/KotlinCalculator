package com.severett.kotlincalculator.util

import kotlin.math.floor

fun Double.checkForInt(): Number = if (this == floor(this)) this.toInt() else this
