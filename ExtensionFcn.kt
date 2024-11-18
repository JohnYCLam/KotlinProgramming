fun main() {
    println("Hello World".append(" This is John"))
    println("Hellow World!".removeLastChar())
}

fun String.append(toAppend: String): String {
    return this.plus(toAppend)
}

fun String.removeLastChar(): String {
    return this.substring(0, this.length - 1)
}