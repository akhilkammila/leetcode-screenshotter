class Solution:
    def helper(self, start: 'ImmutableListNode', end: 'ImmutableListNode') -> None:
        if start is None or start == end:
            return
        if start.getNext() == end:
            start.printValue()
            return

        slow = start
        fast = start

        while fast != end and fast.getNext() != end:
            slow = slow.getNext()
            fast = fast.getNext().getNext()

        self.helper(slow, end)
        self.helper(start, slow)

    def printLinkedListInReverse(self, head: 'ImmutableListNode') -> None:
        self.helper(head, None)