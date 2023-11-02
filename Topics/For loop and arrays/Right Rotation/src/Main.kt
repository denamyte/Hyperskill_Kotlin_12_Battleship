fun main() {
    val n = readln().toInt()
    val ar = IntArray(n) { readln().toInt() }
    val shift = n - readln().toInt() % n
    repeat(n) { print("${ar[(it + shift) % n]} ") }
}