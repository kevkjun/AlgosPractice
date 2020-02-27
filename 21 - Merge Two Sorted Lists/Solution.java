/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // This took way too long. This should have been a ten minute question. Took me a few hours 
    // to get the logic down. Just create a new ListNode.
    
    // Faster than 100%
    // Less than 19%
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) return l2;
        if (l1 != null && l2 == null) return l1;
        ListNode res = null;
        if (l1 == null && l2 == null) return res;
        if (l1.val <= l2.val) {
            res = new ListNode(l1.val);
            l1 = l1.next;
        }
        else {
            res = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode res2 = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                res.next = new ListNode(l1.val);
                res = res.next;
                l1 = l1.next;
            }
            else {
                res.next = new ListNode(l2.val);
                res = res.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            while (l2 != null) {
                res.next = new ListNode(l2.val);
                res = res.next;
                l2 = l2.next;
            }
        }
        else if (l2 == null) {
            while (l1 != null) {
                res.next = new ListNode(l1.val);
                res = res.next;
                l1 = l1.next;
            }
        }
        return res2;
    }
}