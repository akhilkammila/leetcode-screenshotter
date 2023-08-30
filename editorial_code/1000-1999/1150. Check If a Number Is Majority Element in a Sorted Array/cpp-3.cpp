class Solution {
public:
    // Returns the index of the first element equal to or greater than the target.
    // If there is no instance of the target in the list, it returns the length of the list.
    int lower_bound(vector<int>& nums, int target) {
        int start = 0;
        int end = nums.size() - 1;
        int index = nums.size();
            
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (nums[mid] >= target) {
                end = mid - 1;
                index = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return index;
    }
    
    bool isMajorityElement(vector<int>& nums, int target) {
        int firstIndex = lower_bound(nums, target);
        
        return firstIndex + nums.size() / 2 < nums.size() && nums[firstIndex + nums.size() / 2] == target;
    }
};