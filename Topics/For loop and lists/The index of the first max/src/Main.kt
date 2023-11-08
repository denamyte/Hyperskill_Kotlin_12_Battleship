fun main() = List(readln().toInt()) { readln().toInt() }
    .run { indexOf(maxOrNull()) }
    .let(::println)