package uk.co.darioghunneyware.leetcode75;

import java.util.Arrays;

public class LeetCode75 {

    public static void main(String[] args) {
        CommonDivisor commonDivisor = new CommonDivisor();
        ReverseWords reverseWords = new ReverseWords();
        ProductOfArray productOfArray = new ProductOfArray();
        CompressStrings compressStrings = new CompressStrings();

//        System.out.println(commonDivisor.gcdOfStrings("ABABC", "ABC"));
//        System.out.println(new KidsCandy().kidsWithCandies(new int[] {2,3,5,1,3}, 3));
//        System.out.println(new ReverseVowels().reverseVowels("IceCreAm"));
//        System.out.println(reverseWords.reverseWords("the sky is blue"));
//        System.out.println(Arrays.toString(productOfArray.productExceptSelf(new int[]{-1,1,0,-3,3})));
        System.out.println(compressStrings.compress(new char[] {'a','a','b','b','c','c','c'}));
    }
}
