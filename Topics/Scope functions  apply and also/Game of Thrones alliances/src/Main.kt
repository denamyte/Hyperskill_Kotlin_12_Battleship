fun main() {
    mutableListOf("John Snow", "Daenerys Targaryen").apply {
        println("Old heroes list: ${this.joinToString()}")
        add(readln())
        println("New heroes list: ${this.joinToString()}")
    }
}