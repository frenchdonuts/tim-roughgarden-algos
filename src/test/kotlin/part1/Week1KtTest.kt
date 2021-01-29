package part1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class Week1KtTest {

    @Test
    fun countInversionsAndSort() {
        val testCase1 = listOf(3, 6, 1, 7, 2, 5, 1, 7)
        val (count, sortedList) = part1.countInversionsAndSort(testCase1)
        assert(count == 12L)
        assert(sortedList == testCase1.sorted())

        val intArrayFilePath = "/Users/frenchdonuts/Documents/tim-roughgarden-course/code/src/test/kotlin/part1/IntegerArrays"
        val intArray = File(intArrayFilePath)
            .useLines { it.toList() }
            .map { it.toInt() }
        println(part1.countInversionsAndSort(intArray).first)
    }

}