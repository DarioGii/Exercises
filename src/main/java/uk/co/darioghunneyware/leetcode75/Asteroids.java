package uk.co.darioghunneyware.leetcode75;

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
        stack.push(asteroids[0]);

        // fixme: need to check asteroid against other asteroids in the stack. may need a double loop and iterating through stack
        for (int i = 1; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            Integer peekedAsteroid = stack.peek();

            if ((asteroid > 0 && peekedAsteroid > 0) || (asteroid < 0 && peekedAsteroid < 0)) {
                stack.push(asteroid);
            } else if (Math.abs(asteroid) > Math.abs(peekedAsteroid)) {
                stack.pop();
                stack.push(asteroid);
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
