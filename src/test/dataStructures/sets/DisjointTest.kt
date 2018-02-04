package test.dataStructures.sets

import dataStructures.sets.Disjoint
import org.testng.annotations.Test
import kotlin.test.assertEquals

internal class DisjointTest {
    @Test
    fun check() {
        val size = 5
        val union = Disjoint(size)
        (0 until size).forEach { i -> union.makeSet(i) }

        assertEquals(union.check(0, 1), false)
        union.union(0, 1)
        assertEquals(union.check(0, 1), true)
        union.union(4, 0)
        assertEquals(union.check(4, 1), true)
        assertEquals(union.check(2, 2), true)
        assertEquals(union.check(2, 3), false)
    }
}
