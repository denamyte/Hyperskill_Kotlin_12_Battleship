fun main() {
    for (suffix in 'A'..'B') {
        WorkerThread("worker-$suffix").start()
    }
}

// Don't change the code below
class WorkerThread(name: String) : Thread(name) {
    val numberOfLines = 3

    override fun run() {
        val name = currentThread().name

        if (!name.startsWith("worker-")) {
            return
        }

        for (i in 0 until numberOfLines) {
            println("do something...")
        }
    }
}