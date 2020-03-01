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
    General idea is to have two pointers. There are three nodes:
        - Dummy node which acts as the node before the start of the head
        - First pointer which will traverse through list first
        - Second pointer which will maintain n nodes between itself and the first pointer
        
    Traverse the first pointer to the n+1 index (1-indexing), then keep moving the first pointer and second pointer 
    down until first pointer hits the null node. 
    
    At this point, the first pointer is pointing to null node and there are n nodes between the first and second pointers. 
    Implicitly, this says that the second pointer's next node is the nth node. The node that we want to exclude from list.
    
    Make the second pointer's next node equal to the next next node. 
    
    Return dummy.next (head).
    */
    
    // Faster than 100%
    // Less than 6.37%
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node is a holder node to easily point to head of list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;
        
        // Iterate the first node down until hit n+1 node from the front
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        
        // Iterate the first and second node down until first hits null node
        // At this point, the first and second nodes have n nodes between each other. second.next is the node we want to delete.
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        return dummy.next;
    }
}