class CharArrayUtils {

    fun mapFirstAndLastDigitToNumber(input: CharArray): Int {
        val f = input.first { c -> c.isDigit() }.toString()
        val l = input.last { c -> c.isDigit() }.toString()

        val number: String = f + l
        println(number)
        return number.toInt()
    }
}