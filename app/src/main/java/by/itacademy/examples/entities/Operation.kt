package by.itacademy.examples.entities

sealed class Operation {
    class Add(val value: Int) : Operation()
    class Substract(val value: Int) : Operation()
    class Multiply(val value: Int) : Operation()
    class Divide(val value: Int) : Operation()

//    object Increment : Operation()
//    object Decrement : Operation()
}