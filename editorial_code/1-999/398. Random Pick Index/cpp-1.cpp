class Solution {
private:

    unordered_map<int, vector<int>> indices;

public:
    
    Solution(vector<int>& nums) {
        int l = nums.size();
        for (int i = 0; i < l; ++i) {
            this->indices[nums[i]].push_back(i);
        }
    }
    
    int pick(int target) {
        int l = indices[target].size();
        // pick an index at random
        int randomIndex = indices[target][rand() % l];
        return randomIndex;
    }
};