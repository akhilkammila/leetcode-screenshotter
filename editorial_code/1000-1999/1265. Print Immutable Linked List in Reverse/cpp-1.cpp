class Solution {
public:
    void printLinkedListInReverse(ImmutableListNode* head) {
        stack<ImmutableListNode*> s;
        while (head) {
            s.push(head);
            head = head->getNext();
        }

        while (!s.empty()) {
            ImmutableListNode* node = s.top();
            s.pop();
            node->printValue();
        }
    }
};