// You can experiment here, it won’t be checked

val isEven: (Int) -> Boolean = { x -> x % 2 == 0 }

fun isEven2(x: Int): Boolean {
    return x % 2 == 0
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // any number is even?
    println(numbers.any { x -> x % 2 == 0 }) // true
    println(numbers.any { isEven(it) }) // true
    println(numbers.any(isEven)) // true
    println(numbers.any()) // true
    println(numbers.none()) // true
}
