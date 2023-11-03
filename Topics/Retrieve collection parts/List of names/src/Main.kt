fun main() = readln().split(" ")
    .takeWhile { it.startsWith('j') }
    .let(::println)