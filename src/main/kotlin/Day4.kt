class Day4 {

    fun calcAmountOfScratchcards(input: List<String>): Int {
        val emptyMutableMap = mutableMapOf<Int, Int>()
        emptyMutableMap[0] = 1
        val initialCards = input.size
        var cardNumber = 0
        while (cardNumber < initialCards) {
            (1..emptyMutableMap.getOrDefault(cardNumber, 1)).forEach { it ->
               println("card number $cardNumber #$it")
                val result = countWinningNumbersInLine(input[cardNumber])
                (cardNumber..cardNumber + result).forEach { card ->
                    val noOfCards = emptyMutableMap.getOrDefault(card, 1)
                    emptyMutableMap[card] = noOfCards + 1
                }
            }
            cardNumber += 1
        }
        return emptyMutableMap.values.stream().toList().sum() / 2
    }

    private fun countWinningNumbersInLine(line: String): Int {
        val numbers = line.split("|")
        val winningNumbers = mapToNumbers(numbers[0].split(":")[1])
        val userNumbers = mapToNumbers(numbers[1])
        var result = 0
        for (wn in winningNumbers) {
            if (userNumbers.contains(wn)) {
                result += 1
            }
        }
        return result
    }

    fun calcWinningNumbers(input: List<String>): Int {
        return input.sumOf { line -> findWinningNumbersInLine(line) }
    }

    private fun findWinningNumbersInLine(line: String): Int {
        val numbers = line.split("|")
        val winningNumbers = mapToNumbers(numbers[0].split(":")[1])
        val userNumbers = mapToNumbers(numbers[1])

        var result = 0
        for (wn in winningNumbers) {
            if (userNumbers.contains(wn)) {
                result = if (result == 0) 1 else result * 2
            }
        }

        return result
    }

    private fun mapToNumbers(numbers: String): List<Int> {
        return numbers.trim()
            .split(" ")
            .filter { s -> s != "" }
            .map { s -> s.toInt() }
    }
}