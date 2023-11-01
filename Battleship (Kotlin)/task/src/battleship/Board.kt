package battleship

class Board {

    enum class Cell(private val mark: Char) {
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

    private fun getWholeSea(): MutableList<MutableList<Cell>> =
        emptySea().also { sea ->
            shipCells.keys.forEach { sea[it.first][it.second] = Cell.Ship }
            hitCells.forEach { sea[it.first][it.second] = Cell.Hit }
            missCells.forEach { sea[it.first][it.second] = Cell.Miss }
        }

    fun move(crd: Crd): Cell =
        when {
            crd in shipCells -> {
                val ship = shipCells.remove(crd)!!
                hitCells.add(crd)
                ship.hit(crd)
                Cell.Ship
            }
            else -> {
                missCells.add(crd)
                Cell.Miss
            }
        }

    override fun toString(): String {
        val sea = getWholeSea()
        return CAPTION +
        LETTERS.mapIndexed { i, letter ->
            SEA_ROW.format(letter, *sea[i].toTypedArray())
        }.joinToString("\n") + '\n'
    }
}