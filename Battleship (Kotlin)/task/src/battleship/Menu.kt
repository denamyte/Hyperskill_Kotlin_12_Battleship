package battleship

class Menu {
    private val board = Board()

    fun run() {
        println(board)

        Utils.NAME_TO_SIZE_MAP.forEach { (name, size) ->
            println("Enter the coordinates of the $name ($size cells):\n")

            while (true) {
                val raw = readln()
                println()
                val (crd1, crd2) = Utils.convertDoubleCrd(raw)
                when {
                    Utils.isShipShapeWrong(crd1, crd2) ->
                        println("Error! Wrong ship location! Try again:\n")
                    Utils.isShipSizeImpossible(name, crd1, crd2) ->
                        println("Error! Wrong length of the Submarine! Try again:\n")
                    else -> {
                        val ship = Ship(name, crd1, crd2)
                        if (!board.shipFits(ship))
                            println("Error! You placed it too close to another one. Try again:\n")
                        else {
                            board.addShip(ship)
                            break
                        }
                    }
                }
            }
            println(board)
        }
    }
}