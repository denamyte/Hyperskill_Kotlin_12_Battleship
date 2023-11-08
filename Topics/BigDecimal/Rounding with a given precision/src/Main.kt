import java.math.RoundingMode

fun main() = readln().toBigDecimal()
    .setScale(readln().toInt(), RoundingMode.HALF_DOWN)
    .let(::println)