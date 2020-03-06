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
    The path needs to pass through the root or a common root for it to be the longest path in the tree. 
    Quick proof:
        If there was a path between two nodes that didn't pass through a common node (forming an upside down V), it would have to go straight down.
        Then, a strictly longer path could be made by extending the "higher" end all the way up to root.
    
    If this was a balanced binary tree, the longest path MUST pass through the root node.
    Edge Cases:
        if root is null then return 0

    // not finished yet
    */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null || root.left == null || root.right == null) return 0;
        else return 1 + Math.max(1 + diameterOfBinaryTree(root.left.left), 1 + diameterOfBinaryTree(root.left.right)) + Math.max(1 + diameterOfBinaryTree(root.right.right), 1 + diameterOfBinaryTree(root.right.left));
    }
}