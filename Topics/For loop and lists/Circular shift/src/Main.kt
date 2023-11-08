import java.util.Collections

fun main() = MutableList(readln().toInt()) { readln() }
    .also { Collections.rotate(it, 1) }
    .joinToString(" ")
    .run(::println)