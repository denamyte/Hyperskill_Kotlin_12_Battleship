fun main() {
    val ns = Array(readln().toInt()) { readln() }
    val m = readln()
    print(ns.count { it == m })
}