package uk.co.darioghunneyware.leetcode75;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class PathSum {

    public boolean hasPathSum(JTreeNode root, int targetSum) {
        // Empty node - no path here
        if (root == null) return false;

        // It's a leaf - check if this node exactly accounts for what's left
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Recurse down both sides with reduced target
        int remaining = targetSum - root.val;
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }

    public List<List<Integer>> pathSum(JTreeNode root, int targetSum) {
        return new ArrayList<>();
    }
}

class JTreeNode {
    int val;
    JTreeNode left;
    JTreeNode right;

    JTreeNode() {
    }

    JTreeNode(int val) {
        this.val = val;
    }

    JTreeNode(int val, JTreeNode left, JTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
