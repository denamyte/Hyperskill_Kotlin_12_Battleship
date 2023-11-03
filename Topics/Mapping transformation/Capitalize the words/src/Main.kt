fun main() = readln().split(" ")
    .map { it.replaceFirstChar(Char::uppercase) }
    .let(::println)