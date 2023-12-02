import day2.Game
import day2.GameFactory

class Day2 {

    fun calculate(input: List<String>): Int {
        val list = input.stream()
            .map { line -> GameFactory().createGameFromLine(line) }
            .filter { game -> isPossible(game) }
            .map { game -> game.id }
            .toList()

        println(list)
        return list.sum()
    }

    fun calculatePart2(input: List<String>): Int {
        return input.stream()
            .map { line -> GameFactory().createGameFromLine(line) }
            .map { game -> game.red * game.green * game.blue }
            .toList()
            .sum()
    }

    //  only 12 red cubes, 13 green cubes, and 14 blue cubes
    private fun isPossible(game: Game): Boolean {
        var possible = true
        if (game.red > 12 || game.green > 13 || game.blue > 14) {
            possible = false
        }
        return possible
    }
}