class Solution {
public:
    vector<long long> minimumCosts(vector<int>& regular, vector<int>& express, int expressCost) {
        int N = regular.size() + 1;
        vector<long long> ans;
        
        long dp[N][2];
        dp[0][1] = 0;
        // Need to spend expressCost, as we start from the regular lane initially.
        dp[0][0] = expressCost;
        
        for (int i = 1; i < N; i++) {
            // Use the regular lane; no extra cost to switch to the express lane.
            dp[i][1] = regular[i - 1] + min(dp[i - 1][1], dp[i - 1][0]);
            // Use express lane; add extra cost if the previously regular lane was used.
            dp[i][0] = express[i - 1] + min(expressCost + dp[i - 1][1], dp[i - 1][0]);
            
            ans.push_back(min(dp[i][0], dp[i][1]));
        }
        return ans; 
    }
};