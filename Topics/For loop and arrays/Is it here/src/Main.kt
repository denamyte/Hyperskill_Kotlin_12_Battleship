val RES = mapOf(false to "NO", true to "YES")

fun main() = IntArray(readln().toInt()) { readln().toInt() }
    .contains(readln().toInt())
    .let { print(RES[it]) }