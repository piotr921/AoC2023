import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ListTest {

    @Test
    fun shouldFindInRange() {
        val l = listOf(49, 53, 8)
        assertTrue((l[1]..<l[1] + l[2]).contains(53))

        val l2 = listOf(0, 11, 42)
        assertFalse((l2[1]..<l2[1] + l2[2]).contains(53))
    }

    @Test
    fun findTest() {
        val input = listOf(
            listOf(49, 53, 8),
            listOf(0, 11, 42)
        )

        val output = input
            .find { mappingList -> (mappingList[1]..<mappingList[1] + mappingList[2]).contains(53) }
            .orEmpty()

        assertEquals(listOf(49, 53, 8), output)
    }

    @Test
    fun splitTest() {
        val size = 7
        val input = (1..size)
        val result = input.partition { it <= size / 2 }

        println(input)
//        result.forEach { l -> println(l) }
        println(result.first)
        println(result.second)
    }
}