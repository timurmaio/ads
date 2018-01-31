package algorithms

/**
 * Получение n-го числа Фибоначчи.
 */
fun getFibonacciNumber(n: Int): Long {
    val numbers = Array<Long>(100, { 0 })
    numbers[1] = 1

    for (i in (2..n)) {
        numbers[i] = numbers[i-1] + numbers[i-2]
    }

    return numbers[n]
}
