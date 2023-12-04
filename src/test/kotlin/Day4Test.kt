import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day4Test {

    @Test
    fun oneWinningNumber_shouldFindIt_andReturn1() {
        val input = listOf("Card   1: 58 68  1 21 88 | 21")
        val sum = Day4().calcWinningNumbers(input)
        assertEquals(1, sum)
    }

    @Test
    fun twoWinningNumbers_shouldFindThem_andReturn2() {
        val input = listOf("Card   1: 58 68  1 21 88 | 21 1")
        val sum = Day4().calcWinningNumbers(input)
        assertEquals(2, sum)
    }

    @Test
    fun threeWinningNumbers_shouldFindThem_andReturn4() {
        val input = listOf("Card   1: 58 68  1 21 88 | 21 1 58")
        val sum = Day4().calcWinningNumbers(input)
        assertEquals(4, sum)
    }

    @Test
    fun notWinningNumbersShouldNotBeCount() {
        val input = listOf("Card   1: 58 68  1 21 88 | 21 1 34")
        val sum = Day4().calcWinningNumbers(input)
        assertEquals(2, sum)
    }

    @Test
    fun complexTest() {
        val input = listOf(
            "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53",
            "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19",
            "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1",
            "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83",
            "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36",
            "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11",
        )
        val sum = Day4().calcWinningNumbers(input)
        assertEquals(13, sum)
    }

    // part 2
    @Test
    fun oneCardWithNoWinningNumbers_shouldReturn1() {
        val input = listOf("Card   1: 58 68  1 21 88 | 44 55 66 77")
        val sum = Day4().calcAmountOfScratchcards(input)
        assertEquals(1, sum)
    }

    @Test
    fun oneCardWithWinningNumber_secondCardWithNoWinners_shouldReturn3() {
        val input = listOf(
            "Card   1: 58 68  1 21 88 | 44 55 68 77",
            "Card   2: 58 68  1 21 88 | 44 55 66 77"
        )
        val sum = Day4().calcAmountOfScratchcards(input)
        assertEquals(3, sum)
    }

    @Test
    fun oneCardWithTwoWinningNumbers_secondCardWithOneWinner_shouldReturn4() {
        val input = listOf(
            "Card   1: 58 68  1 21 88 | 44 55 68 88", // 1
            "Card   2: 58 68  1 21 88 | 44 55 66 88", // 2
            "Card   3: 58 68  1 21 88 | 44 55 66 77", // 4
        )
        val sum = Day4().calcAmountOfScratchcards(input)
        assertEquals(7, sum)
    }

    @Test
    fun part2_complexTest() {
        val input = listOf(
        "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53", // 1
        "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19", // 2
        "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1", // 4
        "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83", // 8
        "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36", // 14
        "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11", // 1
        )
        val sum = Day4().calcAmountOfScratchcards(input)
        assertEquals(30, sum)
    }
}