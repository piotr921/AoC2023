import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day3Test {
    @Test
    fun oneNumberWithSpecialCharAtTheBeginning_shouldReturnNumber() {
        val input = listOf("...#13...")
        val sum = Day3().calcSumOfEngineParts(input)
        assertEquals(13, sum)

        val input2 = listOf("%14.")
        val sum2 = Day3().calcSumOfEngineParts(input2)
        assertEquals(14, sum2)

        val input3 = listOf("...*15")
        val sum3 = Day3().calcSumOfEngineParts(input3)
        assertEquals(15, sum3)
    }

    @Test
    fun oneNumberWithSpecialCharAtTheEnd_shouldReturnNumber() {
        val input = listOf("...13#...")
        val sum = Day3().calcSumOfEngineParts(input)
        assertEquals(13, sum)

        val input2 = listOf("14%.")
        val sum2 = Day3().calcSumOfEngineParts(input2)
        assertEquals(14, sum2)

        val input3 = listOf("...15*")
        val sum3 = Day3().calcSumOfEngineParts(input3)
        assertEquals(15, sum3)
    }

    @Test
    fun twoNumbersInOneLine_shouldReturnSum() {
        val input = listOf("...13#...3*...")
        val sum = Day3().calcSumOfEngineParts(input)
        assertEquals(16, sum)

        val input2 = listOf("14%.%14")
        val sum2 = Day3().calcSumOfEngineParts(input2)
        assertEquals(28, sum2)

        val input3 = listOf("..28*70..")
        val sum3 = Day3().calcSumOfEngineParts(input3)
        assertEquals(98, sum3)
    }

    @Test
    fun onlySpecialChar_shouldReturn0() {
        val input = listOf(".$.*.@.")
        val sum = Day3().calcSumOfEngineParts(input)
        assertEquals(0, sum)
    }

    @Test
    fun onlyNumberWithoutChar_shouldReturn0() {
        val input = listOf("..*..34..")
        val sum = Day3().calcSumOfEngineParts(input)
        assertEquals(0, sum)
    }

    @Test
    fun specialCharInLineBelow_shouldReturnNumber() {
        val input = listOf(
            "21..",
            "#...")
        val sum = Day3().calcSumOfEngineParts(input)
        assertEquals(21, sum)
    }

    @Test
    fun specialCharInLineBelowBeforeNumber_shouldReturnNumber() {
        val input = listOf(
            ".51..",
            "#...")
        val sum = Day3().calcSumOfEngineParts(input)
        assertEquals(51, sum)
    }

    @Test
    fun specialCharInLineBelowAfterNumber_shouldReturnNumber() {
        val input = listOf(
            "59.",
            "..#")
        val sum = Day3().calcSumOfEngineParts(input)
        assertEquals(59, sum)
    }

    @Test
    fun specialCharInLineBelowAndValidNumbersInBothLines_shouldReturnSum() {
        val input = listOf(
            "5..*20..4.",
            ".#.11#....")
        val sum = Day3().calcSumOfEngineParts(input)
        assertEquals(36, sum)
    }
}