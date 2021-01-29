package part1

fun countInversionsAndSort(integers: List<Int>): Pair<Long, List<Int>> {
    if (integers.isEmpty())
        return 0L to emptyList()

    // i inclusive, j exclusive
    fun recurse(i: Int, j: Int): Pair<Long, List<Int>> {
        if (j - i <= 1)
            return 0L to listOf(integers[i])
        val (count1, leftHalf) = recurse(i, (i+j) / 2)
        val (count2, rightHalf) = recurse((i+j) / 2, j)
        val (splitInverionsCount, merged) = countSplitInversionsAndMerge(leftHalf, rightHalf)
        return (count1 + count2 + splitInverionsCount) to merged
    }

    return recurse(0, integers.size)
}

private fun countSplitInversionsAndMerge(leftHalf: List<Int>, rightHalf: List<Int>): Pair<Long, List<Int>> {
    var splitInversionsCount = 0L
    var mergedList = mutableListOf<Int>()
    var l = 0
    var r = 0
    while (l < leftHalf.size && r < rightHalf.size) {
        if (leftHalf[l] <= rightHalf[r]) {
            mergedList.add(leftHalf[l])
            l++
        } else {
            mergedList.add(rightHalf[r])
            splitInversionsCount += leftHalf.size - l
            r++
        }
    }
    while (l < leftHalf.size) {
        mergedList.add(leftHalf[l])
        l++
    }
    while (r < rightHalf.size) {
        mergedList.add(rightHalf[r])
        r++
    }
    return splitInversionsCount to mergedList
}

