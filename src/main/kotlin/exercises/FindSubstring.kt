package exercises

class FindSubstring {
    fun findSubstring(
        s: String,
        words: Array<String>,
    ): List<Int> {
        val permutations: List<List<String>> = getPermutations(words)
        val wordsInString: MutableSet<Int> = mutableSetOf()

        for (permutationList in permutations) {
            val permutation = permutationList.joinToString(separator = "")

            if (s.contains(permutation)) {
                wordsInString.add(s.indexOf(permutation))
            }
        }

        return wordsInString.toList()
    }

    private fun getPermutations(arr: Array<String>): List<List<String>> {
        val result = mutableListOf<List<String>>()
        permute(arr, 0, arr.size, result)
        return result
    }

    private fun permute(
        arr: Array<String>,
        l: Int,
        r: Int,
        result: MutableList<List<String>>,
    ) {
        if (l == r) {
            result.add(arr.toList())
        } else {
            for (i in l until r) {
                swap(arr, l, i)
                permute(arr, l + 1, r, result)
                swap(arr, l, i) // backtrack
            }
        }
    }

    private fun swap(
        arr: Array<String>,
        i: Int,
        j: Int,
    ) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}
