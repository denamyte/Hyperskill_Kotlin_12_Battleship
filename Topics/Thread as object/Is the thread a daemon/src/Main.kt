fun printIfDaemon(thread: Thread) =
    println(
        when (thread.isDaemon) {
            true -> "daemon"
            else -> "not daemon"
        }
    )
