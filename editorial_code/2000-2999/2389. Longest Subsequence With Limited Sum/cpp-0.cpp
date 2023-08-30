class Solution {
public:
    vector<int> answerQueries(vector<int>& nums, vector<int>& queries) {
        // Sort 'nums'
        sort(nums.begin(), nums.end());
        
        // For each query, collect numbers from lowest to highest.
        // If their sum exceeds the limit 'query', move on to the next query.
        vector<int> ans;
        for (auto query : queries) {
            int count = 0;
            for (auto num : nums) {
                if (query >= num) {
                    query -= num;
                    count++;
                }
                else {
                    break;
                }
            }
            ans.push_back(count);
        }
        
        return ans;
    }
};