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
    Think of splitting the tree down the middle and folding it over vertically.
    
    Uses DFS to get to the bottom of the tree and compare the left side to the right side. 
    Requires a helper function with two node arguments because we need the nodes to move down the tree at the same rate (be at the same level).
    Having a helper function with only one node argument would not be possible.
    
    t1 and t2 are originally the root's left and right branches. The return statement in helper function checks
    the current t1 and t2 values then recursively calls helper to move down the tree in opposite directions.
    */
    // Faster than 100%
    // Less than 72%
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        
        return (t1.val == t2.val) && 
            helper(t1.left, t2.right) &&
            helper(t1.right, t2.left);
    }

    /*
    This is like BFS in that we are checking each node and adding its children.
    The if statements are incredibly important and the order in which we add the nodes is important.
    */
    // Faster than 27%
    // Less than 68%
    public boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode n = queue.poll();
            TreeNode n2 = queue.poll();
            if (n == null && n2 == null) continue;
            if (n == null || n2 == null) return false;
            if (n.val != n2.val) return false;
            queue.offer(n.left);
            queue.offer(n2.right);
            queue.offer(n.right);
            queue.offer(n2.left);
        }
        return true;
    }
}