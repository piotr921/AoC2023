package day2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GameFactoryTest {
    @Test
    fun shouldParseLine() {
        val line = "Game 3: 1 green, 2 blue; 7 blue, 4 green; 2 green, 1 blue; 10 blue, 4 green; 4 blue; 1 green, 7 blue, 1 red"
        val game = GameFactory().createGameFromLine(line)

        assertEquals(3, game.id)
        assertEquals(4, game.green)
        assertEquals(10, game.blue)
        assertEquals(1, game.red)
    }
}