fun main(args: Array<String>) {
    val fr = FileReader()
    val day = Day6()
    println("Hello Advent Of Code 2023!")

    val allLines = fr.readAllLines("6-2.txt")
    val result = day.calcNumberOfWaysToBreakRecord(allLines)

    println(result)
}