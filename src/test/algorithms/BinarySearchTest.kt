package test.algorithms

import algorithms.binarySearch
import org.testng.annotations.Test
import kotlin.test.assertEquals

class BinarySearchTest {
    @Test
    fun binarySearchTest() {
        val array = arrayOf(1, 3, 5, 7)

        assertEquals(0, binarySearch(array, 1))
        assertEquals(null, binarySearch(array, 2))
        assertEquals(1, binarySearch(array, 3))
        assertEquals(3, binarySearch(array, 7))
    }
}
