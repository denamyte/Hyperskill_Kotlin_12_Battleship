data class TextField(
    var text: String = "Hello!",
    var textSize: Int = 12,
    var fontFamily: String = "Roboto"
)

fun main() = with(TextField()) {
    readln().let {
        println("Old settings: $this")
        text = it
        println("New settings: $this")
    }
}