data class Musician(var name: String = "", var band: String = "", var role: String = "")

fun main() =
    Musician().apply {
        name = readln()
        band = readln()
        role = readln()
    }.run {
        println(this)
        name.length
    }.let { length ->
        (length / 4).also(::println)
    }.let {
        it + 10
    }.let(::println)
