fun main() =
    Array(readln().toInt()) { readln().toInt() }.let { ar ->
        (0..ar.lastIndex - 2).map {
            if (ar[it + 1] - ar[it] == 1 && ar[it + 2] - ar[it + 1] == 1) 1 else 0
        }.sum()
    }.let(::println)