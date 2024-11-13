
fun main () {
    println(calculatePriceFloat(100.0f, 0.2f))

    println(calculatePriceDouble(100.0, 0.2))

    println("Higher than threshold? ${checkThreshold(50.0, 20.0)}")
}

/* Create a function with float parameter
    input must be tagged with f
*/
fun calculatePriceFloat(price: Float, discount: Float): Float {
    return price * (1 - discount)
}

/* Create a function with double parameter
without toFloat() will cause error as the return type is Float
input must have decimal places. Otherwise it will be treated as integer and cause error
*/
fun calculatePriceDouble(price: Double, discount: Double): Float {
    return (price * (1 - discount)).toFloat()
}

/* Create a function returning Boolean */
fun checkThreshold(price: Double, threshold: Double): Boolean {
    return price > threshold
}