class Day6 {

    fun calcNumberOfWaysToBreakRecord(input: List<String>): Long {
        val times = StringUtils().toListOfLong(input[0].replace("Time:", ""))
        val distances = StringUtils().toListOfLong(input[1].replace("Distance:", ""))

        var result = 1L
        times.forEachIndexed { index, time ->
            val recordToBeat = distances[index]
            val range = (1..time)
            val lastWinningTime = range.findLast { t -> canBeatRecord(t, time, recordToBeat)  }
            val firstWinningTime = range.find { t -> canBeatRecord(t, time, recordToBeat) }

            var factor = 1
            if (firstWinningTime != null) {
                factor = (firstWinningTime..lastWinningTime!!).toList().size
            }
            result *= factor
        }
        return result
    }

    fun canBeatRecord(timeToCheck:Long, competitionTime: Long, distanceToBeat: Long): Boolean =
        timeToCheck * (competitionTime - timeToCheck) > distanceToBeat
}