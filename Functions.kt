
fun main () {
    println(calculatePriceFloat(100.0f, 0.2f))

    println(calculatePriceDouble(100.0, 0.2))

    println("Higher than threshold? ${checkThreshold(50.0, 20.0)}")

    println(concatString("John", "Lam"))

    println("Area of Circle with radius 2 is ${calculateCircleArea(2.0)}")

    printCircleArea(2.0)

    trailingFun("Good Morning, ") {
        print(it)
        calculatePriceDouble(20.0, 0.3)
    }
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

/* Create a Lambda 
format: val variable/lambda name: (input types) -> output types = {input parameters -> codes}
*/
val concatString: (String, String) -> String = {
    a, b -> a + " " + b
}

/*
Create a lambda
for single input, can use the keyword "it" to represent input
*/
val calculateCircleArea: (Double) -> Double = {
    it -> 3.1415926 * it * it
}

/* Create a lambda without return, i.e. Unit/ Void */
val printCircleArea: (Double) -> Unit = {
    println(3.1415926 * it * it)
}

/* Create a trailing lambda, i.e. last parameter of a function is a function parameter
this function parameter can be written outside the (), i.e. inside {}
*/
fun trailingFun(message: String, funAsParameter: (String) -> Float) {
    println("$message ${funAsParameter(message)}")
}