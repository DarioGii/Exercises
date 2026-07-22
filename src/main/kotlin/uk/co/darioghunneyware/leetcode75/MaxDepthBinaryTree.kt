package uk.co.darioghunneyware.leetcode75

import uk.co.darioghunneyware.model.TreeNode

class MaxDepthBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        var depth = 0

        return findMaxDepth(root)
    }

    private fun findMaxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0.
        }

        var depth = 0

        if (root.left == null && root.right == null) {
            return 1
        }

        if (root.left != null) {
            depth += findMaxDepth(root.left)
        }

        if (root.right != null) {
            depth += findMaxDepth(root.right) + depth
        }

        return depth
    }
}
