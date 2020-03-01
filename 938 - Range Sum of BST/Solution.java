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
    // Faster than 53%
    // Less than 75%
    // There must be a better optimization given we know that this is a binary search tree
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val >= L && root.val <= R) return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        else return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    /*
    This is very similar to my first submission with a small optimization of the conditional branching. Because we know this is a BST,
    if the right node exists, it must be larger than the root and vice versa for left node. Thus, if upon evaluation of the root's value,
    we see that it is smaller than L, then we only need to look on the right side of the node and vice versa if it is larger.
    */
    // Faster than 100%
    // Less than 67%
    public int rangeSumBST2(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val >= L && root.val <= R) return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        else if (root.val < L)  return rangeSumBST(root.right, L, R);
        else return rangeSumBST(root.left, L, R);
    }
}