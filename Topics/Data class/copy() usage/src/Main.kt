// do not change this data class
data class Box(val height: Int, val length: Int, val width: Int)

fun main() {
    val (h, l1, l2, w) = Array(4) { readln().toInt() }
    Box(h, l1, w).run {
        println(this)
        println(copy(length = l2))
    }
}