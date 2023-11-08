import java.math.BigDecimal
import java.math.RoundingMode

const val SIZE = 3

fun main() =
    Array(SIZE) { readln().toBigDecimal() }
        .sumOf { it }
        .div(BigDecimal(SIZE)).setScale(0, RoundingMode.DOWN)
        .let(::println)
