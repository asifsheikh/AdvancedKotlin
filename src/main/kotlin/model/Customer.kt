package model

data class Customer(val name: String, val email: String) {
    fun calculateAge(): Int = 10
    fun doSomething(): String = ""

}