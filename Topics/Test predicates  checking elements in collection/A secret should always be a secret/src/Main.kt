fun main() =
    readln().split(" ")
        .none { it.equals("secret", true) }
        .let(::println)
