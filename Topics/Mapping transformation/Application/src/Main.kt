fun main() = readln().split(" ")
    .map { it.split("-") }
    .map { "{${it[0]}=${it[1].toInt() * 2}}" }
    .let(::println)