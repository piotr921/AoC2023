import kotlin.test.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class StringUtilsTest {

    @Test
    fun shouldReplaceTextWithNumber() {
        val updated = "1abcthree".replace("three", "3")
        assertEquals("1abc3", updated)
    }

    @Test
    fun shouldFindIndexOfString() {
        val result = "eightwothree".findAnyOf(setOf("one", "two", "three", "four", "eight"))
        assertEquals("eight", result!!.second)

        val result2 = "5sjnnfivefourzxxfpfivenine7five".findAnyOf(setOf("one", "two", "three", "four", "five", "eight"))
        assertEquals("five", result2!!.second)

        val result3 = "5sjnnfivefourzxxfpfivenine7five".findLastAnyOf(setOf("one", "two", "three", "four", "five", "eight"))
        assertEquals("five", result3!!.second)
    }

    @Test
    fun shouldReplaceLastTextWithNumber() {
        val s = "three1abcthree"
        val updated = s.findLastAnyOf(setOf("one", "two", "three"))
        val res = s.replaceRange(updated!!.first, updated.first + "three".length, "3")
        assertEquals("three1abc3", res)
    }

    @Test
    fun shouldSplit() {
       assertEquals("26", "23*3".split(Regex("\\W")).sumOf { it.toInt() }.toString())
       assertEquals("23", "23".split(Regex("\\W")).sumOf { it.toInt() }.toString())
    }

    @Test
    fun shouldCheckByRegex() {
        assertEquals(false, Regex("\\W").containsMatchIn("2356"))
        assertEquals(true, Regex("\\W").containsMatchIn("$2356"))
    }
}