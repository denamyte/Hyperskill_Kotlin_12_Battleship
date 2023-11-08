fun main() =
    Array(3) { readln().toBigDecimal() }
        .sumOf { it }
        .let(::println)