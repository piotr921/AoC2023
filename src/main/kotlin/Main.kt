fun main(args: Array<String>) {
    val fr = FileReader()
    val day5 = Day5()
    println("Hello Advent Of Code 2023!")

    val allLines = fr.readAllLines("5.txt")
    val d5 = day5.findClosestLocation(allLines)

    println(d5)
}