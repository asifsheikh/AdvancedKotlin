package sam

fun main() {
    // function assignment
    val functionReference = ::sayHello

    //function call
    functionReference("John") // This calls sayHello("John")

    // function calls
    method(3) { input -> callback(input) } //lambda
    method(3, ::callback) // function reference


    JavaSAM { input -> callback(input) }


    javaInit(::callback) // function ref
    javaInit { input -> callback(input) } // lambda


    val kotlinSAM = object : KotlinSAM {
        override fun play(input: String) {
            callback(input)
        }
    }

    kotlinInit(kotlinSAM)
}

fun javaInit(javaSAM: JavaSAM) {
    javaSAM.play("dummy string")
}

fun kotlinInit(kotlinSAM: KotlinSAM) {

}

fun sayHello(name: String) {
    println("Hello, $name!")
}

fun method(num: Int, callback: (String) -> Unit) {
    //function call
    callback("dummy value")
}

fun callback(input: String): Unit {
    println(input)
}