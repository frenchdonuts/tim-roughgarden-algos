package part1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Week1KtTest {

    @Test
    fun testKatsurabaEasy() {
        val x = "2"
        val y = "3"
        assert(katsurabaMultiply(x, y) == "6")
    }

    @Test
    fun testKatsurabaMed() {
        val x = "1000"
        val y = "1000"
        assert(katsurabaMultiply(x, y) == "1000000")
    }

    @Test
    fun testKatsurabaHard() {
        val x = "3141592653589793238462643383279502884197169399375105820974944592"
        val y = "2718281828459045235360287471352662497757247093699959574966967627"
        print(katsurabaMultiply(x, y))
    }
}