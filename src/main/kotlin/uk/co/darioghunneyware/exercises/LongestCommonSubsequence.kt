package uk.co.darioghunneyware.exercises

import kotlin.math.max

class LongestCommonSubsequence {
    fun longestCommonSubsequence(
        text1: String,
        text2: String,
    ): Int {
        val matrix2d = Array(text2.length + 1) { Array(text1.length + 1) { 0 } }

        for (i in (1..<matrix2d.size)) {
            for (j in (1..<matrix2d[0].size)) {
                if (text1[j - 1] == text2[i - 1]) {
                    matrix2d[i][j] = matrix2d[i - 1][j - 1] + 1
                } else {
                    matrix2d[i][j] = max(matrix2d[i - 1][j], matrix2d[i][j - 1])
                }
            }
        }

        return matrix2d[text2.length][text1.length]
    }
}
