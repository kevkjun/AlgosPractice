/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // Faster than 100%
    // Less than 5%
    /*
    Need to be checking two nodes ahead to make sure that you've got somewhere to go.
    Loop through all the nodes and take the next node's value. Make the last node null.
    */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        if (node.next.next == null) {
            node.next = null;
            return;
        }
        while (node.next != null) {
            if (node.next.next == null) {
                node.next = null;
                return;
            }
            node.next.val = node.next.next.val;
            node = node.next;
        }
    }
}