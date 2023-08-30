class Solution {
    // Returns the index of the first element equal to or greater than the target.
    // If there is no instance of the target in the list, it returns the length of the list.
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
    
    // Returns the index of the first element greater than the target.
    // If there is no instance of the target in the list, it returns the length of the list.
    int upper_bound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = nums.length;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (nums[mid] > target) {
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
        int nextToLastIndex = upper_bound(nums, target);
        
        return nextToLastIndex - firstIndex > nums.length / 2;
    }
}