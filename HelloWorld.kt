fun main() {
    /*val and var */
    val myName: String
    var age: Int = 30

    myName = "John"
    age = age + 1

    println("Hello. My name is $myName, and I am $age years old.")

    val amount = 10000

    /* if else */
    if (amount < 20000) {
        println("Line 1")
    } else {
        println("Line 2")
    }

    /*when */
    when (amount) {
        in 1..10000 -> println("Line 3")
        !in 50..100 ->println("Line 4")
        else -> {
            println("Line 5")
        }
    }
    
    /*for loop */
    for (i in 1..6) {

        if (i % 3 == 0) {
            println(i)
        }
    }
}
