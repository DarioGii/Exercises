package leetcode75

class MergeStringsAlternately {
    fun mergeAlternately(
        word1: String,
        word2: String,
    ): String {
        var useWord1 = false
        var index1 = 0
        var index2 = 0
        var mergedWord = ""

        while (index1 < word1.length && index2 < word2.length) {
            if (!useWord1) {
                mergedWord += word1[index1++]
                useWord1 = true
            } else {
                mergedWord += word2[index2++]
                useWord1 = false
            }
        }

        if (index1 < word1.length) {
            while (index1 < word1.length) {
                mergedWord += word1[index1++]
            }
        } else {
            while (index2 < word2.length) {
                mergedWord += word2[index2++]
            }
        }

        return mergedWord
    }

    // fixMe: slightly better
//    fun mergeAlternately(word1: String, word2: String): String {
//        var result=CharArray(word1.length+word2.length) { ' ' }
//        var index=0
//        var resultIndex=0
//        val longestWord = maxOf(word1.length, word2.length)
//
//        while(index < longestWord){
//            if(index<word1.length){
//                result[resultIndex]=word1[index]
//                resultIndex++
//            }
//            if(index<word2.length){
//                result[resultIndex]=word2[index]
//                resultIndex++
//            }
//            index++
//        }
//        return String(result)
//    }
}
