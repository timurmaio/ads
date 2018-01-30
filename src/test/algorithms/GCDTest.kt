package test.algorithms

import algorithms.gcd
import algorithms.gcdRecursive
import org.testng.annotations.Test
import kotlin.test.assertEquals

class GCDTest {
    @Test
    fun gcdTest() {
        // gcd(n,n)=n
        assertEquals(1, gcd(1, 1))
        assertEquals(10, gcd(10, 10))

        // gcd(n,0)=n
        assertEquals(1, gcd(1, 0))
        assertEquals(1, gcd(0, 1))

        assertEquals(21, gcd(1071, 462))
        assertEquals(21, gcd(462, 1071))

        assertEquals(1, gcd(3, 7))
        assertEquals(1, gcd(7, 3))

        assertEquals(0, gcd(0, 0))
    }

    @Test
    fun gcdRecursiveTest() {
        assertEquals(21, gcdRecursive(1071, 462))
        assertEquals(21, gcdRecursive(462, 1071))
    }
}
