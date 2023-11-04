data class Movie(
    var name: String = "The Knack ...and How to Get It",
    var link: String = "https://",
    var dataBaseName: String = "IMDB"
)

fun main() = Movie().apply {
    val data = readln().split(" ")
    link = data[1]
    dataBaseName = data[0]
}.let(::println)