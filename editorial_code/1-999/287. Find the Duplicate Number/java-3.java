class Solution {    
    public int store(int[] nums, int cur) {
        if (cur == nums[cur])
            return cur;
        int nxt = nums[cur];
        nums[cur] = cur;
        return store(nums, nxt);        
    }
    
    public int findDuplicate(int[] nums) {
        return store(nums, 0);
    }
}