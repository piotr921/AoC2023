fun main(args: Array<String>) {
    val fr = FileReader()
    println("Hello Advent Of Code 2023!")

    val allLines = fr.readAllLines("1.txt")
    val result = Day1().calculateCalibrationValue(allLines)
    println(result)
}