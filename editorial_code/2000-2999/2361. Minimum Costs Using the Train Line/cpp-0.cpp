class Solution {
public:
    long solve(int i, int lane, long dp[][2], vector<int>& regular, vector<int>& express, int expressCost) {
        // If all stops are covered, return 0.
        if (i < 0) {
            return 0;
        }
        
        if (dp[i][lane] != -1) {
            return dp[i][lane];
        }
        
        // Use the regular lane; no extra cost to switch lanes if required.
        long regularLane = regular[i] + solve(i - 1, 1, dp, regular, express, expressCost);
        // Use express lane; add expressCost if the previously regular lane was used.
        long expressLane = (lane ? expressCost : 0) + express[i] 
                                                    + solve(i - 1, 0, dp, regular, express, expressCost);

        return dp[i][lane] = min(regularLane, expressLane);
    }
    
    vector<long long> minimumCosts(vector<int>& regular, vector<int>& express, int expressCost) {
        long dp[regular.size()][2];
        memset(dp, -1, sizeof(dp));
        
        solve(regular.size() - 1, 1, dp, regular, express, expressCost);
        
        // Store cost for each stop.
        vector<long long> ans;
        for (int i = 0 ; i < regular.size(); i++) {
            ans.push_back(dp[i][1]);
        }
        
        return ans;
    }
};