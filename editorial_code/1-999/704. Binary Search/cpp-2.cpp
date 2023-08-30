class Solution {
public:
    int search(vector<int>& nums, int target) {
        // Set the left and right boundaries
        int left = 0, right = int(nums.size());
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        if (left < nums.size() and nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
};