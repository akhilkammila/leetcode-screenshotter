class Solution {
public:
    int maxSatisfaction(vector<int>& satisfaction) {
        sort(satisfaction.begin(), satisfaction.end());
        
        // Array to keep the result for the previous iteration.
        vector<int> prev(satisfaction.size() + 2, 0);
        for (int index = satisfaction.size() - 1; index >= 0; index--) {
            // Array to keep the result for the current iteration.
            vector<int> dp(satisfaction.size() + 2);
            
            for (int time = 1; time <= satisfaction.size(); time++) {
                // Maximum of two choices:
                // 1. Cook the dish at `index` with the time taken as `time` and move on to the next dish with time as time + 1.
                // 2. Skip the current dish and move on to the next dish at the same time.
                dp[time] = max(satisfaction[index] * time + prev[time + 1], prev[time]);
            }
            // Assign the current iteration result to prev to be used in the next iteration.
            prev = dp;
        }
        // dp and prev have the same value here, but dp is not defined at this scope.
        return prev[1];
    }
};