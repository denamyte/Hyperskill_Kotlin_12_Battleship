fun main() = Array(readln().toInt()) { readln() }
    .sumOf { it.split(" ")[1].toInt() }
    .let(::println)