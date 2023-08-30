/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    vector<int> nextLargerNodes(ListNode* head) {
        vector<int> values;
        while (head != nullptr) {
            values.push_back(head->val);
            head = head->next;
        }
        
        int n = int(values.size());
        stack<int> iStack;
        vector<int> answer(n);
        
        for (int i = 0; i < n; ++i) {
            while (!iStack.empty() && values[iStack.top()] < values[i]) {
                int smaller = iStack.top();
                iStack.pop();
                answer[smaller] = values[i];
            }
            iStack.push(i);
        }
        
        return answer;
    }
};