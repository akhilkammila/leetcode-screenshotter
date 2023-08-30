class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:  
        # Edge case: return None if there is only one node.
        if head.next == None:
            return None
        
        count = 0
        p1 = p2 = head
        
        # First pass, count the number of nodes in the linked list using 'p1'.
        while p1:
            count += 1
            p1 = p1.next
        
        # Get the index of the node to be deleted.
        middle_index = count // 2
        
        # Second pass, let 'p2' move toward the predecessor of the middle node.
        for _ in range(middle_index - 1):
            p2 = p2.next
        
        # Delete the middle node and return 'head'.
        p2.next = p2.next.next
        return head