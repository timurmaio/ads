package test.algorithms

import algorithms.isPowerOfTwo
import org.testng.annotations.Test
import kotlin.test.assertEquals

class PowerOfTwoTest {
    @Test
    fun isPowerOfTwoTest() {
        assertEquals(false, isPowerOfTwo(0))
        assertEquals(true, isPowerOfTwo(1))
        assertEquals(true, isPowerOfTwo(2))
        assertEquals(true, isPowerOfTwo(4))
        assertEquals(true, isPowerOfTwo(1024))
        assertEquals(false, isPowerOfTwo(1023))
    }
}
