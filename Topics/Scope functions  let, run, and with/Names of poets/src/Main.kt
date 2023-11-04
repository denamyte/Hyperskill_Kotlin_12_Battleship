fun main() {
    val poet: String? = readln()

    val coolScope = poet?.let {
        println("Our poet is $it")
        it.count { it.lowercase() == "a" }
    }

    println(coolScope)
}