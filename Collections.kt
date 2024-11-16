fun main() {
    val immutableList = listOf("Alpha", "Beta", "Gamma")

    val mutableList = mutableListOf("Alpha", "Beta", "Gamma")

    mutableList.add("Zeta")
    mutableList.remove("Alpha") /*or mutableList.removeAt(index position) */

    /*loop through elements */
    for (item in mutableList) {
        println(item)
    }
    /*same as */
    mutableList.forEach {
        println(it)
    }

    /*other methods of list */
    println("Number of elements: ${mutableList.size}")
    println("Second element: ${mutableList[1]}")
    println("Index of the element \"Gamma\": ${mutableList.indexOf("Gamma")}")

    /*Sets: Unique elements, no ordering */
    val immutableSet = setOf(1,2,3,4,5)

    val mutableSet = mutableSetOf(1, 2, 3, 4, 5)

    mutableSet.add(6)
    mutableSet.remove(1)
    println(mutableSet)

    /*Map (dictionary in Python) */
    val immutableMap = mapOf("Up" to 0, "Down" to 1, "Left" to 2, "Right" to 3)

    val mutableMap = mutableMapOf("Up" to 0, "Down" to 1, "Left" to 2, "Right" to 3)

    /*Map operation */
    mutableMap.forEach{println(it.key)}
    mutableMap.keys.forEach{println(it)}
    mutableMap.forEach{println(it.value)}
    mutableMap.values.forEach { if (it%2 == 0) {println(it)} }

    val check_key = "Up"
    if (check_key in mutableMap.keys) {println("\"$check_key\" is in the map keys.")}

    mutableMap["Middle"] = 4

    mutableMap.forEach{println("${it.key} : ${it.value}")}

    mutableMap.remove("Up")

    mutableMap.forEach{println("${it.key} : ${it.value}")}

    /*Initialize a list */
    val newList = mutableListOf<Int>()

    for (i in 1..11 step 2) {
        newList.add(i)
    }
    println("newList: $newList")
    
    /*create empty list, set, map which are immutable. for returning corresponding empty types rather than null */
    val emptyList = emptyList<String>()
    val emptyset = emptySet<String>()
    val emptyMap = emptyMap<String, Int>()

    /*filtering */
    val filteredList = mutableList.filter { it.startsWith("a", ignoreCase = true) || it.endsWith("a")}
    println(filteredList)
    
}