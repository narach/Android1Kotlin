package by.itacademy.examples.objects

import by.itacademy.examples.entities.Point
import kotlin.math.sqrt
import kotlin.math.pow

object VarargFunctionExamples {
    fun polylineLength(vararg points: Point) : Double {
        var length = 0.0
        for(i in 1 until points.size) {
            val distance = sqrt((points[i].x - points[i-1].x).pow(2) + (points[i].y - points[i-1].y).pow(2) )
            length += distance
        }
        return length
    }
}