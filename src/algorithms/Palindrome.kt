package algorithms

/**
 * Является ли число палиндромом
 */
fun isPalindrome(n: Long): Boolean {
    var pal = n
    var lap = 0L

    while (pal != 0L) {
        val reminder = pal % 10
        lap = lap * 10 + reminder
        pal /= 10
    }

    return n == lap
}
