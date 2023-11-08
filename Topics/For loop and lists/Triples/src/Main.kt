fun main() = List(readln().toInt()) { readln().toInt() }.run {
    (0..size - 3).count {
        get(it) - get(it + 1) == -1 && get(it) - get(it + 2) == -2
    }
}.run(::println)