import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test {

    @Test
    fun shouldSplitStringToCharArray() {
        val split = "abc123".toCharArray()
        split contentEquals charArrayOf('a', 'b', 'c', '1', '2', '3')
    }

    @Test
    fun shouldCalcSumOfNumber() {
        val input = listOf("1a2b3c", "45qqq", "rfv09")
        val result = Day1().calculateCalibrationValue(input)
        assertEquals(67, result)
    }

    @Test
    fun shouldReplaceLetterNumbers() {
        val result = Day1().replaceTextWithNumbersInLine("oneabc2deffour")
        assertEquals("1abc2def4", result)

        val result2 = Day1().replaceTextWithNumbersInLine("eightwothree")
        assertEquals("8wo3", result2)

        val result3 = Day1().replaceTextWithNumbersInLine("qd8fourvmvgmssixsix8oneighttps")
        assertEquals("qd84vmvgmssixsix8on8tps", result3)

        val result4 = Day1().replaceTextWithNumbersInLine("onetwoabc2deffour")
        assertEquals("1twoabc2def4", result4)
    }

    @Test
    fun shouldFixAllLinesAndCalculateCalibration() {
        val d1 = Day1()
        val allLines = listOf(
            "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
            "7pqrstsixteen",
            "lpbjvpbtdfvtxtdvkpjs7qrvddkzmjtlqtg",
            "qd8fourvmvgmssixsix8oneighttps"
        )

        val result = d1.fixLines(allLines)
        val number = d1.calculateCalibrationValue(result)
        assertEquals(376, number)
    }
}