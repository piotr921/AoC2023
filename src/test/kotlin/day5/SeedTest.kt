package day5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SeedTest {

    @Test
    fun whenSoilIsInMapping_shouldAddSoilIdToSeed() {
        val s = Seed(20)
        val soilMappings = listOf(listOf(30, 30, 30), listOf(99, 10, 15))

        s.addSoilId(soilMappings)

        assertEquals(119, s.soil)
    }

    @Test
    fun whenSoilIsNotInMapping_shouldUseId() {
        val s = Seed(27)
        val soilMappings = listOf(listOf(30, 30, 30), listOf(99, 10, 15))

        s.addSoilId(soilMappings)

        assertEquals(27, s.soil)
    }
}