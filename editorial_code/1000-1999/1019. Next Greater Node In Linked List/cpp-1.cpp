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
        vector<int> answer;
        vector<pair<int, int>> stk;
        // We use an integer 'cnt' to represent the index.
        int cnt = 0;

        while(head != nullptr){
            // Set the next greate value of the current value 'head.val' as 0 by default.
            answer.push_back(0);
            while(stk.size() && head->val > stk.back().second){
                auto [id, val] = stk.back();
                stk.pop_back();
                answer[id] = head->val;
            }
            // Add both the index and the value to stack.
            stk.push_back({cnt++, head->val});
            head = head->next;
        }
        return answer;
    }
};