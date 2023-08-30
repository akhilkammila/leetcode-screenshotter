class Solution {
    public int validSubarrays(int[] nums) {
        int ans = 0;
        
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            // Keep popping elements from the stack
            // until the current element becomes greater than the top element.
            while(!st.isEmpty() && nums[i] < nums[st.peek()]) {
                // The diff between the current index and the stack top would be the subarray size.
                // Which is equal to the number of subarrays.
                ans += (i - st.peek());
                st.pop();
            }
            st.push(i);
        }
        
        // For all remaining elements, the last element will be considered as the right endpoint.
        while (!st.isEmpty()) {
            ans += (nums.length - st.peek());
            st.pop();
        }
        
        return ans;
    }
}