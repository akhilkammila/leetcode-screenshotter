class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        while head.next:
            head = head.next
            # TODO