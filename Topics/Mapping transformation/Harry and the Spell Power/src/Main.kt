fun main() = readln().split(" ")
    .map { it.split("-") }
    .filter { it[1].toInt() >= 40 }
    .map { it[0] }
    .let(::println)