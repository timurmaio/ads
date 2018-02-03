package test.algorithms

import algorithms.reverseInput
import org.testng.annotations.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

class ReverseInputTest {
    @Test
    fun parseInputTest() {
        // stub IO
        val input = "1\n2\n3"
        val output = ByteArrayOutputStream()
        val outStream = PrintStream(output)
        System.setIn(input.byteInputStream())
        System.setOut(outStream)

        reverseInput()

        assertEquals("3 2 1 ", output.toString())
    }
}
