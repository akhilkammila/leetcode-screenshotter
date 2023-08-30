// returns true if element exists in first array, false if it exists in second
bool existsInFirst(vector<int>& nums, int start, int element) {
    return nums[start] <= element;
}