package generics

// Case Out
/**
 * When you declare a generic type with an out modifier it's called covariant.
 * A covariant is a producer of T, that means functions can return T but they can't take T as arguments:
 */
class CaseOut<out T> {
    private val contents = mutableListOf<T>()
    fun produce(): T = contents.last()         // Producer: OK
   //fun consume(item: T) = contents.add(item)  // Consumer: Error
}

fun useProducer(case: CaseOut<Animal>) {
    // Produces Dog and its subtypes - GermanShepherd
    val rifle = case.produce()
}

//usages
/**
 * With the out modifier, the subtyping is preserved, so the Case<GermanShepherd> is a subtype of Case<Dog> when GermanShepherd is a subtype of Dog. As a result, the useProducer() function can be called with Case<GermanShepherd> too:
 * This is less restrictive and more reusable while producing but our class becomes read only.
 */
fun main() {
    useProducer(CaseOut<GermanShepherd>())               // OK
    useProducer(CaseOut<Dog>())                     // OK
    useProducer(CaseOut<Animal>())                    // Error
}