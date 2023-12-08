import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day8Test {

    @Test
    fun complex1() {
        val input = listOf(
            "RL",
            "",
            "AAA = (BBB, CCC)",
            "BBB = (DDD, EEE)",
            "CCC = (ZZZ, GGG)",
            "DDD = (DDD, DDD)",
            "EEE = (EEE, EEE)",
            "GGG = (GGG, GGG)",
            "ZZZ = (ZZZ, ZZZ)",
        )

        val result = Day8().countStepsToZZZ(input)
        assertEquals(2, result)
    }

    @Test
    fun complex2() {
        val input = listOf(
            "LLR",
            "",
            "AAA = (BBB, BBB)",
            "BBB = (AAA, ZZZ)",
            "ZZZ = (ZZZ, ZZZ)",
        )

        val result = Day8().countStepsToZZZ(input)
        assertEquals(6, result)
    }
}