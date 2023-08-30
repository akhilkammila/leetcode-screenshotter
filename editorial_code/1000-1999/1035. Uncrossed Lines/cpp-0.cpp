class Solution {
public:
    int solve(int i, int j, vector<int>& nums1, vector<int>& nums2, vector<vector<int>>& memo) {
        if (i <= 0 || j <= 0) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (nums1[i - 1] == nums2[j - 1]) {
            memo[i][j] = 1 + solve(i - 1, j - 1, nums1, nums2, memo);
        } else {
            memo[i][j] =
                max(solve(i, j - 1, nums1, nums2, memo), solve(i - 1, j, nums1, nums2, memo));
        }
        return memo[i][j];
    }

    int maxUncrossedLines(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();

        vector<vector<int>> memo(n1 + 1, vector<int>(n2 + 1, -1));

        return solve(n1, n2, nums1, nums2, memo);
    }
};