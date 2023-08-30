class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
    	// initialize the hash map with index 0 for sum 0
        unordered_map<int, int> hashMap{{0, 0}};
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            // if the remainder sum % k occurs for the first time
            if (!hashMap.count(sum % k))
                hashMap[sum % k] = i + 1;
            // if the subarray size is at least two
            else if (hashMap[sum % k] < i)
                return true;
        }
        return false;
    }
};