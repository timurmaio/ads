package test.algorithms.sortings

import algorithms.sortings.quickSort
import org.testng.annotations.Test
import kotlin.test.assertTrue

class QuickTest {
    @Test
    fun `awesome quickSort Test`() {
        val array = arrayOf(9, 4, 3, 6, 4, 6, 1, 0)
        val result = array.clone()

        quickSort(result, 0, result.size-1)

        assertTrue(array.sortedArray().contentEquals(result))
    }
}
