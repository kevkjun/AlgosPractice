/*
Create a Node struct which abstracts the min, val, constructor, and next Node away from the MinStack.
*/
// Faster than 97%
// Less than 10%
class MinStack {
    class Node {
        int min;
        int val;
        Node next = null;
        Node(int val) {this.val = val;}
    }
    
    Node head;

    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
        if (head == null) {
            head = new Node(x);
            head.min = x;
            return;
        }
        Node prevHead = new Node(head.val);
        prevHead.min = head.min;
        prevHead.next = head.next;
        head.val = x;
        head.next = prevHead;
        head.min = Math.min(x, prevHead.min);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        if (head == null) return 0;
        return head.val;
    }
    
    public int getMin() {
        if (head == null) return 0;
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */