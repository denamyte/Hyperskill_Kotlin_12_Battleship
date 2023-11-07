class MessageNotifier(val msg: String, val times: Int) : Thread() { // implement the constructor
    override fun run() = repeat(times) {  println(msg) }
}