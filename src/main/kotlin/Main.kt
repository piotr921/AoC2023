fun main(args: Array<String>) {
    val fr = FileReader()
    val day2 = Day2()
    println("Hello Advent Of Code 2023!")

    val allLines = fr.readAllLines("2.txt")
    val d2 = day2.calculate(allLines)

    // 224 - your answer is too low
    println(d2)

}