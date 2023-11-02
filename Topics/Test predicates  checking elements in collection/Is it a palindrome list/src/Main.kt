fun main() = readln().split(" ")
    .all { it == it.reversed() }
    .let(::println)