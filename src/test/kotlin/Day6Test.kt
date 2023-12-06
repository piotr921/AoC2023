import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day6Test {

    @Test
    fun calcNumberOfWaysToBreakRecord() {
        val input = listOf(
            "Time:      7  15   30",
            "Distance:  9  40  200"
        )

        val result = Day6().calcNumberOfWaysToBreakRecord(input)
        assertEquals(288, result)
    }

    @Test
    fun calcNumberOfWaysToBreakRecord_p2() {
        val input = listOf(
            "Time:      71530",
            "Distance:  940200"
        )

        val result = Day6().calcNumberOfWaysToBreakRecord(input)
        assertEquals(71503, result)
    }

    @Test
    fun canBeatRecordTest_2() {
        assertFalse(Day6().canBeatRecord(0, 7, 9))
        assertFalse(Day6().canBeatRecord(1, 7, 9))
        assertTrue(Day6().canBeatRecord(2, 7, 9))
        assertTrue(Day6().canBeatRecord(3, 7, 9))
        assertTrue(Day6().canBeatRecord(4, 7, 9))
        assertTrue(Day6().canBeatRecord(5, 7, 9))
        assertFalse(Day6().canBeatRecord(6, 7, 9))
        assertFalse(Day6().canBeatRecord(7, 7, 9))
    }
}