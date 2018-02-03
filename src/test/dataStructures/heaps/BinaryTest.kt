package test.dataStructures.heaps

import dataStructures.heaps.Binary
import dataStructures.heaps.HeapNode
import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

internal class BinaryTest {
    @Test
    fun extractMaximal() {
        val list = listOf(HeapNode(42, 8), HeapNode(4, 1), HeapNode(53, 9), HeapNode(22, 7))
        val heap = Binary(list)

        assertEquals(heap.extractMaximal().priority, 53)
        assertEquals(heap.extractMaximal().priority, 42)
        assertEquals(heap.extractMaximal().priority, 22)
        assertEquals(heap.extractMaximal().priority, 4)

        assertFails { heap.extractMaximal() }
    }

    @Test
    fun peekMaximal() {
        val heap = Binary(emptyList<HeapNode<Int>>())
        
        heap.insert(HeapNode(7, 2))
        heap.insert(HeapNode(20, 5))
        heap.insert(HeapNode(21, 6))
        heap.insert(HeapNode(21, 1))
        heap.insert(HeapNode(18, 3))
        heap.insert(HeapNode(18, 4))

        assertEquals(heap.peekMaximal().priority, 21)
        assertEquals(heap.extractMaximal().priority, 21)
        assertEquals(heap.peekMaximal().priority, 21)
        assertEquals(heap.peekMaximal().priority, 21)

        assertEquals(heap.extractMaximal().priority, 21)
        assertEquals(heap.peekMaximal().priority, 20)
        assertEquals(heap.peekMaximal().priority, 20)
    }
}
