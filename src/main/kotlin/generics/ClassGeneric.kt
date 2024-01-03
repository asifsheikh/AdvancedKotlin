package generics

class Box<T> {
    private var item: T? = null

    fun put(item: T) {
        this.item = item
    }

    fun get(): T? = item
}

fun main() {
    val box: Box<Int> = Box()
    box.put(42)
    println(box.get())  // prints "42"
}