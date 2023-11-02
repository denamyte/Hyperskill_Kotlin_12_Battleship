// You can experiment here, it won’t be checked

fun main(args: Array<String>) {
    val map = mapOf(1 to "one", 2 to "two", 3 to "three")
    println(map.mapKeys { it.key * 2 }) // {2=one, 4=two, 6=three}
    println(map.mapValues { it.value.uppercase() }) // {1=ONE, 2=TWO, 3=THREE}
}
