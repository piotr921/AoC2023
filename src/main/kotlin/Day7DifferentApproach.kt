class Day7DifferentApproach {
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

    class Hand(private val cards: List<Int>, val value: Long) {

        fun isFiveOfAKind(): Boolean {
            return cards.groupBy { it }.any { it.value.size == 5 }
        }

        fun isFourOfAKind(): Boolean {
            return cards.groupBy { it }.any { it.value.size == 4 }
        }

        fun isFullHouse(): Boolean {
            val groupedByRank = cards.groupBy { it }
            return groupedByRank.any { it.value.size == 3 } && groupedByRank.any { it.value.size == 2 }
        }

        fun isThreeOfAKind(): Boolean {
            return cards.groupBy { it }.any { it.value.size == 3 }
        }

        fun isTwoPair(): Boolean {
            val groupedByRank = cards.groupBy { it }
            return groupedByRank.count { it.value.size == 2 } == 2
        }

        fun isOnePair(): Boolean {
            return cards.groupBy { it }.any { it.value.size == 2 }
        }

        fun highCardAtIndex(index: Int): Int {
            return cards[index]
        }

        fun present() {
            println(cards)
        }
    }

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
//        val sorted = hands.sortedWith()
//        sorted.forEach { d -> d.present() }
//
//        var factor = sorted.size
//        for (hand in sorted) {
//            result += (hand.value * factor)
//            factor -= 1
//        }
        return result
    }
}