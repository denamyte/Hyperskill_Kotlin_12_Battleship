fun main() {
    val n = readln().toInt()
    val ar = IntArray(n) { readln().toInt() }
    repeat(n) { print("${ar[(it - 1 + n) % n]} ") }
}