class Solution {
public:
    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        int n = piles.size();
        function<int(int, int)> f = [&](int i, int coins) {
            if (i == 0) {
                return 0;
            }
            int result = 0, currentSum = 0;
            for (int currentCoins = 0; currentCoins <= min((int)piles[i - 1].size(), coins); currentCoins++) {
                if (currentCoins > 0) {
                    currentSum += piles[i - 1][currentCoins - 1];
                }
                result = max(result, f(i - 1, coins - currentCoins) + currentSum);
            }
            return result;
        };
        return f(n, k);
    }
};