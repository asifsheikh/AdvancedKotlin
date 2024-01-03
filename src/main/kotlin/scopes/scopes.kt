package scopes

import model.Customer

/**
 * The five main scope functions in Kotlin are let, run, with, apply, and also
 */

fun main() {

    var nullableCustomer: Customer? = Customer("Tom", "tom@dummy.com")
    val nonNullableCustomer = Customer("Jerry", "jerry@dummy.com")
    //val loggingApi =

    /**
     * let
     * Return Type: The return type of let is the result of the lambda expression, which is the last statement in the lambda or explicitly specified using the return keyword.
     * Usage: let is used to perform operations on a non-null object. It provides a safe call operator (?.) to perform null-checking before executing the lambda block. It allows accessing the object using the it keyword within the lambda.
     */
    val result = nullableCustomer?.let {
        it.doSomething()
        return@let it.name
        it.email
    }

    /**
     * run
     * Return Type: The return type of run is the result of the lambda expression, which is the last statement in the lambda or explicitly specified using the return keyword.
     * Usage: run is similar to let but without the it keyword. It can be used for both nullable and non-null objects. It executes the lambda block on the object and allows accessing its properties and functions directly.
     */
    val runResult = nullableCustomer?.run {
        name
        email
        doSomething()
    }

    /**
     * with()
     * Return Type: The return type of with is the result of the lambda expression, which is the last statement in the lambda or explicitly specified using the return keyword.
     * Usage: with is used to operate on an object without the need to call its members with a dot notation. It allows accessing the object's properties and functions directly within the lambda block.
     */
    val withResult = with(nonNullableCustomer) {
        name
        email
        return@with doSomething()
    }

    /**
     * apply()
     * Return Type: The return type of apply is the object itself.
     * Usage: apply is used when you want to modify an object's properties or call its functions in a builder-like manner. It allows chaining multiple calls on the same object without the need for intermediate variables.
     * Note this doesnt have return
     */

    val applyResult = nonNullableCustomer.apply {
        calculateAge()
        doSomething()
    }

    /**
     * also()
     * Return Type: The return type of also is the object itself.
     * Usage: also is similar to apply but provides a way to perform additional actions on an object within a lambda block. It allows accessing the object using the it keyword and can be used for side effects or logging.
     * Note this doesnt have the return
     */
    val alsoResult = nonNullableCustomer.also {
        it.calculateAge()
        it.doSomething()
    }
}

interface LoggingApi {
    fun log(username: String, email: String)
    fun log(customer: Customer)
}