fun main() {
    val runnable = object : Runnable {
        override fun run() {
            print("Hello, world!")
        }
    }

    runnable.run()
}