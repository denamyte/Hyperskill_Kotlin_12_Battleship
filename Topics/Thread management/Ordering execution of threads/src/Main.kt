fun invokeMethods(t1: Thread, t2: Thread, t3: Thread) {
    try {
        sequenceOf(t3, t2, t1).forEach {
            with(it) {
                start()
                join()
            }
        }

    } catch (e: InterruptedException) {
        println("Exception in thread \"main\" java.lang.RuntimeException: All threads must be terminated before ending the implemented method")
    }
}