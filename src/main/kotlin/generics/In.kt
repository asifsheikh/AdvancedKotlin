package generics

/**
 * When you declare a generic type with an in modifier, it's called contravariant.
 * A contravariant is a consumer of T, that means functions can take T as arguments but they can't return T:
 */

class CaseIn<in T > {
    private val contents = mutableListOf<T>()
   //fun produce(): T = contents.last()         // Producer: Error
    fun consume(item: T) = contents.add(item)  // Consumer: OK
}

//The Case declared with the in modifier consumes T and its subtypes:
fun useConsumer(case: CaseIn<Dog>) {
    // Consumes Dog and its subtypes
    case.consume(GermanShepherd())
}

//usages
/**
 * With the in modifier, the subtyping is reversed, so now the Case<Animal> is a supertype of Case<Dog> when Dog is a subtype of Animal. As a result, the useConsumer() function can be called with CaseIn<Animal> too:
 * This is less restrictive and more reusable while consuming but our class becomes write only.
 */
fun main() {
    //useConsumer(CaseIn<GermanShepherd>())               // Error
    useConsumer(CaseIn<Dog>())                     // OK
    useConsumer(CaseIn<Animal>())                    // OK
}