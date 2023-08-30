class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int n = nums.size();
        if (n == 0) return false;
        int end = n - 1;
        int start = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (!isBinarySearchHelpful(nums, start, nums[mid])) {
                start++;
                continue;
            }

            // which array does pivot belong to.
            bool pivotArray = existsInFirst(nums, start, nums[mid]);

            // which array does target belong to.
            bool targetArray = existsInFirst(nums, start, target);
            if (pivotArray ^ targetArray) { // If pivot and target exist in different sorted arrays, recall that xor is true only when both the operands are distinct
                if (pivotArray) {
                    start = mid + 1; // pivot in the first, target in the second
                } else {
                    end = mid - 1; // target in the first, pivot in the second
                }
            } else { // If pivot and target exist in same sorted array
                if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    // returns true if we can reduce the search space in current binary search space
    bool isBinarySearchHelpful(vector<int>& nums, int start, int element) {
        return nums[start] != element;
    }

    // returns true if element exists in first array, false if it exists in second
    bool existsInFirst(vector<int>& nums, int start, int element) {
        return nums[start] <= element;
    }
};