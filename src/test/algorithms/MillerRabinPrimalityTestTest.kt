package test.algorithms

import algorithms.extractPowerOfTwo
import algorithms.millerRabinPrimalityTest
import org.testng.annotations.Test
import kotlin.test.assertEquals

class MillerRabinPrimalityTestTest {
    @Test
    fun extractPowerOfTwoTest() {
        assertEquals(Pair(2, 3), extractPowerOfTwo(12))
        assertEquals(Pair(3, 3), extractPowerOfTwo(24))
        assertEquals(Pair(1, 5), extractPowerOfTwo(10))
        assertEquals(Pair(2, 5), extractPowerOfTwo(20))
    }

    @Test
    fun millerRabinPrimalityTestTest() {
        assertEquals(true, millerRabinPrimalityTest(3))
        assertEquals(true, millerRabinPrimalityTest(5))
        assertEquals(true, millerRabinPrimalityTest(7))
        assertEquals(false, millerRabinPrimalityTest(9))
        assertEquals(false, millerRabinPrimalityTest(221))

        assertEquals(false, millerRabinPrimalityTest(65281))
        assertEquals(false, millerRabinPrimalityTest(74665))

        assertEquals(false, millerRabinPrimalityTest(23521))
        assertEquals(false, millerRabinPrimalityTest(31621))

        assertEquals(false, millerRabinPrimalityTest(9881))
        assertEquals(false, millerRabinPrimalityTest(8321))
    }
}
