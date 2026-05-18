package uk.co.darioghunneyware.leetcode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsCandy {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>(candies.length);
        int mostCandies = Arrays.stream(candies).max().getAsInt();

        for (int candy : candies) {
            int currentCandy = candy + extraCandies;

            if (currentCandy >= mostCandies) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;
    }
}
