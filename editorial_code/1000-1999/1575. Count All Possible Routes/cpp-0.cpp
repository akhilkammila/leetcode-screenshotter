class Solution {
public:
    int solve(vector<int>& locations, int currCity, int finish, int remainingFuel,
              vector<vector<int>>& memo) {
        if (remainingFuel < 0) {
            return 0;
        }
        if (memo[currCity][remainingFuel] != -1) {
            return memo[currCity][remainingFuel];
        }

        int ans = currCity == finish ? 1 : 0;
        for (int nextCity = 0; nextCity < locations.size(); nextCity++) {
            if (nextCity != currCity) {
                ans = (ans + solve(locations, nextCity, finish,
                                   remainingFuel - abs(locations[currCity] - locations[nextCity]),
                                   memo)) % 1000000007;
            }
        }

        return memo[currCity][remainingFuel] = ans;
    }

    int countRoutes(vector<int>& locations, int start, int finish, int fuel) {
        int n = locations.size();
        vector<vector<int>> memo(n, vector<int>(fuel + 1, -1));

        return solve(locations, start, finish, fuel, memo);
    }
};