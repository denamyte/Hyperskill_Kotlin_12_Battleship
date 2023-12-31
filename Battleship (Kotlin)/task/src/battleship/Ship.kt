package battleship

class Ship(val name: String, crd1: Crd, crd2: Crd) {
    private val coordinates = mutableSetOf<Crd>()
    val crdView get() = coordinates.toSet()

    init {
        for (x in minOf(crd1.first, crd2.first)..maxOf(crd1.first, crd2.first)) {
            for (y in minOf(crd1.second, crd2.second)..maxOf(crd1.second, crd2.second))
                coordinates.add(Pair(x, y))
        }
    }
}