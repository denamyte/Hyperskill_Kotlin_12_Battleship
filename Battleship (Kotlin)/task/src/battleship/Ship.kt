package battleship

import kotlin.math.abs

class Ship(val name: String, crd1: Pair<Int, Int>, crd2: Pair<Int, Int>) {

    companion object {
        val NAME_TO_SIZE_MAP = mapOf(
            "Aircraft Carrier" to 5,
            "Battleship" to 4,
            "Submarine" to 3,
            "Cruiser" to 3,
            "Destroyer" to 2,
        )

        fun isShipSizePossible(name: String, crd1: Pair<Int, Int>, crd2: Pair<Int, Int>) =
            crd1.first == crd2.first && abs(crd1.second - crd2.second) == NAME_TO_SIZE_MAP[name] ||
                    crd1.second == crd2.second && abs(crd1.first - crd2.first) == NAME_TO_SIZE_MAP[name]
    }

    private val coordinates = mutableSetOf<Pair<Int, Int>>()
    val crdView get() = coordinates.toSet()

    private val hits = mutableSetOf<Pair<Int, Int>>()
    val hitsView get() = hits.toSet()

    init {
        for (x in minOf(crd1.first, crd2.first)..maxOf(crd1.first, crd2.first))
            for (y in minOf(crd1.second, crd2.second)..maxOf(crd1.second, crd2.second))
                coordinates.add(Pair(x, y))
    }
}