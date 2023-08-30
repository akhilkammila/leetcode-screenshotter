class Solution {
public:
    int validSubarrays(vector<int>& nums) {
        int ans = 0;
        
        stack<int> st;
        for (int i = 0; i < nums.size(); i++) {
            // Keep popping elements from the stack
            // until the current element becomes greater than the top element.
            while (!st.empty() && nums[i] < nums[st.top()]) {
                // The diff between the current index and the stack top would be the subarray size.
                // Which is equal to the number of subarrays.
                ans += (i - st.top());
                st.pop();
            }
            st.push(i);
        }
        
        // For all remaining elements, the last element will be considered as the right endpoint.
        while (!st.empty()) {
            ans += (nums.size() - st.top());
            st.pop();
        }
        
        return ans;
    }
};