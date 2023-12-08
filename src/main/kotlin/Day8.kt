class Day8 {

    fun countStepsToZZZ(input: List<String>): Int {
        var stepCounter = 0
        var nextDestination = "AAA"
        val steps = input[0].toCharArray()
        val map = mapInputDataIntoMap(input)
        nextDestination = selectNextDestination(selectNextStep(steps, stepCounter),  map[nextDestination].orEmpty())

        while (nextDestination != "ZZZ") {
            stepCounter += 1
            nextDestination = selectNextDestination(selectNextStep(steps, stepCounter), map[nextDestination].orEmpty())
        }
        return stepCounter + 1
    }

    private fun selectNextStep(steps: CharArray, stepCounter: Int): Char = steps[stepCounter.mod(steps.size)]

    private fun mapInputDataIntoMap(input: List<String>): Map<String, List<String>> {
        val regex = Regex("\\b\\w+\\b")
        val elements = input.subList(2, input.size)
        val instructions = mutableMapOf<String, List<String>>()
        elements.forEach { e ->
            run {
                val splitted = e.split(" = ")
                val list = regex.findAll(splitted[1])
                    .map { it.value }
                    .toList()
                instructions.putIfAbsent(splitted[0], list)
            }
        }
        return instructions
    }

    private fun selectNextDestination(direction: Char, destinations: List<String>): String {
        return when (direction) {
            'L' -> destinations[0]
            'R' -> destinations[1]
            else -> ""
        }
    }
}