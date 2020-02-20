/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    Almost always will need two pointers to work with a linked list. In this case, we are swapping nodes
    in place by keeping track of the next node with the "next" ListNode, swapping the next ListNode
    in the linked list and iterating the present "head" forward. 
    */
    
    // Faster than 100%
    // Less than 5%
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, next = null;
        
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }
}