import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day2Test {

    @Test
    fun shouldCalculate() {
        val input = listOf(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green",
            "Game 54: 3 green, 17 red; 7 green, 13 red, 5 blue; 11 blue, 10 red, 10 green; 3 green, 19 red, 4 blue; 11 green, 6 blue, 19 red; 5 red, 4 blue, 9 green",
            "Game 55: 3 blue, 4 red; 1 red, 1 blue, 2 green; 4 blue, 2 green, 4 red"
        )
        val result = Day2().calculate(input)
        assertEquals(63, result)
    }
}