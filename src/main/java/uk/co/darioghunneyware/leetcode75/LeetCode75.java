package uk.co.darioghunneyware.leetcode75;

import java.util.Arrays;

public class LeetCode75 {

    public static void main(String[] args) {
        CommonDivisor commonDivisor = new CommonDivisor();
        ReverseWords reverseWords = new ReverseWords();
        ProductOfArray productOfArray = new ProductOfArray();
        CompressStrings compressStrings = new CompressStrings();
        RemoveStars removeStars = new RemoveStars();
        TreeNode treeNode = new TreeNode(5, new TreeNode(4), new TreeNode(8));
        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.right = new TreeNode(1);

        PathSum pathSum = new PathSum();
        Asteroids  asteroids = new Asteroids();

//        System.out.println(commonDivisor.gcdOfStrings("ABABC", "ABC"));
//        System.out.println(new KidsCandy().kidsWithCandies(new int[] {2,3,5,1,3}, 3));
//        System.out.println(new ReverseVowels().reverseVowels("IceCreAm"));
//        System.out.println(reverseWords.reverseWords("the sky is blue"));
//        System.out.println(Arrays.toString(productOfArray.productExceptSelf(new int[]{-1,1,0,-3,3})));
//        System.out.println(compressStrings.compress(new char[] {'a','a','b','b','c','c','c'}));
//        System.out.println(pathSum.hasPathSum(treeNode, 22));
//        System.out.println(removeStars.removeStars3("leet**cod*e"));
//        System.out.println(removeStars.removeStars2("erase*****"));
        System.out.println(asteroids.asteroidCollision(new int[]{5,10,-5}));
        System.out.println(asteroids.asteroidCollision(new int[]{8,-8}));
        System.out.println(asteroids.asteroidCollision(new int[]{10,2,-5}));
        System.out.println(asteroids.asteroidCollision(new int[]{3,5,-6,2,-1,4}));
    }
}
