fun main() = run {
    val (d, m, y) = Array(3) { readln() }
    "$m.$d.$y"
}.let(::println)