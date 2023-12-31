package battleship

class Board(val name: String) {

    enum class Cell(private val mark: Char) {
        Fog('~'),
        Ship('O'),
        Hit('X'),
        Miss('M');

        override fun toString() = mark.toString()
    }

    enum class MoveResult {
        Miss,
        Hit,
        Sunken,
        AllSunken
    }

    companion object {
        private const val CAPTION = "  1 2 3 4 5 6 7 8 9 10\n"
        private val SEA_ROW = "%s ".repeat(11).trim()
        private val LETTERS = 'A'..'J'

        private val SHIFT_CELLS = listOf(Pair(-1, -1), Pair(-1, 0), Pair(-1, 1),
                                         Pair( 0, -1), Pair( 0, 0), Pair( 0, 1),
                                         Pair( 1, -1), Pair( 1, 0), Pair( 1, 1)
        )

        private fun emptySea() = MutableList(10) { MutableList(10) { Cell.Fog } }
    }

    private val shipCells: MutableMap<Crd, Ship> = mutableMapOf()
    private val hitCells: MutableSet<Crd> = mutableSetOf()
    private val missCells: MutableSet<Crd> = mutableSetOf()

    fun shipFits(ship: Ship): Boolean {
        for (crd in ship.crdView) if (isShipNearOrInCell(crd)) return false
        return true
    }

    private fun isShipNearOrInCell(crd: Crd) =
        SHIFT_CELLS.map { shift -> Pair(shift.first + crd.first, shift.second + crd.second) }
            .intersect(shipCells.keys)
            .isNotEmpty()

    fun addShip(ship: Ship) {
        shipCells.putAll(ship.crdView.map { crd -> crd to ship })
    }

    private fun getWholeSea(fog: Boolean = true): MutableList<MutableList<Cell>> =
        emptySea().also { sea ->
            if (!fog) shipCells.keys.forEach { sea[it.first][it.second] = Cell.Ship }
            hitCells.forEach { sea[it.first][it.second] = Cell.Hit }
            missCells.forEach { sea[it.first][it.second] = Cell.Miss }
        }

    fun move(crd: Crd): MoveResult =
        when(crd) {
            in shipCells -> {
                val ship = shipCells.remove(crd)!!
                hitCells += crd
                when {
                    // 1. not the last cell of the ship -> Hit
                    // 2. the last cell of the ship -> Sunken
                    // 3. the last ship is sunken -> AllSunken
                    shipCells.values.any { it == ship } -> MoveResult.Hit
                    shipCells.isNotEmpty() -> MoveResult.Sunken
                    else -> MoveResult.AllSunken
                }
            }
            in hitCells -> MoveResult.Hit
            else -> MoveResult.Miss.also { missCells += crd }
        }

    fun notAllSunken(): Boolean {
        return shipCells.isNotEmpty()
    }

    fun render(fog: Boolean = true): String {
        val sea = getWholeSea(fog)
        return CAPTION +
                LETTERS.mapIndexed { i, letter ->
                    SEA_ROW.format(letter, *sea[i].toTypedArray())
                }.joinToString("\n")
    }
}