// Do not change the code below!

data class Color(val code: Int) {
    override fun toString() = "$code"
}

interface Listed {
    val index: String
}

interface Tabulated : Listed {
    val row: Int
    val column: Int
    val dataType: String
    val isEmpty: Boolean

    override val index: String
}

interface Colored {
    val color: Color
}

// Do not change the code above!

// You probably want to inherit from something...

interface TableCell : Tabulated, Colored {
    val info get() = "$column, $row; Color: $color"
}