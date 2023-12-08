class Day7 {
    data class Data(val deck: String, val value: Long)
    class Hand(private val deck: List<Int>, val value: Long) {

        fun maxOccurrences(): Pair<Int, Int> {
            val occurrencesMap = mutableMapOf<Int, Int>()
            for (i in deck) {
                occurrencesMap.putIfAbsent(i, 0)
                occurrencesMap[i] = occurrencesMap[i]!! + 1
            }
            val mo = occurrencesMap.maxBy { it.value }
            return if(mo.value != 1) {
                mo.toPair()
            } else {
                Pair(maxValueAtPlace(0), 1)
            }
        }

        fun maxValueAtPlace(placeInDeck: Int): Int {
            return deck.sortedDescending()[placeInDeck]
        }

        fun present() {
            println(deck)
        }
    }

    private val cardValues: Map<Char, Int> = mapOf(
        Pair('A', 14),
        Pair('K', 13),
        Pair('Q', 12),
        Pair('J', 11),
        Pair('T', 10),
        Pair('9', 9),
        Pair('8', 8),
        Pair('7', 7),
        Pair('6', 6),
        Pair('5', 5),
        Pair('4', 4),
        Pair('3', 3),
        Pair('2', 2),
    )

    fun calcBidNumber(input: List<String>): Long {
        var result = 0L

        val hands = input.map { line ->
            run {
                val deckAndValueArray = line.split(" ")
                Hand(
                    deckAndValueArray[0].toCharArray().map { c -> cardValues.getValue(c) }.sorted(),
                    deckAndValueArray[1].toLong()
                )
            }
        }

        val occComparator = Comparator<Hand> { deck1, deck2 ->
            val maxOccurrenceDiff = deck1.maxOccurrences().second - deck2.maxOccurrences().second
            if (maxOccurrenceDiff != 0) {
                maxOccurrenceDiff
            } else {
                deck1.maxOccurrences().first - deck2.maxOccurrences().first
            }
        }

        val sorted = hands
            .sortedWith(
                occComparator
//                    .thenComparator { deck1, deck2 -> deck1.maxValueAtPlace(0) - deck2.maxValueAtPlace(0) }
                    .thenComparator { deck1, deck2 -> deck1.maxValueAtPlace(1) - deck2.maxValueAtPlace(1) }
                    .thenComparator { deck1, deck2 -> deck1.maxValueAtPlace(2) - deck2.maxValueAtPlace(2) }
                    .thenComparator { deck1, deck2 -> deck1.maxValueAtPlace(3) - deck2.maxValueAtPlace(3) }
                    .thenComparator { deck1, deck2 -> deck1.maxValueAtPlace(4) - deck2.maxValueAtPlace(4) }
            ).reversed()
        sorted.forEach { d -> d.present() }

        var factor = sorted.size
        for (hand in sorted) {
            result += (hand.value * factor)
            factor -= 1
        }
        return result
    }

    private val handComparator = Comparator<Data> { data1, data2 ->
        val occurrencesMap1 = mutableMapOf<Char, Int>()
        for (c in data1.deck) {
            occurrencesMap1.putIfAbsent(c, 0)
            occurrencesMap1[c] = occurrencesMap1[c]!! + 1
        }
        val occurrencesMap2 = mutableMapOf<Char, Int>()
        for (c in data2.deck) {
            occurrencesMap2.putIfAbsent(c, 0)
            occurrencesMap2[c] = occurrencesMap2[c]!! + 1
        }
        val occ1 = occurrencesMap1.maxBy { it.value }.value
        val occ2 = occurrencesMap2.maxBy { it.value }.value
        occ1 - occ2
    }
}