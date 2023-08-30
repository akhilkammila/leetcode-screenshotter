class Solution {
public:
    int store(vector<int>& nums, int cur) {
        if (cur == nums[cur])
            return cur;
        int nxt = nums[cur];
        nums[cur] = cur;
        return store(nums, nxt);
    }
    
    int findDuplicate(vector<int>& nums) {
        return store(nums, 0);
    }
};