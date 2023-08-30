class Solution:
    def printLinkedListInReverse(self, head: 'ImmutableListNode') -> None:
        end = None

        while head != end:
            curr = head
            while curr.getNext() != end:
                curr = curr.getNext()
            curr.printValue()
            end = curr