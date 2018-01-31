package test.algorithms

import algorithms.lcm
import org.testng.annotations.Test
import kotlin.test.assertEquals

class LCMTest {
    @Test
    fun lcmTest() {
        // lcm(m,n)=lcm(n,m)
        assertEquals(lcm(3, 2), lcm(2, 3))

        // lcm(m,n)=m*n, если m,n - взаимнопростые
        assertEquals(5*7, lcm(5, 7))
        assertEquals(5*7, lcm(7, 5))

        assertEquals(80, lcm(16, 20))
    }
}
