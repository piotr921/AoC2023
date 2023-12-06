class StringUtils {

    fun toListOfInt(input: String): List<Int> {
        return input.split(" ").filter { s -> s != "" }.map { s -> s.toInt() }
    }

    fun toListOfLong(input: String): List<Long> {
        return input.split(" ").filter { s -> s != "" }.map { s -> s.toLong() }
    }
}