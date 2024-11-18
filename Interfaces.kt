fun main() {
    val button = Button("Button 1", 50.0)
    button.onClick("Calculate")
    button.calculate(80.0)
}

/*blueprint of the functions to be implemented for each inherited class of ClickEvent */
interface ClickEvent {
    fun onClick(message: String) 
    fun calculate(price: Double)

}

class Button(val label: String, val new_price: Double): ClickEvent {

    override fun onClick(message: String) { 
        println("$label and $message")
    }

    override fun calculate(price: Double) { 
        println("$price and $new_price")
    }

}


