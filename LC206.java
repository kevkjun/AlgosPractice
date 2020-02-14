/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    final class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }

     //Iterative solution
    public ListNode reverseList(ListNode head) {       
        ListNode prevHead = null, next = null;

        while (head != null) {
            next = head.next; //holding variable - need to remember head.next because we will be changing it in next line
            head.next = prevHead; //make the next node the previous head (think of rotating around the head: 1 -> 2 -> 3 becomes 3 -> 2 -> 1)
            //Line 19 works because we are "in essence" making two linkedlists. we are continuously taking nodes from the original linkedlist and appending the beginning of the original linked list to it
            //1 -> 2 -> 3 -> null ===> 1 -> null and 2 -> 3 -> null ====> 2 -> 1 -> null and 3 -> null
            prevHead = head; //traverse down the linkedlist
            head = next; //traverse down the linkedlist
        }
        
        return prevHead;
    }

    //Recursive solution
    /*
    This solution is confusing because we are calling reverseListRec on head.next;
    Once we reach the end of the linked list, we still know that the head was the node previous to the one that was just recursively called. 
    The base case of this function is reaching the last node of the linked list. 

    When we move into head.next.next, we are rotating the previously called node around the base of the linkedlist, making it the next value of the base node.

    1 -> 2
    2 is returned as the newHead
    2's next node is made 1
    1's next node is made null
    Function exits by returning 2
    */
    public ListNode reverseListRec(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode newHead = reverseListRec(head.next);
        
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
}