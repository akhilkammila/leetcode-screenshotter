class Solution {
public:
    int dfs(int i, vector<int>& distribute, vector<int>& cookies, int k, int zeroCount) {
        // If there are not enough cookies remaining, return INT_MAX 
        // as it leads to an invalid distribution.
        if (cookies.size() - i < zeroCount) {
            return INT_MAX;
        }

        // After distributing all cookies, return the unfairness of this
        // distribution.
        if (i == cookies.size()) {
            return *max_element(distribute.begin(), distribute.end());
        }

        // Try to distribute the i-th cookie to each child, and update answer
        // as the minimum unfairness in these distributions.
        int answer = INT_MAX;
        for (int j = 0; j < k; ++j) {
            zeroCount -= distribute[j] == 0 ? 1 : 0;
            distribute[j] += cookies[i];
            
            // Recursively distribute the next cookie.
            answer = min(answer, dfs(i + 1, distribute, cookies, k, zeroCount)); 
            
            distribute[j] -= cookies[i];
            zeroCount += distribute[j] == 0 ? 1 : 0;
        }
        
        return answer;
    }
    
    int distributeCookies(vector<int>& cookies, int k) {
        vector<int> distribute(k, 0);

        return dfs(0, distribute, cookies, k, k);
    }
};