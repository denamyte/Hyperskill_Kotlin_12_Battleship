package battleship

import java.math.BigDecimal

class Test {
}

fun main() {
    var first = BigDecimal("0.2")

// decrement
    val decrement = (--first).also(::println) //  -0.8
// increment
    val increment = (++first).also(::println) //  0.2
// unary minus, turning to opposite sign
    val reverse = (-first).also(::println)  //  -0.2
// absolute value
    val module = first.abs().also(::println)  //  0.2
// raise to the power, works only with Int
    val power = first.pow(3).also(::println)

    print(BigDecimal(0.01))
}