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

        private val CRD_REGEX = "[A-J]([0-9]|10)".toRegex()

        fun isShipShapeWrong(crd1: Crd, crd2: Crd) = crd1.first != crd2.first && crd1.second != crd2.second

        fun isShipSizeWrong(name: String, crd1: Crd, crd2: Crd) =
            (crd1.first == crd2.first && abs(crd1.second - crd2.second) + 1 != NAME_TO_SIZE_MAP[name]) ||
                    (crd1.second == crd2.second && abs(crd1.first - crd2.first) + 1 != NAME_TO_SIZE_MAP[name])

        fun isCrdValid(raw: String) = CRD_REGEX.matches(raw)

        fun parseDoubleCrd(raw: String): Pair<Crd, Crd> =
            raw.split(" ").let { parts ->
                return Pair(parseCrd(parts[0]), parseCrd(parts[1]))
            }

        fun parseCrd(part: String): Crd = Pair(part[0] - 'A', part.substring(1).toInt() - 1)
    }
}