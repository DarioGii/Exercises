package uk.co.darioghunneyware.leetcode75;

import java.util.Iterator;
import java.util.Stack;

public class Asteroids {

    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length == 2) {
            if ((asteroids[0] > 0 && asteroids[1] > 0) || (asteroids[0] < 0 && asteroids[1] < 0)) {
                return asteroids;
            } else if (Math.abs(asteroids[0]) == Math.abs(asteroids[1])) {
                return new int[0];
            }
            else {
                return new int[] { Math.max(Math.abs(asteroids[0]),  Math.abs(asteroids[1])) };
            }
        }

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty()
                    && stack.peek() > 0
                    && asteroid < 0) {

                if (stack.peek() < -asteroid) {
                    // stack asteroid explodes
                    stack.pop();
                } else if (stack.peek() == -asteroid) {
                    // both explode
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    // incoming asteroid explodes
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
