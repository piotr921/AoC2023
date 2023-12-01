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

    fun replaceTextWithNumbersInLine(line: String): String {
        var result = line
        val firstNumber = result.findAnyOf(letterNumbers.keys)
        if (firstNumber != null) {
            val replacement = letterNumbers[firstNumber.second]
            if (replacement != null) {
                result = result.replaceRange(
                    firstNumber.first,
                    firstNumber.first + firstNumber.second.length,
                    replacement.toString()
                )
            }
        }

        val lastNumber = result.findLastAnyOf(letterNumbers.keys)
        if (lastNumber != null) {
            val replacement = letterNumbers[lastNumber.second]

            if (replacement != null) {
                result = result.replaceRange(
                    lastNumber.first,
                    lastNumber.first + lastNumber.second.length,
                    replacement.toString()
                )
            }
        }
        return result
    }

    fun fixLines(allLines: List<String>): List<String> {
        return allLines.stream().map { l -> replaceTextWithNumbersInLine(l) }.toList()
    }
}