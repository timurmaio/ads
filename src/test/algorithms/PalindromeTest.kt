package test.algorithms

import algorithms.isPalindrome
import org.testng.annotations.Test
import kotlin.test.assertEquals

class PalindromeTest {
    @Test
    fun isPalindromeTest() {
        assertEquals(true, isPalindrome(0))
        assertEquals(true, isPalindrome(11))
        assertEquals(true, isPalindrome(111))
        assertEquals(true, isPalindrome(1111))
        assertEquals(true, isPalindrome(1221))
        assertEquals(true, isPalindrome(505))

        assertEquals(false, isPalindrome(12))
        assertEquals(false, isPalindrome(123))
        assertEquals(false, isPalindrome(1231))
    }
}
