import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day7Test {

    @Test
    fun shouldFindHigherCard() {
        val input = listOf(
            "23456 23",
            "34567 34",
            "23459 29"
        )

        val result = Day7DifferentApproach().calcBidNumber(input)
        assertEquals(29 * 3 + 34 * 2 + 23, result)
    }

    @Test
    fun shouldFindHigherCardWithLetterMark() {
        val input = listOf(
            "2345K 22",
            "3456Q 33",
            "2345A 11"
        )

        val result = Day7DifferentApproach().calcBidNumber(input)
        assertEquals(11 * 3 + 22 * 2 + 33, result)
    }

    @Test
    fun shouldFindHigherCardOnSecondPlace() {
        val input = listOf(
            "7234Q 29",
            "3645Q 25",
            "2345Q 20"
        )

        val result = Day7DifferentApproach().calcBidNumber(input)
        assertEquals(29 * 3 + 25 * 2 + 20, result)
    }

    @Test
    fun shouldFindHigherCardOnThirdPlace() {
        val input = listOf(
            "AKT56 9",
            "AKJ47 4",
            "AK38Q 12"
        )

        val result = Day7DifferentApproach().calcBidNumber(input)
        assertEquals(12 * 3 + 4 * 2 + 9, result)
    }

    @Test
    fun shouldFindHigherCardOnFourthPlace() {
        val input = listOf(
            "AKQT7 83",
            "AKQJ3 28",
            "AKQ98 38"
        )

        val result = Day7DifferentApproach().calcBidNumber(input)
        assertEquals(28 * 3 + 83 * 2 + 38, result)
    }

    @Test
    fun shouldFindHigherCardOnFifthPlace() {
        val input = listOf(
            "AKQJ7 7",
            "AKQJ3 3",
            "AKQJ8 8"
        )

        val result = Day7DifferentApproach().calcBidNumber(input)
        assertEquals(8 * 3 + 7 * 2 + 3, result)
    }

    @Test
    fun pairShouldBeHigherThanSingleCard() {
        val input = listOf(
            "22456 23",
            "34567 34",
            "23459 29"
        )

        val result = Day7DifferentApproach().calcBidNumber(input)
        assertEquals(23 * 3 + 29 * 2 + 34, result)
    }

    @Test
    fun whenPairIsTheSameHigherNumberShouldCount() {
        val input = listOf(
            "33456 56",
            "56733 72",
            "23354 12"
        )

        val result = Day7DifferentApproach().calcBidNumber(input)
        assertEquals(72 * 3 + 56 * 2 + 12, result)
    }

    @Test
    fun higherPairShouldCount() {
        val input = listOf(
            "26968 68",
            "72347 47",
            "28584 84"
        )

        val result = Day7DifferentApproach().calcBidNumber(input)
        assertEquals(84 * 3 + 47 * 2 + 68, result)
    }

    @Test
    fun twoPairsShouldBeHigherThanOne() {
        val input = listOf(
            "22334 22",
            "88567 88",
            "QQ345 45"
        )

        val result = Day7DifferentApproach().calcBidNumber(input)
        assertEquals(22 * 3 + 45 * 2 + 88, result)
    }

//    @Test
//    fun complexTest() {
//        val input = listOf(
//            "32T3K 765",
//            "T55J5 684",
//            "KK677 28",
//            "KTJJT 220",
//            "QQQJA 483",
//
//            )
//
//        val result = Day7DifferentApproach().calcBidNumber(input)
//        assertEquals(6440, result)
//    }
//
//    @Test
//    fun `when thenComparator function used then list sorted correctly`() {
//        data class Person(val name: String, val age: Int)
//
//        val people = listOf(Person("Bobso", 29), Person("Alice", 29))
//        val combinedComparator =
//            compareBy(Person::age).thenComparator { person1, person2 -> person1.name.length - person2.name.length }
//        val sortedPeople = people.sortedWith(combinedComparator)
//        assertIterableEquals(listOf(Person("Bobso", 29), Person("Alice", 29)), sortedPeople)
//    }
//
//    @Test
//    fun `thenComparator function used for cards`() {
//        data class Data(val deck: String, val value: Int)
//
//        val hands = listOf(
//            Data(deck = "KK677", value = 28), Data(deck = "KTJJT", value = 220)
//        )
//
//        val handComparator = Comparator<Data> { data1, data2 ->
//            val occurrencesMap1 = mutableMapOf<Char, Int>()
//            for (c in data1.deck) {
//                occurrencesMap1.putIfAbsent(c, 0)
//                occurrencesMap1[c] = occurrencesMap1[c]!! + 1
//            }
//            val occurrencesMap2 = mutableMapOf<Char, Int>()
//            for (c in data2.deck) {
//                occurrencesMap2.putIfAbsent(c, 0)
//                occurrencesMap2[c] = occurrencesMap2[c]!! + 1
//            }
//
//            if (occurrencesMap1.maxBy { it.value }.value - occurrencesMap2.maxBy { it.value }.value != 0) {
//                occurrencesMap1.maxBy { it.value }.value - occurrencesMap2.maxBy { it.value }.value
//            } else {
//                -1
//            }
//        }
//
////        val combinedComparator = compareBy(Data::value).thenComparator { person1, person2 -> person1.deck.length - person2.deck.length }
//        val sortedPeople = hands.sortedWith(handComparator).reversed()
//
//        assertIterableEquals(
//            listOf(Data(deck = "KTJJT", value = 220), Data(deck = "KK677", value = 28)), sortedPeople
//        )
//    }
}