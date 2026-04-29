package uk.co.darioghunneyware.leetcode75;

class MergeAlternateStrings {
        public String mergeAlternately(String word1, String word2) {
            boolean useOtherWord = false;
            StringBuilder mergedWord = new StringBuilder();
            int counter1 = 0;
            int counter2 = 0;
            int wordLength = word1.length() + word2.length();

            while (mergedWord.toString().length() < wordLength) {
                while (counter1 < word1.length() && counter2 < word2.length()) {
                    if (!useOtherWord) {
                        mergedWord.append(word1.charAt(counter1));
                        useOtherWord = true;
                        counter1++;
                    } else {
                        mergedWord.append(word2.charAt(counter2));
                        useOtherWord = false;
                        counter2++;
                    }
                }

                if (counter1 >= word1.length() && counter2 < word2.length()) {
                    mergedWord.append(word2.substring(counter2));
                } else {
                    mergedWord.append(word1.substring(counter1));
                }
            }

            return mergedWord.toString();
        }
}