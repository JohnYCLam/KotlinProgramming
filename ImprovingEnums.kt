fun main() {

    Repository.startFetch()
    getResult(Repository.getCurrentState())
    Repository.finishedFetch()
    getResult(Repository.getCurrentState())
    Repository.error()
    getResult(Repository.getCurrentState())

}

fun getResult(result: Result) {
    return when(result) {
        is Success -> println(result.dataFetched?: "Ensure you start fetch function!")
        is Error -> println("Unknown Error! ${result.exception.toString()}")
        is IDLE -> println("IDLE ...")
        is Loading -> println("Please wait while loading ...")

        /* Need else statement as it is expected to have a lot of sub classes under Result */
        else -> println("N/A")
    }
}

/*object is a Singleton, i.e. it is a class with only one (unique) instance  */
object Repository {
    private var loadState: Result = IDLE
    private var dataFetched: String? = null

    fun startFetch() {
        loadState = Loading
        dataFetched = "Data"
    }

    fun finishedFetch() {
        loadState = Success(dataFetched)
        dataFetched = null
    }

    fun error() {
        loadState = Error(Exception("Exception!"))
    }

    fun getCurrentState(): Result {
        return loadState
    }
}

/*States as sub class of Result */
abstract class Result
/*attach value to the state */
data class Success(val dataFetched: String?): Result() 
data class Error(val exception: Exception): Result() 
/*use object if not to assign value */
object IDLE: Result() 
object Loading: Result() 