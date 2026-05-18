package uk.co.darioghunneyware.leetcode75;

import com.sun.corba.se.spi.activation.TCPPortHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseVowels {

    public String reverseVowels(String s) {
        char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        List<Character> replacements = new ArrayList<>();
        List<Integer> replacementPos = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            for (char vowel : vowels) {
                if (vowel == currentChar) {
                    replacements.add(currentChar);
                    replacementPos.add(i);
                    break;
                }
            }
        }

        Collections.reverse(replacements);
        StringBuilder stringBuilder = new StringBuilder();

        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (replacementPos.contains(i)) {
                stringBuilder.append(replacements.get(counter));
                counter++;
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }

        return stringBuilder.toString();
    }
}
