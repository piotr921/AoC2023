import kotlin.streams.toList

class Day1 {
    private val letterNumbers: Map<String, String> = mapOf(
        Pair("one", "1"),
        Pair("two", "2"),
        Pair("three", "3"),
        Pair("four", "4"),
        Pair("five", "5"),
        Pair("six", "6"),
        Pair("seven", "7"),
        Pair("eight", "8"),
        Pair("nine", "9"),
    )

    fun calculateCalibrationValue(input: List<String>): Int =
        input.stream()
            .map { line -> line.toCharArray() }
            .map { ca -> CharArrayUtils().mapToNumberFromFirstAndLastChar(ca) }
            .toList()
            .sum()
}