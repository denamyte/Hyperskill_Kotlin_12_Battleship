fun main() =
    readln().split(" ")
        .also { println(it.size) }
        .map { it.lowercase() }
        .associateWith { listOf(it.length) }
        .let(::println)
