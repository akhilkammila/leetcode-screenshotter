class Solution {
public:
    int pairSum(ListNode* head) {
        ListNode* current = head;
        vector<int> values;

        while (current) {
            values.push_back(current->val);
            current = current->next;
        }

        int i = 0, j = values.size() - 1;
        int maximumSum = 0;
        while (i < j) {
            maximumSum = max(maximumSum, values[i] + values[j]);
            i++;
            j--;
        }

        return maximumSum;
    }
};