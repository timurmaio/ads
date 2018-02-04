package test.dataStructures.trees

import dataStructures.trees.Segment
import org.testng.annotations.Test
import kotlin.test.assertEquals

internal class SegmentTest {
    @Test
    fun query() {
        val tree = Segment(listOf(1, 2, 3, 4, 5))

        assertEquals(1, tree.query(0, 4))

        tree.update(0, 8)
        assertEquals(2, tree.query(0, 4))
        assertEquals(8, tree.query(0, 0))
        assertEquals(2, tree.query(0, 2))

        tree.update(2, 1)
        assertEquals(1, tree.query(1, 3))
    }
}
