fun main() = readln().split(" ")
    .map { it.split("-")[1].toInt() }
    .chunked(3) { it.average().toInt() }
    .let(::println)