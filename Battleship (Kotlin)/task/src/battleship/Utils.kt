package battleship

import kotlin.math.abs

typealias Crd = Pair<Int, Int>

class Utils {
    companion object {
        val NAME_TO_SIZE_MAP = mapOf(
            "Aircraft Carrier" to 5,
            "Battleship" to 4,
            "Submarine" to 3,
            "Cruiser" to 3,
            "Destroyer" to 2,
        )

        fun isShipShapeWrong(crd1: Crd, crd2: Crd) = crd1.first != crd2.first && crd1.second != crd2.second

        fun isShipSizeImpossible(name: String, crd1: Crd, crd2: Crd) =
            (crd1.first == crd2.first && abs(crd1.second - crd2.second) + 1 != NAME_TO_SIZE_MAP[name]) ||
                    (crd1.second == crd2.second && abs(crd1.first - crd2.first) + 1 != NAME_TO_SIZE_MAP[name])

        private const val FIRST_CRD_LETTER = 'A'

        fun convertDoubleCrd(raw: String): Pair<Crd, Crd> =
            raw.split(" ").let { parts ->
                return Pair(convertCrd(parts[0]), convertCrd(parts[1]))
            }

        fun convertCrd(part: String): Crd = Pair(part[0] - 'A', part.substring(1).toInt() - 1)
    }
}