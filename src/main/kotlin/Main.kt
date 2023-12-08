fun main(args: Array<String>) {
    val fr = FileReader()
    val day = Day8()
    println("Hello Advent Of Code 2023!")

    val allLines = fr.readAllLines("8.txt")
    val result = day.countStepsToZZZ(allLines)

    println(result)
}