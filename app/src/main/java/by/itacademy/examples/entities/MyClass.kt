package by.itacademy.examples.entities

data class MyClass(private val myValue: String) {

    public var classfield: String = ""

    companion object Factory {
        fun create(): MyClass = MyClass("Default Value")

        
    }
}