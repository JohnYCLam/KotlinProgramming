fun main() {
    val car_A = Car(color = "Green")
    val car_B = Car(model = "Toyota")

    println("Car A | Color: ${car_A.color} | Model: ${car_A.model} | Safe Speed: ${car_A.safetySpeed(100)}")
    println("Car B | Color: ${car_B.color} | Model: ${car_B.model} | Safe Speed: ${car_B.safetySpeed(100)}")

    val truck = Truck(color = "White", model = "Ford")

    println("Truck | Color: ${truck.color} | Model: ${truck.model} | | Safe Speed: ${truck.safetySpeed(100)}")

    val members = mutableListOf<Person>()

    members.add(Person("John", "Lam", 33))
    members.add(Person("Peter", "Chan", 60))
    members.add(Person("Mary", "Wong", 99))

    members.forEach { println(it.age) }

    println(members)

    /*Generic Class */
    val listOfNames = listOf("Peter", "John", "Amy")
    val finder_str = Finder(listOfNames)
    finder_str.findItem("Peter") { println("Found $it") }

    val listofNumbers = (1..10).toList()
    val finder_int = Finder(listofNumbers)
    finder_int.findItem(11) { println("Found $it") }

    val finder_member = Finder(members)
    finder_member.findItem(Person("Mary", "Wong", 99)) { println("Found $it") }
}

/*open class for inheritance from this class */
open class Car(
    var color: String = "Blue",
    var model: String = "BMW"
) {

    init {
        var color = color
        var model = model
    }

    open fun safetySpeed(maxSpeed: Int): Double {
        return maxSpeed * 0.9
    }
    fun drive() {
        println("Start Driving!")
    }
}

/*sub class of Car */
class Truck(color: String, model: String): Car(color, model) {
    override fun safetySpeed(maxSpeed: Int): Double {
       return maxSpeed * 0.8
    }
}

/*Data Classes: For creating entity, defining structure of data tables, have built in functions  */
data class Person(val firstName: String, val lastName: String, val age: Int)

/*Generic Class: Type can be generic, to be determined when user creates an instance */
class Finder<T>(private val list: List<T>) {
    /* ? means nullable */
    fun findItem(element: T, foundItem: (element: T?) -> Unit) {
        
        val itemFoundList = list.filter { it == element }
        
        if (itemFoundList.isNullOrEmpty()) foundItem(null) 
        else foundItem(itemFoundList.first())
        
    }
    
}