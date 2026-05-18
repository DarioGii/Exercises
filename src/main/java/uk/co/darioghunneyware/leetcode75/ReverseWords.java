package uk.co.darioghunneyware.leetcode75;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseWords {

    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");

        if (words.length == 1) {
            return s;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            stringBuilder.append(words[i]).append(" ");
        }

        return stringBuilder.toString().trim();

//        String reversed = Arrays.stream(words)
//                .filter(word -> !word.isEmpty())
//                .map(word -> new StringBuilder(word).reverse())
//                .collect(Collectors.joining(" "));

//        return reversed;
    }
}
