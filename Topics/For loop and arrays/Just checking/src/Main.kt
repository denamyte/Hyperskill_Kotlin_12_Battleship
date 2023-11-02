fun main() =
    List(readln().toInt()) { readln() }
        .containsAll(readln().split(" "))
        .let { if (it) "YES" else "NO" }
        .let(::println)