package battleship

class Menu {
    private val board = Board()

    fun run() {
        placeShips()
        shootLoop()
    }

    private fun placeShips() {
        println(board.render(fog = false))

        Utils.NAME_TO_SIZE_MAP.forEach { (name, size) ->
            println("Enter the coordinates of the $name ($size cells):\n")

            while (true) {
                val raw = readln()
                println()
                val (crd1, crd2) = Utils.parseDoubleCrd(raw)
                when {
                    Utils.isShipShapeWrong(crd1, crd2) ->
                        println("Error! Wrong ship location! Try again:\n")

                    Utils.isShipSizeWrong(name, crd1, crd2) ->
                        println("Error! Wrong length of the $name! Try again:\n")

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
            println(board.render(fog = false))
        }
    }

    private fun shootLoop() {
        println("The game starts!\n")
        println(board.render())
        println("Take a shot!\n")
        shoot()
    }

    private fun shoot() {
        while (board.notAllSunken()) {
            val raw = readln()
            println()
            if (!Utils.isCrdValid(raw)) {
                println("Error! You entered the wrong coordinates! Try again:\n")
                continue
            }
            val crd = Utils.parseCrd(raw)
            val move = board.move(crd)
            println(board.render())
            when (move) {
                Board.MoveResult.Miss -> "You missed. Try again:\n"
                Board.MoveResult.Hit -> "You hit a ship! Try again:\n"
                Board.MoveResult.Sunken -> "You sank a ship! Specify a new target:\n"
                Board.MoveResult.AllSunken -> "You sank the last ship. You won. Congratulations!"
            }.let(::println)
        }
    }
}