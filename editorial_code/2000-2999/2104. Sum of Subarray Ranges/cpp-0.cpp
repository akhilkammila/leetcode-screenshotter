class Solution {
public:
    long long subArrayRanges(vector<int>& nums) {
        int n = int(nums.size());
        long long answer = 0;
        
        for (int left = 0; left < n; ++left) {
            int minVal = nums[left], maxVal = nums[left];
            for (int right = left; right < n; ++right) {
                maxVal = max(maxVal, nums[right]);
                minVal = min(minVal, nums[right]);
                answer += maxVal - minVal;
            }
        }
        
        return answer;
    }
};