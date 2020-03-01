// Insert into a sorted linked list
class Solution {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    /*
    Pretty simple idea: 
        - Base case is if the head is null, then just create a new node and make that the head.
        - We traverse the linked list until encountering a node which is greater than or equal to n --OR-- the next 
            node is null. Once we find a node that fulfills these conditions, there are two possibilities:
            (1) The current node is still <= n, which is the easy case, and we just splice n behind that node.
            (2) The current node is larger, but we've stopped because the next node is null (end of the list). This is
            why we are using "technically" three pointers (currHead, prevHead, and original head). prevHead lags 
            currHead by one node so we always have a pointer back to the previous node. If we encounter this situation
            where current node is larger, we use prevHead and currHead to splice n into the list. 


    We can actually optimize this by just looking forward to the next node. If we're comparing the next node's value to n, then we don't need to worry about any of the cases posed above. 
    */

    static ListNode insertNode(ListNode head, int n) {
        ListNode newNode = new ListNode(n);

        // Check if the head is null (the list is empty).
        if (head == null) return newNode;

        // Check right away if the node can be pushed in at the beginning.
        if (head.val >= n) {
            newNode.next = head;
            return newNode;
        }

        ListNode currHead = head;
        
        /* The null check NEEDS to be before the value check because Java shortcircuits the && check if the first clause fails. If the value check is first,
        there will be a null pointer exception if the next node is null. */
        while (currHead.next != null && currHead.next.val < n) {
            currHead = currHead.next;
        }
        newNode.next = currHead.next;
        currHead.next = newNode;
        return head;
    }

    static void print(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        System.out.println(head.val);
        print(head.next);
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(10);
        ListNode newHead = insertNode(head, 11);
        print(newHead);
    }
}