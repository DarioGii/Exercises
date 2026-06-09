package uk.co.darioghunneyware.leetcode75;

import java.util.Stack;

public class RemoveStars {

    /**
     * <p>You are given a string s, which contains stars *.</p>
     *
     * <p>In one operation, you can:</p>
     *
     * <p>Choose a star in s.
     * Remove the closest non-star character to its left, as well as remove the star itself.
     * Return the string after all stars have been removed.</p>
     *
     * <p>nOte:</p>
     *
     * <p>The input will be generated such that the operation is always possible.
     * It can be shown that the resulting string will always be unique.</p>
     *
     */
    public String removeStars(String s) {
        if (s.length() == 1) {
            return s.charAt(0) == '*' ? "" : s;
        }

        int index = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }

        while (index < sb.length()) {
            if (sb.charAt(index) == '*') {
                sb.deleteCharAt(index--);
                sb.deleteCharAt(index--);
            }
            index++;
        }

        return sb.toString();
    }

    public String removeStars2(String s) {
        if (s.length() == 1) {
            return s.charAt(0) == '*' ? "" : s;
        }

        StringBuilder filtered = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '*') {
                filtered.append(s.charAt(i));
            } else {
                i--; // fixme: find out what to do when two '*'s are next to each other i.e. e*doc**teel
            }
        }
        return filtered.reverse().toString();
    }

    public String removeStars3(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch != '*') {
                stack.push(ch);
            } else stack.pop();
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
