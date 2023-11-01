package battleship

class Board {

    enum class Cells(private val mark: Char) {
        Fog('~'),
        Ship('O'),
        Hit('X'),
        Miss('M');

        override fun toString() = mark.toString()
    }

    companion object {
        private const val CAPTION = "  1 2 3 4 5 6 7 8 9 10\n"
        private val SEA_ROW = "%s ".repeat(11).trim()
        private val LETTERS = 'A'..'J'

        private val SHIFT_CELLS = listOf(Pair(-1, -1), Pair(-1, 0), Pair(-1, 1),
                                         Pair( 0, -1), Pair( 0, 0), Pair( 0, 1),
                                         Pair( 1, -1), Pair( 1, 0), Pair( 1, 1)
        )

        private fun emptySea() = MutableList(10) { MutableList(10) { Cells.Fog } }
    }

    /** The living ship cells */
    private val shipCells: MutableMap<Crd, Ship> = mutableMapOf()
    /** The hit ship cells */
    private val hitCells: MutableMap<Crd, Ship> = mutableMapOf()
    private val missCells: MutableSet<Crd> = mutableSetOf()
    private val ships = mutableSetOf<Ship>()

    fun shipFits(ship: Ship): Boolean {
        for (crd in ship.crdView) if (isShipNearOrInCell(crd)) return false
        return true
    }

    private fun isShipNearOrInCell(crd: Crd) =
        SHIFT_CELLS.map { shift -> Pair(shift.first + crd.first, shift.second + crd.second) }
            .intersect(shipCells.keys)
            .isNotEmpty()

    fun addShip(ship: Ship) {
        ships.add(ship)
        shipCells.putAll(ship.crdView.map { crd -> crd to ship })
    }

    private fun getWholeSea(): MutableList<MutableList<Cells>> =
        emptySea().also { sea ->
            shipCells.keys.forEach { sea[it.first][it.second] = Cells.Ship }
            hitCells.keys.forEach { sea[it.first][it.second] = Cells.Hit }
            missCells.forEach { sea[it.first][it.second] = Cells.Miss }
        }

    override fun toString(): String {
        val sea = getWholeSea()
        return CAPTION +
        LETTERS.mapIndexed { i, letter ->
            SEA_ROW.format(letter, *sea[i].toTypedArray())
        }.joinToString("\n") + '\n'
    }
}