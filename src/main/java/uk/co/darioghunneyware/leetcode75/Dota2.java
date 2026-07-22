package uk.co.darioghunneyware.leetcode75;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2 {

    public String predictPartyVictory(String senate) {
        int n = senate.length();

        if (n == 1) {
            return senate.equals("R") ? "Radiant" : "Dire";
        }

        Queue<Integer> radiants = new LinkedList<>();
        Queue<Integer> dires = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiants.offer(i);
            }  else {
                dires.offer(i);
            }
        }

        while (!radiants.isEmpty() && !dires.isEmpty()) {
            int radiant = radiants.poll();
            int dire = dires.poll();

            if (radiant < dire) {
                radiants.offer(n);
            } else {
                dires.offer(n);
            }

            n++;
        }

        return radiants.size() > dires.size() ? "Radiant" : "Dire";
    }

}
