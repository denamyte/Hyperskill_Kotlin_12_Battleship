class NumbersThread(private val from: Int, private val to: Int) : Thread() { //implement the constructor
    override fun run() = (from..to).forEach(::println)
}