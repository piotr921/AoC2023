import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assumptions
import org.junit.jupiter.api.Test

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
}