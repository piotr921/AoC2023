class Day3 {

    fun calcSumOfEngineParts(input: List<String>): Int {
        var sum = 0
        input.forEachIndexed { index, line ->
            run {
                val lineBelow = input.getOrElse(index + 1) { "" }
                val lineAbove = input.getOrElse(index - 1) { "" }
                sum += sumNumberInLine(line, lineBelow, lineAbove)
            }
        }
        return sum
    }


    private fun sumNumberInLine(line: String, lineBelow: String, lineAbove: String): Int {
        var index = 0
        return line
            .split(".")
            .filter { it != "" }
            .map { it ->
                if (specialCharIsAtTheBeginning(it)) {
                    index = line.indexOf(it, index) + it.length
                    it.substring(1)
                } else if (specialCharIsAtTheEnd(it)) {
                    index = line.indexOf(it, index) + it.length
                    it.substring((0..it.length - 2))
                } else if (lineBelow != "" && specialCharIsInOtherLine(it, line, lineBelow, index)) {
                    index = line.indexOf(it, index) + it.length
                    it
                } else if (lineAbove != "" && specialCharIsInOtherLine(it, line, lineAbove, index)) {
                    index = line.indexOf(it, index) + it.length
                    it
                } else if (!Regex("\\W").containsMatchIn(it)) {
                    println(it)
                    index = line.indexOf(it, index) + it.length
                    "0"
                } else {
                    index = line.indexOf(it, index) + it.length
                    it.split(Regex("\\W")).sumOf { it.toInt() }.toString()
                }

            }.sumOf { it.takeIf { it.isNotBlank() }?.toInt() ?: 0 }
    }

    private fun specialCharIsInOtherLine(it: String, line: String, lineBelow: String, startIndex: Int): Boolean {
        val numberIndex = line.indexOf(it, startIndex)
        val searchStart = (numberIndex - 1).coerceAtLeast(0)
        val searchEnd = (numberIndex + it.length + 1).coerceAtMost(lineBelow.length)
        val filtered = lineBelow.substring(searchStart, searchEnd).filter { c -> c != '.' }
        return Regex("\\W").containsMatchIn(filtered)
    }

    private fun specialCharIsAtTheEnd(it: String) = !it.toCharArray()[it.length - 1].isDigit()

    private fun specialCharIsAtTheBeginning(it: String) = !it.toCharArray()[0].isDigit()
}