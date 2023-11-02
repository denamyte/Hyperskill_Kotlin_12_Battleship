fun main() {
    val ar = Array(readln().toInt()) { readln() }.joinToString(" ")
    val pm = readln().split(Regex("\\s"))
    print(
        if (ar.contains(pm.joinToString(" ")) ||
            ar.contains(pm.reversed().joinToString(" "))
        ) "NO" else "YES"
    )
}