
import java.io.IOException
import Failure 

fun main() {

    Repository.startFetch()
    getResult(Repository.getCurrentState())
    Repository.finishedFetch()
    getResult(Repository.getCurrentState())
    Repository.error()
    getResult(Repository.getCurrentState())
    Repository.customFailure()
    getResult(Repository.getCurrentState())
    Repository.anotherCustomerFailure()
    getResult(Repository.getCurrentState())
}

fun getResult(result: Result) {
    return when(result) {
        is Success -> println(result.dataFetched?: "Ensure you start fetch function!")
        is Error -> println("Unknown Error! ${result.exception.toString()}")
        is IDLE -> println("IDLE ...")
        is Loading -> println("Please wait while loading ...")

        /*after adding another sealed subclasss, need to list out the new cases */
        is Failure.CustomFailure -> {println(result.customFailure.toString())}
        is Failure.AnotherCustomerFailure -> {println(result.anotherCustomFailure.toString())}
        /*No need else as sealed class is exhaustive */
        /*else -> println("N/A") */
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

    fun customFailure() {
        loadState = Failure.CustomFailure(IOException("IOE Something Wrong"))
    }

    fun anotherCustomerFailure() {
        loadState = Failure.AnotherCustomerFailure(NullPointerException("Null Point Something Wrong"))
    }
}

/*States as sub class of Result */
/*sealed class is also an abstract class */
sealed class Result
/*attach value to the state */
data class Success(val dataFetched: String?): Result() 
data class Error(val exception: Exception): Result() 
/*use object if not to assign value */
object IDLE: Result() 
object Loading: Result() 

/*create a sealed subclass of Result*/
sealed class Failure: Result() {
    data class CustomFailure(val customFailure: IOException): Failure()
    data class AnotherCustomerFailure(val anotherCustomFailure: NullPointerException): Failure()
}