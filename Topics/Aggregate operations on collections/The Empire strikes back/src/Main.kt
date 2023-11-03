fun main() {
    readln().split(" ")
        .map { it.split("-") }
        .map { it[0] to it[1].toInt() }
        .minBy { it.second }
        .let { println("Ship(name=${it.first}, ammunition=${it.second})") }
}