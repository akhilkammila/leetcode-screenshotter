class Solution {
public:
    int minimumAverageDifference(vector<int>& nums) {
        int n = int(nums.size());
        int ans = -1;
        int minAvgDiff = numeric_limits<int>::max();
        
        for (int index = 0; index < n; ++index) {
            // Calculate average of left part of array, index 0 to i.
            long long leftPartAverage = 0;
            for (int i = 0; i <= index; ++i) {
                leftPartAverage += nums[i];
            }
            leftPartAverage /= (index + 1);
            
            // Calculate average of right part of array, index i+1 to n-1.
            long long rightPartAverage = 0;
            for (int j = index + 1; j < n; ++j) {
                rightPartAverage += nums[j];
            }
            // If right part have 0 elements, then we don't divide by 0.
            if (index != n - 1) {
                rightPartAverage /= (n - index - 1);
            }
            
            int currDifference = int(abs(leftPartAverage - rightPartAverage));
            // If current difference of averages is smaller,
            // then current index can be our answer.
            if (currDifference < minAvgDiff) {
                minAvgDiff = currDifference;
                ans = index;
            }
        }
        
        return ans;
    }
};