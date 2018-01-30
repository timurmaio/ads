package test.algorithms

import algorithms.gcd
import algorithms.gcdRecursive
import org.testng.annotations.Test
import kotlin.test.assertEquals

class GCDTest {
    @Test
    fun gcdTest() {
        assertEquals(21, gcd(1071, 462))
    }

    @Test
    fun gcdRecursiveTest() {
        assertEquals(21, gcdRecursive(1071, 462))
    }
}
