fun main() {
    val (it1, it2) = Array(2) { readln().iterator() }
    var first = true
    while (it1.hasNext() || it2.hasNext()) {
        if (first) {
            first = false
            prn(it1)
        } else {
            first = true
            prn(it2)
        }
    }
}

private fun prn(it1: CharIterator) {
    if (it1.hasNext()) print(it1.next())
}