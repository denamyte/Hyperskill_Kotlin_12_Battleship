fun main() = Array(readln().toInt()) { readln().toInt() }
    .map { it * readln().toInt() }
    .run { indexOf(maxOrNull()) + 1 }
    .let(::println)