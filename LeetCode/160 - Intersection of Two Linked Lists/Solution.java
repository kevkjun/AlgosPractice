/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /*
    Iterate through the linked lists separately. 
    Once reach the end of one list move to the other one.
    If there is an intersection, the nodes will equal each other. 
    
    The total length traveled by both a and b pointers will be a.length + b.length so if they do not 
    intersect then they will both equal null at the end. 
    */
    
    // Faster than 95%
    // Less than 5%
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode a = headA, b = headB;
        
        // 
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        
        return a;
    }
}