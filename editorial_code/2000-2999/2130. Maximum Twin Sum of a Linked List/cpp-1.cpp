class Solution {
public:
    int pairSum(ListNode* head) {
        ListNode* current = head;
        stack<int> st;

        while (current) {
            st.push(current->val);
            current = current->next;
        }

        current = head;
        int size = st.size(), count = 1;
        int maximumSum = 0;
        while (count <= size / 2) {
            maximumSum = max(maximumSum, current->val + st.top());
            current = current->next;
            st.pop();
            count++;
        }

        return maximumSum;
    }
};