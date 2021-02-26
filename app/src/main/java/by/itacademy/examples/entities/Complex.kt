package by.itacademy.examples.entities

class Complex(private val real : Double, private val virtual : Double) {
    override fun toString(): String {
        var result = ""
        if (real != 0.0) result += "$real"
        if (virtual != 0.0) {
            result += if (virtual > 0) {
                "+ $virtual"
            } else {
                " $virtual"
            }
        }
        return result
    }

    operator fun plus(second: Complex) : Complex = Complex(real + second.real, virtual + second.virtual)
    operator fun times(second: Complex) : Complex {
        val newReal = real * second.real - (virtual * second.virtual)
        val newVirtual = virtual * second.real + real * second.virtual
        return Complex(newReal, newVirtual)
    }


}