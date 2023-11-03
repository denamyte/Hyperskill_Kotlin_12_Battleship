data class Spell(val name: String, val power: Int)

fun main() = readln().split(" ")
    .map { it.split("-") }
    .map { Spell(it[0], it[1].toInt()) }
    .takeWhile { it.power > 50 }
    .let(::println)