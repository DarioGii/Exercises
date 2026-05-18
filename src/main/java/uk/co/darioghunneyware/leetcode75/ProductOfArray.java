package uk.co.darioghunneyware.leetcode75;

import java.util.Arrays;

public class ProductOfArray {

    public int[] productExceptSelf(int[] nums) {
        int[] answers;

        if (nums.length == 2) {
            answers = new int[] {nums[1], nums[0]};
            return answers;
        }

        answers = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (answers[i] == 0) answers[i] = 1;

            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;

                answers[i] *= nums[j];
            }
        }

        return answers;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suff = new int[n];
        pre[0] = 1;
        suff[n - 1] = 1;

        for(int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            ans[i] = pre[i] * suff[i];
        }

        return ans;
    }
}
