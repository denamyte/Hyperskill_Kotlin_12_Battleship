fun main() =
    (1..3)
        .map { Thread(RunnableWorker(), "worker-$it") }
        .forEach(Thread::start)

// Don't change the code below       
class RunnableWorker : Runnable {
    override fun run() {
        if (Thread.currentThread().name.startsWith("worker-"))
            println("too hard calculations...")
    }
}