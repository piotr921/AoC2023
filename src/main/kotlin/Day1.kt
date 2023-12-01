class Day1 {

    fun calculateCalibrationValue(input: List<String>): Int =
        input.stream()
            .map { line -> line.toCharArray() }
            .map { ca ->  CharArrayUtils().mapToNumberFromFirstAndLastChar(ca)}
            .toList()
            .sum()
}