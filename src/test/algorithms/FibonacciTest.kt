package test.algorithms

import algorithms.getFibonacciNumber
import algorithms.getLasDigitOfFibonacciNumber
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
        assertEquals(7540113804746346429, getFibonacciNumber(92))
    }

    @Test
    fun getLasDigitOfFibonacciNumberTest() {
        assertEquals(0, getLasDigitOfFibonacciNumber(0))
        assertEquals(1, getLasDigitOfFibonacciNumber(1))
        assertEquals(1, getLasDigitOfFibonacciNumber(2))
        assertEquals(2, getLasDigitOfFibonacciNumber(3))
        assertEquals(3, getLasDigitOfFibonacciNumber(7))
        assertEquals(9, getLasDigitOfFibonacciNumber(92))
        assertEquals(5, getLasDigitOfFibonacciNumber(294590))
    }
}
