import java.math.RoundingMode

fun main() {
    val power = readln().toInt()
    val mode = readln().toInt()
    readln().toBigDecimal()
        .setScale(mode, RoundingMode.FLOOR)
        .pow(power)
        .let(::println)
}