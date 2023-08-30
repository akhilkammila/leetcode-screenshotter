class Solution {
public:
    void printLinkedListInReverse(ImmutableListNode* head) {
        if (head != NULL) {
            printLinkedListInReverse(head->getNext());
            head->printValue();
        }
    }
};