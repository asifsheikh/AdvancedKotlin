package generics

/**
 * When you declare a generic type without any variance modifier, it's called invariant. An invariant is a producer as well as a consumer of T, that means functions can take T as arguments and can also return T:
 */
class Case<T> {
    private val contents = mutableListOf<T>()
    fun produce(): T = contents.last()         // Producer: OK
    fun consume(item: T) = contents.add(item)  // Consumer: OK
}

fun useProducerConsumer(case: Case<Dog>) {
    // Produces Dog and its subtypes
    case.produce()
    // Consumes Dog and its subtypes
    case.consume(GermanShepherd())
}

/**
 * Without the in or out modifier, the subtyping is disallowed, so now neither Case<Animal> nor Case<GermanShepherd> is a subtype of Case<Dog>. As a result, the useProducerConsumer() function can only be called with Case<Dog>:
 * This is more restrictive and less reusable while producing and consuming but we can read and write.
 */

fun main() {
    //useProducerConsumer(Case<GermanShepherd>())       // Error
    useProducerConsumer(Case<Dog>())             // OK
    // useProducerConsumer(Case<Animal>())            // Error
}