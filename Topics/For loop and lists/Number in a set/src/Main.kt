fun int() = readln().toInt()

val resMap = mapOf(
    true to "YES",
    false to "NO"
)

fun main() =
    Array(int()) { int() }.contains(int())
        .let { resMap[it] }
        .let(::println)