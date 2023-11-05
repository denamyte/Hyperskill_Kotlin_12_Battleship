open class Animal {
    open fun makeSound() {
        println("Animal sound")
    }
}

val animal = object : Animal() {
    override fun makeSound() {
        println("Meow")
    }
}