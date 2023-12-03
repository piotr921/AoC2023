class Day3 {

    val lineLength = 140

    fun calcSumOfEngineParts(input: List<String>): Int {
        var sum = 0
        input.forEachIndexed { index, line ->
            run {
                var lineBelow = "";
                if (index + 1 <= input.size - 1) {
                    lineBelow = input[index + 1]
                }
                sum += sumNumberInLine(line, lineBelow)
            }
        }
        return sum
    }


    private fun sumNumberInLine(line: String, lineBelow: String): Int {
        val y = line
            .split(".")
            .filter { it != "" }
            .map { it ->
                if (specialCharIsAtTheBeginning(it)) {
                    it.substring(1)
                } else if (specialCharIsAtTheEnd(it)) {
                    it.substring((0..it.length - 2))
                } else if (lineBelow != "" && specialCharIsInLineBelow(it, line, lineBelow)) {
                    it
                } else if (specialCharIsInLineAbove(it)) {
                    it
                } else if (!Regex("\\W").containsMatchIn(it)) {
                    "0"
                } else {
                    it.split(Regex("\\W")).sumOf { it.toInt() }.toString()
                }

            }.sumOf { it.takeIf { it.isNotBlank() }?.toInt() ?: 0 }
        return y
    }

    private fun specialCharIsInLineBelow(it: String, line: String, lineBelow: String): Boolean {
        val numberIndex = line.indexOf(it)
        val searchStart = (numberIndex - 1).coerceAtLeast(0)
        val searchEnd = (numberIndex + it.length + 1).coerceAtMost(lineBelow.length)
        val filtered = lineBelow.substring(searchStart, searchEnd).filter { c -> c != '.' }
        return Regex("\\W").containsMatchIn(filtered)
    }

    private fun specialCharIsInLineAbove(it: String): Boolean {
        return false
    }

    private fun specialCharIsAtTheEnd(it: String) = !it.toCharArray()[it.length - 1].isDigit()

    private fun specialCharIsAtTheBeginning(it: String) = !it.toCharArray()[0].isDigit()
}