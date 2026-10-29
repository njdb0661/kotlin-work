// COMP2850 Portfolio: Week 4
// Triangle class

import kotlin.math.sqrt

// Add isValidTriangle() and triangleArea() functions here

fun isValidTriangle(a: Double, b: Double, c: Double): Boolean {

    if (a + b == c || b + c == a || a + c == b) { // Flat Line
        return false
    }
    else if (a + b < c || b + c < a || a + c < b) { // Never Touch
        return false
    }
    else if (a < b + c && b < a + c && c < a + b) { 
        return true
    }
    else {
        return false
    }
}

fun triangleArea(a: Double, b: Double, c: Double): Double {

    if (isValidTriangle(a, b, c) == false) {
        throw IllegalArgumentException("Invalid Triangle")
    }

    val s = (a + b + c)/2                                   // Heron's Formula
    val theArea = sqrt(s*((s - a)*(s - b)*(s - c)))

    return theArea
}

class Triangle(val sideA: Double, val sideB: Double, val sideC: Double) {
    init {
        require(isValidTriangle(sideA, sideB, sideC))
    }

    // Attributes
    val perimeter = sideA + sideB + sideC
    val semiPerimeter = perimeter / 2.0
    val area = triangleArea(sideA, sideB, sideC)

    // Methods
    override fun toString() : String {
        return "Triangle($sideA, $sideB, $sideC)"
    }
}