class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        // Number of zero's in the window.
        int zeroCount = 0;
        int longestWindow = 0;
        // Left end of the window.
        int start = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            zeroCount += (nums[i] == 0);
                          
            // Shrink the window until the zero counts come under the limit.
            while (zeroCount > 1) {
                zeroCount -= (nums[start] == 0);
                start++;
            }
              
            longestWindow = max(longestWindow, i - start);
        }

        return longestWindow;
    }
};