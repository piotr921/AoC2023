fun main(args: Array<String>) {
    val fr = FileReader()
    println("Hello Advent Of Code 2023!")
    val allLines = fr.readAllLines("test-data.txt")
    println(allLines[0] + allLines[5])
}