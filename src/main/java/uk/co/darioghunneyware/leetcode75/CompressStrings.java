package uk.co.darioghunneyware.leetcode75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

public class CompressStrings {

    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }

        StringBuilder newChars = new StringBuilder();
        int charCounter = 0;
        int i = 1;
        char current = chars[i-1];

        while (i < chars.length) {
            for (int j = i-1; chars[j] == current; j++) {
                charCounter++;
            }

            newChars.append(chars[i++]).append(charCounter);
            charCounter = 0;
            current = chars[++i];
        }
        newChars.append(charCounter);

        for (int k = 0; k < chars.length; k++) {
            chars[k] = newChars.charAt(k);
        }

        return newChars.length();
    }
}
