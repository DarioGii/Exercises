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
        MaxNumKSumPairs maxNumKSumPairs = new MaxNumKSumPairs();
        MaxVowelsGivenLength maxVowelsGivenLength = new MaxVowelsGivenLength();

        System.out.println(maxVowelsGivenLength.maxVowels("weallloveyou", 7));
    }
}
