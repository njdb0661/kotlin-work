// COMP2850 Portfolio: Week 2
// Functions for working with triangle geometry

import kotlin.math.sqrt

typealias Triangle = Triple<Double,Double,Double>

// Add isValidTriangle() and triangleArea() functions here

fun isValidTriangle(theShape: Triangle): Boolean {
    val (a, b, c) = theShape

    if (a < b + c && b < a + c && c < a + b) {
        return true
    }
    else {
        return false
    }
}

fun triangleArea(theShape: Triangle): Double {
    val (a, b, c) = theShape

    val s = (a + b + c)/2
    val theArea = sqrt(s*((s - a)*(s - b)*(s - c)))

    return theArea
}