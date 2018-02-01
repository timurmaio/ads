package test.algorithms

import algorithms.powMod
import org.testng.annotations.Test
import kotlin.test.assertEquals

class PowModTest {
    @Test
    fun powModTest() {
        assertEquals(8, powMod(5, 3, 13))
        assertEquals(445, powMod(4, 13, 497))
        assertEquals(342, powMod(595, 703, 991))
    }
}
