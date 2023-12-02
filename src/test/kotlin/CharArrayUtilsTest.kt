import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CharArrayUtilsTest {

    @Test
    fun shouldFindLastNumberInCharArray() {
        val data = "abc123".toCharArray()
        val last = data.last { c -> c.isDigit() }
        assertEquals('3', last)
    }

    @Test
    fun shouldFindFirstNumberInCharArray() {
        val data = "abc123".toCharArray()
        val last = data.first { c -> c.isDigit() }
        assertEquals('1', last)
    }

    @Test
    fun shouldFindLastText() {
        println("abc123four".lastIndexOf("four"))
    }

    @Test
    fun shouldBuildNumberFromTwoChars() {
        assertEquals("78", '7'.toString() + '8'.toString())
    }

    @Test
    fun shouldBuildNumberFromCharArrayFirstAndLastDigit() {
        val cau = CharArrayUtils()
        val number = cau.mapFirstAndLastDigitToNumber("abc123".toCharArray())
        assertEquals(13, number)

        val n2 = cau.mapFirstAndLastDigitToNumber("lpbjvpbtdfvtxtdvkpjs7qrvddkzmjtlqtg".toCharArray())
        assertEquals(77, n2)

        val n3 = cau.mapFirstAndLastDigitToNumber("qd84vmvgmssixsix8on8tps".toCharArray())
        assertEquals(88, n3)
    }
}