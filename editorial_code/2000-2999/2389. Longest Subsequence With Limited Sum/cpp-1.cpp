class Solution {
public:
    vector<int> answerQueries(vector<int>& nums, vector<int>& queries) {
        // Get the prefix sum array of the sorted 'nums'.
        sort(nums.begin(), nums.end());
        for (int i = 1; i < nums.size(); ++i)
            nums[i] += nums[i - 1];
        
        // For each query, find its insertion index to the prefix sum array.
        vector<int> answer;
        for (auto query : queries) {
            int index = upper_bound(nums.begin(), nums.end(), query) - nums.begin();
            answer.push_back(index);
        }
        
        return answer;
    }
};