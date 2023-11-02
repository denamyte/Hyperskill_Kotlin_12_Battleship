private fun Int.isSmallEven() = this <= 20 && this % 2 == 0

fun main() =
    readln().split(" ").map { it.toInt() }
        .all(Int::isSmallEven)
        .let(::println)
