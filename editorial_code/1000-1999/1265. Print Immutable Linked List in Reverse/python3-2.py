class Solution:
    def printLinkedListInReverseRecursively(self, head: 'ImmutableListNode', size: int) -> None:
        if size > 0 and head is not None:
            self.printLinkedListInReverseRecursively(head.getNext(), size - 1)
            head.printValue()

    def getLinkedListSize(self, head: 'ImmutableListNode') -> int:
        size = 0
        while head is not None:
            size += 1
            head = head.getNext()
        return size

    def printLinkedListInReverse(self, head: 'ImmutableListNode') -> None:
        linked_list_size = self.getLinkedListSize(head)
        block_size = math.ceil(math.sqrt(linked_list_size))

        blocks = []
        curr = head
        for i in range(linked_list_size):
            if i % block_size == 0:
                blocks.append(curr)
            curr = curr.getNext()

        while blocks:
            self.printLinkedListInReverseRecursively(blocks.pop(), block_size)