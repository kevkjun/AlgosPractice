/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    We're looking for the max depth down to the farthest leaf from the root.
    Use recursion to find the depth of the left and right branches and take the max of that.
    */
    // Faster than 100%
    // Less than 95%
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
    }
}