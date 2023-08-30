class Solution {
    const static int m = 1'000'000'007;

public:
    int numberOfWays(int numPeople) {
        vector<int> dp(numPeople / 2 + 1, -1);
        dp[0] = 1;
        
        function<int(int)> calculateDP = [&](int i) -> int {
            if (dp[i] != -1) {
                return dp[i];
            }
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                (dp[i] += (long long)calculateDP(j) * calculateDP(i - j - 1) % m) %= m;
            }
            return dp[i];
        };
        
        return calculateDP(numPeople / 2);
    }
};