// Returns the index of the first element that is equal to or greater than the target.
// If there is no instance of the target in the list, it returns the length of the list.
class Solution {
    int lower_bound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = nums.length;
            
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
    
    public boolean isMajorityElement(int[] nums, int target) {
        int firstIndex = lower_bound(nums, target);
        
        return firstIndex + nums.length / 2 < nums.length && nums[firstIndex + nums.length / 2] == target;
    }
}