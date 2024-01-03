package generics

/**
 * In Kotlin, we have three kinds of generic elements:
 * generic functions,
 * generic classes,
 * generic interfaces.
 */

open class Animal {
    open fun makeSound() {
        println("Some animal sound")
    }
}

open class Dog : Animal() {
    override fun makeSound() {
        println("Bark!!")
    }
}

class GermanShepherd : Dog() {
    override fun makeSound() {
        println("German Shepherd Bark!!")
    }
}

class AustrialianShephered : Dog () {
    override fun makeSound() {
        println("Austrialn Bark!!")
    }
}

