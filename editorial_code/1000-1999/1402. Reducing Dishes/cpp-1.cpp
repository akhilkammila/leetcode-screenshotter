class Solution {
public:
    int maxSatisfaction(vector<int>& satisfaction) {
        sort(satisfaction.begin(), satisfaction.end());
        
        // Mark all the states initially as 0.
        vector<vector<int>> dp(satisfaction.size() + 1, vector<int>(satisfaction.size() + 2, 0));
        for (int index = satisfaction.size() - 1; index >= 0; index--) {
            for (int time = 1; time <= satisfaction.size(); time++) {
                // Maximum of two choices:
                // 1. Cook the dish at `index` with the time taken as `time` and move on to the next dish with time as time + 1.
                // 2. Skip the current dish and move on to the next dish at the same time.
                dp[index][time] = max(satisfaction[index] * time + dp[index + 1][time + 1], dp[index + 1][time]);
            }
        }
        return dp[0][1];
    }
};