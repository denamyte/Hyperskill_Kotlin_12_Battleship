fun processIterator(list: List<String>) =
    list.toMutableList().apply {
        iterator().apply {
            while (hasNext()) {
                if (!next().startsWith("hyper")) remove()
            }
        }
}

fun main() = readln().split(" ")
    .let(::processIterator)
    .reversed()
    .forEach(::println)