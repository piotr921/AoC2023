fun main(args: Array<String>) {
    val fr = FileReader()
    val day3 = Day3()
    println("Hello Advent Of Code 2023!")

    val allLines = fr.readAllLines("3.txt")
    val d3 = day3.calcSumOfEngineParts(allLines)

    // 539221 - your answer is too low.
    // 540025
    println(d3)

}