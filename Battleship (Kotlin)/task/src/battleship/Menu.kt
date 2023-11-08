package battleship

class Menu {
    private val boards = (1..2).map { Board("Player $it") }
    private var bIndex = 0

    fun run() {
        placeShips()
        passMove()
        placeShips()
        passMove(1)

        while (true) {
            if (shoot() == Board.MoveResult.AllSunken) break
            passMove()
        }
    }

    private fun prn1(msg: String) = Utils.printWithTrailingLines(msg)

    private fun nextIndex(): Int = (bIndex + 1) % 2

    private fun placeShips() {
        placeShipsPrompt()
        val board = boards[bIndex]
        prn1(board.render(fog = false))

        Utils.NAME_TO_SIZE_MAP.forEach { (name, size) ->
            prn1("Enter the coordinates of the $name ($size cells):")

            while (true) {
                val raw = readln()
                println()
                val (crd1, crd2) = Utils.parseDoubleCrd(raw)
                when {
                    Utils.isShipShapeWrong(crd1, crd2) ->
                        prn1("Error! Wrong ship location! Try again:")

                    Utils.isShipSizeWrong(name, crd1, crd2) ->
                        prn1("Error! Wrong length of the $name! Try again:")

                    else -> {
                        val ship = Ship(name, crd1, crd2)
                        if (!board.shipFits(ship))
                            prn1("Error! You placed it too close to another one. Try again:")
                        else {
                            board.addShip(ship)
                            break
                        }
                    }
                }
            }
            prn1(board.render(fog = false))
        }
    }

    /** Print a prompt to a current player to place their ships. */
    private fun placeShipsPrompt() =
        prn1("${boards[bIndex].name}, place your ships on the game field")

    private fun passMove(newlinesCount: Int = 0) {
        bIndex = nextIndex()
        print("Press Enter and pass the move to another player\n...")
        readln()
        repeat(newlinesCount) { println() }
    }

    private fun shoot(): Board.MoveResult {
        printBoards()
        turnPrompt()

        while (true) {
            val raw = readln()
            println()
            if (!Utils.isCrdValid(raw)) {
                prn1("Error! You entered the wrong coordinates! Try again:")
                continue
            }
            val crd = Utils.parseCrd(raw)

            return boards[nextIndex()].move(crd)
                .also {
                    when (it) {
                        Board.MoveResult.Miss -> "You missed!"
                        Board.MoveResult.Hit -> "You hit a ship!"
                        Board.MoveResult.Sunken -> "You sank a ship!"
                        else -> "You sank the last ship. You won. Congratulations!"
                    }.let(::println)
                }
        }
    }

    private fun printBoards() {
        println(boards[nextIndex()].render())
        println("---------------------")
        prn1(boards[bIndex].render(fog = false))
    }

    private fun turnPrompt() = prn1("${boards[bIndex].name}, it's your turn:")
}