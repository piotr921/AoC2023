package day5

class Seed(
    val id: Long,
    var soil: Long = 0,
    var fertilizer: Long = 0,
    var water: Long = 0,
    var light: Long = 0,
    var temperature: Long = 0,
    var humidity: Long = 0,
    var location: Long = 0
) {

    fun addSoilId(soilMappings: List<List<Long>>) {
        soil = calcId(id, findCorrespondingRange(id, soilMappings))
    }

    fun addFertilizerId(fertilizerMappings: List<List<Long>>) {
        fertilizer = calcId(soil, findCorrespondingRange(soil, fertilizerMappings))
    }

    fun addWaterId(waterMappings: List<List<Long>>) {
        water = calcId(fertilizer, findCorrespondingRange(fertilizer, waterMappings))
    }

    fun addLightId(lightMappings: List<List<Long>>) {
        light = calcId(water, findCorrespondingRange(water, lightMappings))
    }

    fun addTemperatureId(temperatureMappings: List<List<Long>>) {
        temperature = calcId(light, findCorrespondingRange(light, temperatureMappings))
    }

    fun addHumidityId(humidityMappings: List<List<Long>>) {
        humidity = calcId(temperature, findCorrespondingRange(temperature, humidityMappings))
    }

    fun addLocationId(locationMappings: List<List<Long>>) {
        location = calcId(humidity, findCorrespondingRange(humidity, locationMappings))
    }

    private fun findCorrespondingRange(inputId: Long, mappings: List<List<Long>>) = mappings
        .find { mappingList -> (inputId >= mappingList[1] && inputId < mappingList[1] + mappingList[2]) }
        .orEmpty()


    private fun calcId(inputId: Long, found: List<Long>) = if (found.isNotEmpty()) {
        found[0] + (inputId - found[1])
    } else {
        inputId
    }
}
