class CharArrayUtils {

    fun mapToNumberFromFirstAndLastChar(input: CharArray): Int {
        val f = input.first { c -> c.isDigit() }.toString()
        val l = input.last { c -> c.isDigit() }.toString()
        val number = f + l
        return number.toInt()
    }
}