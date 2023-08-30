// returns true if we can reduce the search space in current binary search space
bool isBinarySearchHelpful(vector<int>& nums, int start, int element) {
    return nums[start] != element;
}