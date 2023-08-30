class Solution {
public:
    unordered_map<int, int> mark;
    int dp[2001][2001];

    bool canCross(vector<int>& stones) {
        int n = stones.size();
        // Mark stones in the map to identify if such stone exists or not.
        for (int i = 0 ; i < n; i++) {
            mark[stones[i]] = i;
        }
        
        dp[0][0] = 1;
        for (int index = 0; index < n; index++) {
            for (int prevJump = 0; prevJump <= n; prevJump++) {
                // If stone exists, mark the value with position and jump as 1.
                if (dp[index][prevJump]) {
                    if (mark[stones[index] + prevJump]) {
                        dp[mark[stones[index] + prevJump]][prevJump] = 1;
                    }
                    if (mark[stones[index] + prevJump + 1]) {
                        dp[mark[stones[index] + prevJump + 1]][prevJump + 1] = 1;
                    }
                    if (mark[stones[index] + prevJump - 1]) {
                        dp[mark[stones[index] + prevJump - 1]][prevJump - 1] = 1;
                    }
                }
                
                
            }
        }
        
        // If any value with index as n - 1 is true, return true.
        for (int prevJump = 0; prevJump <= n; prevJump++) {
            if (dp[n - 1][prevJump]) {
                return true;
            }
        }
        return false;
    }
};