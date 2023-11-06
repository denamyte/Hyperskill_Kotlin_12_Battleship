fun printCurrentThreadInfo() =
    Thread.currentThread().run {
        println("name: $name\npriority: $priority")
    }