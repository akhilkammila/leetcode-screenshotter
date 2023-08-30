class Solution {
public:
    int partitionDisjoint(vector<int>& nums) {
        int currMax = nums[0];
        int possibleMax = nums[0];
        int length = 1;
        
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] < currMax) {
                length = i + 1;
                currMax = possibleMax;
            } else {
                possibleMax = max(possibleMax, nums[i]);
            }
        }
        
        return length;
    }
};