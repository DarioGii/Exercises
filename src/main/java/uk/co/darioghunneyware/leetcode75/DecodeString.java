package uk.co.darioghunneyware.leetcode75;

import java.util.Iterator;
import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        boolean bracesClosed = false;
        int times = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '[' || s.charAt(i) == ']') {
                stack.push(s.charAt(i));
            }
        }

        while (!stack.isEmpty()) {
            char c = stack.peek();

            if (isInteger(String.valueOf(c))) {
                times = Integer.parseInt(String.valueOf(c));
                stack.pop();
                char encodedChar = stack.peek();
                for (int i = 0; i < times; i++) {
                    sb.append(encodedChar);
                }
            }
        }

        return sb.toString();
    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

}
