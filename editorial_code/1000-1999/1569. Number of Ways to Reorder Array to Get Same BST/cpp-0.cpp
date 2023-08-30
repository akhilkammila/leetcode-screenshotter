class Solution {
public:
    int numOfWays(vector<int>& nums) {
        int m = nums.size();
        // Table of Pascal's triangle
        table.resize(m + 1);
        for(int i = 0; i < m + 1; ++i) {
            table[i] = vector<long long>(i + 1, 1);
            for(int j = 1; j < i; ++j) {
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % mod;
            }
        }
        
        return (dfs(nums) - 1) % mod;
    }
    
private:
    vector<vector<long long>> table;
    long long mod = 1e9 + 7;
    
    long long dfs(vector<int> &nums){
        int m = nums.size();
        if(m < 3) {
            return 1;
        }

        vector<int> leftNodes, rightNodes;
        for(int i = 1; i < m; ++i){
            if (nums[i] < nums[0]) {
                leftNodes.push_back(nums[i]);
            } else {
                rightNodes.push_back(nums[i]);
            }
        }
		
        long long leftWays = dfs(leftNodes) % mod;
        long long rightWays = dfs(rightNodes) % mod;
		
        return (((leftWays * rightWays) % mod) * table[m - 1][leftNodes.size()]) % mod;
    }
};