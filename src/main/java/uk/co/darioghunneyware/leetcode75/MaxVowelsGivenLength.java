package uk.co.darioghunneyware.leetcode75;

/**
 * <p>Example 1:</p>
 *
 * <p>Input: s = "abciiidef", k = 3</p>
 * <p>Output: 3</p>
 * <p>Explanation: The substring "iii" contains 3 vowel letters.</p>
 *
 * <p>Example 2:</p>
 *
 * <p>Input: s = "aeiou", k = 2</p>
 * <p>Output: 2</p>
 * <p>Explanation: Any substring of length 2 contains 2 vowels.</p>
 *
 * <p>Example 3:</p>
 *
 * <p>Input: s = "leetcode", k = 3</p>
 * <p>Output: 2</p>
 * <p>Explanation: "lee", "eet" and "ode" contain 2 vowels.</p>
 * */

public class MaxVowelsGivenLength {

    public int maxVowels(String s, int k) {
        int numVowels = 0;

        for (int i = 0; i + k <= s.length(); i++) {
            String window = s.substring(i, i + k);
            int currentVowels = findOccurrence(window.toCharArray());

            if (currentVowels >= numVowels) {
                numVowels = currentVowels;
            }
        }
        return numVowels;
    }

    private int findOccurrence(char[] charArray) {
        int count = 0;
        for (char c : charArray) {
            if (isVowel(c)) {
                count++;
            }
        }
        return count;
    }

    private boolean isVowel(char c) {
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
}
