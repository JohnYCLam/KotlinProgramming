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
        Result.SUCCESS -> println("Completed Successfully!")
        Result.ERROR -> println("Unknown Error!")
        Result.IDLE -> println("IDLE ...")
        Result.LOADING -> println("Please wait while loading ...")
    }
}

/*object is a Singleton, i.e. it is a class with only one (unique) instance  */
object Repository {
    private var loadState: Result = Result.IDLE
    private var dataFetched: String? = null

    fun startFetch() {
        loadState = Result.LOADING
        dataFetched = "Data"
    }

    fun finishedFetch() {
        loadState = Result.SUCCESS
        dataFetched = null
    }

    fun error() {
        loadState = Result.ERROR
    }

    fun getCurrentState(): Result {
        return loadState
    }
}

/*enum class: a finite set of constants */
enum class Result {
    SUCCESS,
    ERROR,
    IDLE,
    LOADING
}

