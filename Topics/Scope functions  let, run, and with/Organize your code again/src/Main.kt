data class Musician(var name: String = "", var band: String = "", var role: String = "")

fun main() =
    with(Musician()) {
        name = readln()
        band = readln()
        role = readln()
        println("Name: $name")
        println("Band: $band")
        println("Role: $role")
    }
