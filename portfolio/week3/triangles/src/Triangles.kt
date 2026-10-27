// COMP2850 Portfolio: Week 2
// Functions for working with triangle geometry

import kotlin.math.sqrt

typealias Triangle = Triple<Double,Double,Double>

// Add isValidTriangle() and triangleArea() functions here

fun isValidTriangle(theShape: Triangle): Boolean {
    val (a, b, c) = theShape

    if (a + b == c || b + c == a || a + c == b) { // When the lines a and b make contact, it forms a flat line over c. Invalidate degenerate case.
        return false
    }
    else if (a + b < c || b + c < a || a + c < b) { // No matter the angle, if two lines are in total shorter than the third side,
                                                    // ...the lines never meet. Invalidate imaginary case.
        return false
    }
    else if (a < b + c && b < a + c && c < a + b) { // Sum of any two sides is greater than the third side. Validate triangle.
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

    val s = (a + b + c)/2                                   // Heron's Formula
    val theArea = sqrt(s*((s - a)*(s - b)*(s - c)))

    return theArea
}