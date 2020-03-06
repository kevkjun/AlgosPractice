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
    At the base of the tree, need to exchange the left and right leaves.
    Switch the left and right branches of the root, then call inverTree on the right and left roots. 
    Essentially trashes the intermediate calls to invertTree until we work back up from the bottom and return the initial root.
    */
    
    // Faster than 100%
    // Less than 5%
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        
        invertTree(root.right);
        invertTree(root.left);
        
        return root;
    }
}