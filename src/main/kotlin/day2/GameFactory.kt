package day2

class GameFactory {

    fun createGameFromLine(line: String): Game {
        val idAndBody = line.split(":")
        val idParts = idAndBody[0].split(" ")
        val games = idAndBody[1].split(";")

        var greenAmount = 0
        var blueAmount = 0
        var redAmount = 0

        for (game in games) {
            val throws = game.split(",")
            for(th in throws) {
                val throwTrimmed = th.trim()
                val cubes = throwTrimmed.split(" ")
                when(cubes[1]) {
                    "green" -> greenAmount = selectBigger(greenAmount, cubes[0].toInt())
                    "red" -> redAmount = selectBigger(redAmount, cubes[0].toInt())
                    "blue" -> blueAmount = selectBigger(blueAmount, cubes[0].toInt())
                    else -> throw RuntimeException(cubes[1] + " unknown")
                }
            }
        }
        return Game(idParts[1].toInt(), redAmount, greenAmount, blueAmount)
    }

    private fun selectBigger(current: Int, newValue: Int) : Int {
        return if (newValue > current) {
            newValue
        } else {
            current;
        }
    }
}
