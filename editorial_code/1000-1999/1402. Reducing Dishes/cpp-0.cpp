class Solution {
public:
    int findMaxSatisfaction(vector<int>& satisfaction, vector<vector<int>>& memo, int index, int time) {
        // Return 0 if we have iterated over all the dishes.
        if (index == satisfaction.size()) {
            return 0;
        }
        
        // We have already calculated the answer, so no need to go into recursion.
        if (memo[index][time] != -1) {
            return memo[index][time];
        }
        
        // Return the maximum of two choices:
        // 1. Cook the dish at `index` with the time taken as `time` and move on to the next dish with time as time + 1.
        // 2. Skip the current dish and move on to the next dish at the same time.
        return memo[index][time] = max(satisfaction[index] * time + findMaxSatisfaction(satisfaction, memo, index + 1, time + 1), 
                                       findMaxSatisfaction(satisfaction, memo, index + 1, time));
    }
    
    int maxSatisfaction(vector<int>& satisfaction) {
        sort(satisfaction.begin(), satisfaction.end());

        // Mark, all the states as -1, denoting not yet calculated.
        vector<vector<int>> memo(satisfaction.size() + 1, vector<int>(satisfaction.size() + 1, -1));
        
        return findMaxSatisfaction(satisfaction, memo, 0, 1);
    }
};