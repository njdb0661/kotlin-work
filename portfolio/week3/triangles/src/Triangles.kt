// COMP2850 Portfolio: Week 2
// Functions for working with triangle geometry

import kotlin.math.sqrt

typealias Triangle = Triple<Double,Double,Double>

// Add isValidTriangle() and triangleArea() functions here

fun isValidTriangle(theShape: Triangle): Boolean {
    val (a, b, c) = theShape

    if (a + b == c || b + c == a || a + c == b) {
        return false
    }
    else if (a + b < c || b + c < a || a + c < b) {
        return false
    }
    else if (a < b + c && b < a + c && c < a + b) {
        return true
    }
    else {
        return false
    }
}

fun triangleArea(theShape: Triangle): Double {

    if (isValidTriangle(theShape) == false) {
        throw IllegalArgumentException("Invalid Triangle")
    }

    val (a, b, c) = theShape

    val s = (a + b + c)/2
    val theArea = sqrt(s*((s - a)*(s - b)*(s - c)))

    return theArea
}