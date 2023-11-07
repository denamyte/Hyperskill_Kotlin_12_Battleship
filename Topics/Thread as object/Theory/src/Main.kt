import kotlin.concurrent.thread

// You can experiment here, it won’t be checked
class SquareWorkerThread(name: String) : Thread(name) {
    override fun run() {
        while (true) {
            val number = readln().toInt()
            if (number == 0) {
                break
            }
            println(number * number)
        }
        println("$name's finished")
    }
}

fun main() {
    val workerThread = SquareWorkerThread("square-worker")
    workerThread.start() // start a worker (not run!)

    for (i in 0 until 5_555_555_543L) {
        if (i % 1_000_000_000 == 0L) {
            println("Hello from the main!")
        }
    }
}
