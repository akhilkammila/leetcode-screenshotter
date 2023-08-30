class Solution {
public:
    int distinctSubseqII(string s) {
        const int N = s.length();
        const int MOD = 1e9 + 7;
        
        vector<int> dp(N+1);
        dp[0] = 1;
        vector<int> last(26, -1);
        
        for(int i = 0; i < N; i++){
            int x = s[i] - 'a';
            dp[i+1] = dp[i] * 2 % MOD;
            if(last[x] >= 0) // if this is the first occurence of ch
                dp[i+1] -= dp[last[x]];
            dp[i+1] %= MOD;
            last[x] = i;
        }
        dp[N]--;
        if(dp[N] < 0) dp[N] += MOD;
        return dp[N];
    }
};