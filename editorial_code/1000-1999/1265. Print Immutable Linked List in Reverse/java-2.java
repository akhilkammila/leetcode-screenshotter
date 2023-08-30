class Solution {
    private void printLinkedListInReverseRecursively(ImmutableListNode head, int size) {
        if (size > 0 && head != null) {
            printLinkedListInReverseRecursively(head.getNext(), size - 1);
            head.printValue();
        }
    }

    private int getLinkedListSize(ImmutableListNode head) {
        int size = 0;
        while (head != null) {
            size += 1;
            head = head.getNext();
        }
        return size;
    }

    public void printLinkedListInReverse(ImmutableListNode head) {
        int linkedListSize = getLinkedListSize(head);
        int blockSize = (int) Math.ceil(Math.sqrt(linkedListSize));

        Stack<ImmutableListNode> blocks = new Stack<>();
        ImmutableListNode curr = head;
        for (int i = 0; i < linkedListSize; i++) {
            if (i % blockSize == 0) {
                blocks.push(curr);
            }
            curr = curr.getNext();
        }

        while (!blocks.empty()) {
            printLinkedListInReverseRecursively(blocks.pop(), blockSize);
        }
    }
}