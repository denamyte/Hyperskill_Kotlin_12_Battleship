// You can experiment here, it won’t be checked

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // chunked into 3
    println(list.chunked(3)) // [[1, 2, 3], [4, 5, 6], [7, 8, 9], [10]]
    // chunked into 3, the result transformed by applying a lambda with sum
    println(list.chunked(3) { it.sum() }) // [6, 15, 24, 10]
    // chunked into 3, the result transformed into a string
    println(list.chunked(3) { it.joinToString() }) // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
}
