fun main() =
    readln().split(" ")
        .map { it.toInt() }
        .all { it % 3 == 0 }
        .let(::println)