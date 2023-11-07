fun main() {
    thread {
        generateSequence { readln().toInt() }
            .takeWhile { it != 0 }
            .filter { it and 1 == 0 }
            .forEach(::println)
    }
}