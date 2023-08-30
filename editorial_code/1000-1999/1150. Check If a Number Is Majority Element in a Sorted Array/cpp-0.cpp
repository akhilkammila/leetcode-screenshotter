class Solution {
public:
    bool isMajorityElement(vector<int>& nums, int target) {
        int count = 0;
        for (int num : nums) {
            count = num == target ? count + 1 : count;
        }
        
        return count > nums.size() / 2;
    }
};