fun checkHeight(iterator: Iterator<Int>) {
    while (iterator.hasNext()) {
        val next = iterator.next()
        println(
            if (next < 145 || next > 210) "Sorry, not today"
            else "You can go!"
        )
    }
}

fun main() {
    val list = readln().split(" ").map(Integer::parseInt).toList()
    checkHeight(list.iterator())
}