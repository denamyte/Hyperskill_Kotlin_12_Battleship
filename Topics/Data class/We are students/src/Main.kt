data class Student(val name: String, val money: Int) {
    override fun equals(other: Any?) = other is Student &&
            name == other.name &&
            money < 1500 &&
            other.money < 1500
}