class Solution {
public:
    vector<int> coins;
    vector<vector<int>> memo;

    int numberOfWays(int i, int amount) {
        if (amount == 0) {
            return 1;
        }
        if (i == coins.size()) {
            return 0;
        }
        if (memo[i][amount] != -1) {
            return memo[i][amount];
        }

        if (coins[i] > amount) {
            return memo[i][amount] = numberOfWays(i + 1, amount);
        }

        memo[i][amount] = numberOfWays(i, amount - coins[i]) + numberOfWays(i + 1, amount);
        return memo[i][amount];
    }

    int change(int amount, vector<int>& coins) {
        this->coins = coins;
        memo = vector<vector<int>>(coins.size(), vector<int>(amount + 1, -1));
        return numberOfWays(0, amount);
    }
};