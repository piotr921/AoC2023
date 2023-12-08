import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

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

    @Test
    fun asteriskRegexTest() {
        val regex = Regex("""(\d+)\s*\*\s*(\d+)""")
        val matchResult = regex.find("...11*11...12*12...")
        val result = matchResult?.let {
            val (before, after) = it.destructured
            before.toInt() * after.toInt()
        }
        assertEquals(121, result)
    }

    @Test
    fun shouldFindNumberAroundAsterisk() {
        assertEquals(69, listOf("23*3".substring(0, 2), "23*3".substring(3))
            .flatMap { s ->
                s.split(".").filter { c -> c != "" }
            }
            .map { s -> s.toInt() }
            .fold(1) { acc, element -> acc * element })
    }

    @Test
    fun shouldMapDirections() {
        val s = "FQN = (LRB, FNR)"
        val regex = Regex("\\b\\w+\\b")
        val instructions = mutableMapOf<String, List<String>>()

        val updated = s.split(" = ")
        val list = regex.findAll(updated[1])
            .map { it.value }
            .toList()
        instructions.putIfAbsent(updated[0], list)
        println(instructions)
    }
}