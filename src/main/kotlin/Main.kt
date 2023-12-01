fun main(args: Array<String>) {
    val fr = FileReader()
    val day1 = Day1()
    println("Hello Advent Of Code 2023!")

    val allLines = fr.readAllLines("1.txt")

    // Part 1
//    val result = day1.calculateCalibrationValue(allLines)
//    println(result)

    // Part 2
    val allLines2 = day1.fixLines(allLines)
    val result2 = day1.calculateCalibrationValue(allLines2)

    // 55431 too high
    // 47191 -> wrong
    // 47248 -> wrong
    // 52418 -> wrong
    println(result2)
}