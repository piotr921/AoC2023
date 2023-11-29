class FileReader {

    fun readAllLines(fileName: String): List<String> = this::class.java.getResourceAsStream(fileName).bufferedReader().readLines()
}