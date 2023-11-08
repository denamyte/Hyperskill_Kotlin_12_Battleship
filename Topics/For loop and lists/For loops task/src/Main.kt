fun main() = List(readln().toInt()) { readln() }
    .run { containsAll(readln().split(" ")) }
    .let { if (it) "YES" else "NO" }
    .let(::println)