// Task 7.7.1: statistics functions

fun median(numbers: List<Double>): Double {
    val sorted = numbers.sorted()
    var theMedian = 0.0

    if (numbers.size % 2 == 0) {
        theMedian = (sorted[numbers.size / 2] + sorted[(numbers.size / 2) - 1]) / 2.0
    }
    else {
        theMedian = sorted[numbers.size / 2]
    }

    return theMedian
}