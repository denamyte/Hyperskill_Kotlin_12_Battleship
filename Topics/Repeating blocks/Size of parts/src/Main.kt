val results = arrayOf(0, 1, -1)

fun main() = Array(readln().toInt()) { readln().toInt() }
    .run {
        results.map { res -> this.count { it == res } }
            .joinToString(" ")
    }
    .let(::println)