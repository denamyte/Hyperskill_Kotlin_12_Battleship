import java.util.Collections

fun main() = MutableList(readln().toInt()) { readln() }
    .also { Collections.rotate(it, readln().toInt()) }
    .joinToString(" ")
    .run(::println)