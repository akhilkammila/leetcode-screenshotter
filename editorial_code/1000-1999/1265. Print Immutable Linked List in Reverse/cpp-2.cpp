class Solution {
public:
    void printLinkedListInReverseRecursively(ImmutableListNode* head, int size) {
        if (size && head) {
            printLinkedListInReverseRecursively(head->getNext(), size - 1);
            head->printValue();
        }
    }

    int getLinkedListSize(ImmutableListNode* head) {
        int size = 0;
        while (head) {
            size += 1;
            head = head->getNext();
        }
        return size;
    }

    void printLinkedListInReverse(ImmutableListNode* head) {
        int linkedListSize = getLinkedListSize(head);
        int blockSize = ceil(sqrt(linkedListSize));

        stack<ImmutableListNode*> blocks;
        ImmutableListNode* curr = head;
        for (int i = 0; i < linkedListSize; i++) {
            if (i % blockSize == 0) {
                blocks.push(curr);
            }
            curr = curr->getNext();
        }

        while (!blocks.empty()) {
            printLinkedListInReverseRecursively(blocks.top(), blockSize);
            blocks.pop();
        }
    }
};