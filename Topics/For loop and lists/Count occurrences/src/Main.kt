fun main() =
    Array(readln().toInt() + 1) { readln() }.let { array ->
        array.count { it == array.last() } - 1
    }.let(::println)
