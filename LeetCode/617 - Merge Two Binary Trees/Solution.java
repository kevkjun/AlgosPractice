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
    Needs to be recursive.
    If they are both null, then should return null.
    If one is null and the other isn't, it should return the one that isn't.
    If both are not null, then should return the sum of the two.
    
    Need to make sure that we are manually assigning newNode.left and newNode.right.
    */
    // Faster than 100%
    // Less than 25%
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null && t2 != null) return t2;
        if (t2 == null && t1 != null) return t1;
        
        TreeNode newNode = new TreeNode(t1.val + t2.val);
        newNode.left = mergeTrees(t1.left, t2.left);
        newNode.right = mergeTrees(t1.right, t2.right);
        
        return newNode;
    }
}