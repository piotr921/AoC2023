class CharArrayUtils {

    fun mapToNumberFromFirstAndLastChar(input: CharArray): Int {
        val f = input.first { c -> c.isDigit() }
        val l = input.last { c -> c.isDigit() }

        val number: String =
            if (input.indexOf(f) != input.indexOf(l)) {
                f.toString() + l.toString()
            } else {
                f.toString()
            }
        println(number)
        return number.toInt()
    }
}