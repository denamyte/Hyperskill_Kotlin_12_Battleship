interface Animal {
    val numberOfLimbs: Int
    fun move()
    fun communicate(): String
}

fun bark() = "bark"

fun walk() = println("walk")

class Dog : Animal {
    override val numberOfLimbs: Int
        get() = 4

    override fun move() = walk()

    override fun communicate() = bark()
}