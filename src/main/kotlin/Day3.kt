class Day3 {

    val lineLength = 140

    fun calcSumOfEngineParts(input: List<String>): Int {
        return input.stream()
            .map { line -> sumNumberInLine(line) }
            .toList()
            .sum()
//        input.forEachIndexed { index, line ->
//            run {
//                val parts = findNumberInLine(line)
//                println("$index - $line")
//            }
//        }

    }


    private fun sumNumberInLine(line: String): Int {
        val y = line
            .split(".")
            .filter { it != "" && Regex("\\W").containsMatchIn(it) }
            .map {
                if (!it.toCharArray()[0].isDigit()) {
                    it.substring(1)
                } else if (!it.toCharArray()[it.length - 1].isDigit()) {
                    it.substring((0..it.length - 2))
                } else {
                    it.split(Regex("\\W")).sumOf { it.toInt() }.toString()
                }

            }.sumOf {
                if (it != "") {
                    it.toInt()
                } else {
                    0
                }
            }
        return y
    }
}