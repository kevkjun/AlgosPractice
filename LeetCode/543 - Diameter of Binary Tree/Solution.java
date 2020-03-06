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
    
    DepthFirstSearch - requires a helper function which descends to the lowest it can go for both left and right nodes
    
    If this was a balanced binary tree, the longest path MUST pass through the root node.
    Edge Cases:
        if root is null then return 0
    */
    // Faster than 100%
    // Less than 18%
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}