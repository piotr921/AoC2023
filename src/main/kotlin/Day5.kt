import day5.Seed

class Day5 {

    // 50 98 2
    // 52 50 48
    // The first line has a destination range start of 50, a source range start of 98, and a range length of 2.
    fun findClosestLocation(input: List<String>): Long {
        val seeds = input[0]
            .replace("seeds:", "")
            .split(" ")
            .filter { s -> s != "" }
            .map { s -> s.toLong() }
            .map { seedId -> Seed(seedId) }

        val soilMappings = extractMappings(input, "seed-to-soil map:", "soil-to-fertilizer map:")
        seeds.forEach { seed -> seed.addSoilId(soilMappings) }

        val fertilizerMappings = extractMappings(input, "soil-to-fertilizer map:", "fertilizer-to-water map:")
        seeds.forEach { seed -> seed.addFertilizerId(fertilizerMappings) }

        val waterMappings = extractMappings(input, "fertilizer-to-water map:", "water-to-light map:")
        seeds.forEach { seed -> seed.addWaterId(waterMappings) }

        val lightMappings = extractMappings(input, "water-to-light map:", "light-to-temperature map:")
        seeds.forEach { seed -> seed.addLightId(lightMappings) }

        val tempMappings = extractMappings(input, "light-to-temperature map:", "temperature-to-humidity map:")
        seeds.forEach { seed -> seed.addTemperatureId(tempMappings) }

        val humidityMappings = extractMappings(input, "temperature-to-humidity map:", "humidity-to-location map:")
        seeds.forEach { seed -> seed.addHumidityId(humidityMappings) }

        val locationMappings = extractMappings(input, "humidity-to-location map:", "end")
        seeds.forEach { seed -> seed.addLocationId(locationMappings) }

        return seeds.map { s -> s.location }.min()
    }

    private fun extractMappings(input: List<String>, startLine: String, endLine: String) = input
        .subList(
            input.indexOf(startLine) + 1, if (endLine != "end") {
                input.indexOf(endLine)
            } else {
                input.size
            }
        )
        .filter { s -> s != "" }
        .map { sm -> sm.split(" ").filter { s -> s != "" }.map { s -> s.toLong() } }
}