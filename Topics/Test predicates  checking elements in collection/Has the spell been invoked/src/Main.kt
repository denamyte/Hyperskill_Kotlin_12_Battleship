fun main() =
    "abracadabra".toRegex(RegexOption.IGNORE_CASE)
        .run { readln().split(" ").any { this.matches(it) } }
        .let(::println)
