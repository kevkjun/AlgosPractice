public class Solution {
    /*
    Keep two pointers. One is the pointer to the head. The other is a pointer (next) to a node that is advancing twice as fast as the
    pointer to the head. 
    
    Because the second pointer moves twice as fast the first, by the time the first node has reached the middle of the list, 
    the faster pointer will reach the end. 
    
    Eventually, the pointers will be pointing at the same node at which point the loop will return true.
    */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        
        ListNode next = head.next;
        while (next.next != null && next.next.next != null) {
            if (head == next) return true;
            head = head.next;
            next = next.next.next;
        } 
        return false;
    }
}  