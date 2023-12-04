fun main(args: Array<String>) {
    val fr = FileReader()
    val day4 = Day4()
    println("Hello Advent Of Code 2023!")

    val allLines = fr.readAllLines("4.txt")
    val d4 = day4.calcAmountOfScratchcards(allLines)

    println(d4)
}