fun main() = readln().split(" ")
    .sumOf { it.length }
    .let(::println)