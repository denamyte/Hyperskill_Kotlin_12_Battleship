fun main() = DoubleArray(readln().toInt()) { readln().toDouble() }
    .mapIndexed { i, v -> Pair(i, v * readln().toInt() / 100) }
    .maxByOrNull { pair -> pair.second }
    .let { print((it?.first ?: 0) + 1) }