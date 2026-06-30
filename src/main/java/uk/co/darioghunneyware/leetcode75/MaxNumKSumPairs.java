package uk.co.darioghunneyware.leetcode75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNumKSumPairs {
    public int maxOperations(int[] nums, int k) {
        if (nums.length < 2) {
            return 0;
        } else if (nums.length == 2) {
            if (nums[0] + nums[1] == k) {
                return 1;
            }  else {
                return 0;
            }
        }

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int operations = 0;

        while ((left < right)) {
            int sum = nums[left] + nums[right];

            if (sum == k) {
                operations++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            }  else {
                right--;
            }
        }

        return operations;
    }

//    private int findNextLeft(int[] nums, int left, int k) {
//        while (left < nums.length && nums[left] >= k) {
//            left++;
//        }
//        return left;
//    }

//    private int findNextRight(int[] nums, int right, int k) {
//        while (right > 0 && nums[right] >= k) {
//            right--;
//        }
//        return right;
//    }

//    public int maxOperations2(int[] nums, int k) {
//        if (nums.length < 2) {
//            return 0;
//        } else if (nums.length == 2) {
//            if (nums[0] + nums[1] == k) {
//                return 1;
//            }  else {
//                return 0;
//            }
//        }
//
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        int operations = 0;
//        for (int num : nums) {
//            int oppKey = k - num;
//            int oppOccurrence = map.get(oppKey);
//
//            if (oppOccurrence >= 1) {
//                operations++;
//                map.put(num, map.get(num) - 1);
//                map.put(oppKey, map.get(oppKey) - 1);
//            }
//        }
//
//        return operations;
//    }
}
