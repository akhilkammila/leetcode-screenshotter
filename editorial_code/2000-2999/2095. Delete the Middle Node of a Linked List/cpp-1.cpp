class Solution {
public:
    ListNode* deleteMiddle(ListNode* head) {
        // Edge case: return nullptr if there is only one node.
        if (head -> next == nullptr)
            return nullptr;
        
        // Initialize two pointers, 'slow' and 'fast'.
        ListNode *slow = head, *fast = head -> next -> next;
        
        // Let 'fast' move forward by 2 nodes, 'slow' move forward by 1 node each step.
        while (fast != nullptr && fast -> next != nullptr) {
            slow = slow -> next;
            fast = fast -> next -> next;
        }
        
        // When 'fast' reaches the end, remove the next node of 'slow' and return 'head'.
        slow -> next = slow -> next -> next;
        return head;
    }
};