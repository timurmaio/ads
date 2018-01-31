package test.algorithms

import algorithms.getFibonacciNumber
import org.testng.annotations.Test
import kotlin.test.assertEquals

class FibonacciTest {
    @Test
    fun getFibonacciNumberTest() {
        assertEquals(0, getFibonacciNumber(0))
        assertEquals(1, getFibonacciNumber(1))
        assertEquals(1, getFibonacciNumber(2))
        assertEquals(2, getFibonacciNumber(3))
        assertEquals(55, getFibonacciNumber(10))
        assertEquals(1293530146158671551, getFibonacciNumber(94))
    }
}
