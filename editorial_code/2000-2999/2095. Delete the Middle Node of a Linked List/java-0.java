class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // Edge case: return None if there is only one node
        if (head.next == null)
            return null;
            
        int count = 0;
        ListNode p1 = head, p2 = head;
        
        // First pass, count the number of nodes in the linked list using 'p1'.
        while (p1 != null) {
            count += 1;
            p1 = p1.next;
        }
        
        // Get the index of the node to be deleted.
        int middleIndex = count / 2;
        
        // Second pass, let 'p2' move toward the predecessor of the middle node.
        for (int i = 0; i < middleIndex - 1; ++i)
            p2 = p2.next;
        
        // Delete the middle node and return 'head'.
        p2.next = p2.next.next;
        return head;
    }
}