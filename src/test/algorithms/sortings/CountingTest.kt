package test.algorithms.sortings

import algorithms.sortings.countingSort
import org.testng.annotations.Test
import kotlin.test.assertTrue

class CountingTest {
    @Test
    fun countingSortTest() {
        val array = arrayOf(9, 4, 3, 6, 4, 6, 1, 0)
        val result = countingSort(array)

        assertTrue(array.sortedArray().contentEquals(result))
    }
}
