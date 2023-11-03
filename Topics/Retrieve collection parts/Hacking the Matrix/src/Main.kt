fun main() = readln().split(" ")
    .map { it.toInt() }
    .dropLastWhile { it and 1 == 0 }
    .let(::println)