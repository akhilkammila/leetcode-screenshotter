class Solution {
public:
    unordered_set<int> isTravelNeeded;
    
    int solve(vector<int>& dp, vector<int>& days, vector<int>& costs, int currDay) {
        // If we have iterated over travel days, return 0.
        if (currDay > days[days.size() - 1]) {
            return 0;
        }
        
        // If we don't need to travel on this day, move on to next day.
        if (isTravelNeeded.find(currDay) == isTravelNeeded.end()) {
            return solve(dp, days, costs, currDay + 1);
        }
        
        // If already calculated, return from here with the stored answer.
        if (dp[currDay] != -1) {
            return dp[currDay];
        }
        
        int oneDay = costs[0] + solve(dp, days, costs, currDay + 1);
        int sevenDay = costs[1] + solve(dp, days, costs, currDay + 7);
        int thirtyDay = costs[2] + solve(dp, days, costs, currDay + 30);
        
        // Store the cost with the minimum of the three options.
        return dp[currDay] = min(oneDay, min(sevenDay, thirtyDay));
    }
    
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        // The last day on which we need to travel.
        int lastDay = days[days.size() - 1];
        vector<int> dp(lastDay + 1, -1);
        
        // Mark the days on which we need to travel.
        for (int day : days) {
            isTravelNeeded.insert(day);
        }
        
        return solve(dp, days, costs, 1);
    }
};