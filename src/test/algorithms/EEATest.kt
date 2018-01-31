package test.algorithms

import algorithms.extendedEuclidean
import org.testng.annotations.Test
import kotlin.test.assertEquals

class EEATest {
    @Test
    fun extendedEuclideanTest() {
        assertEquals(Pair(-9, 47), extendedEuclidean(240, 46))
        assertEquals(Pair(-98, 99), extendedEuclidean(991, 981))
    }
}
