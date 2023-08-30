class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {
        int n = prices.size();
        int free = 0, hold = -prices[0];
        
        for (int i = 1; i < n; i++) {
            int tmp = hold;
            hold = max(hold, free - prices[i]);
            free = max(free, tmp + prices[i] - fee);
        }
        
        return free;
    }
};