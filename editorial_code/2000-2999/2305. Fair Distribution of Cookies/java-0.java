class Solution {
    private int dfs(int i, int[] distribute, int[] cookies, int k, int zeroCount) {
        // If there are not enough cookies remaining, return Integer.MAX_VALUE
        // as it leads to an invalid distribution.
        if (cookies.length - i < zeroCount) {
            return Integer.MAX_VALUE;   
        }

        // After distributing all cookies, return the unfairness of this
        // distribution.
        if (i == cookies.length) {
            int unfairness = Integer.MIN_VALUE;
            for (int value : distribute) {
                unfairness = Math.max(unfairness, value);
            }
            return unfairness;
        }
        
        // Try to distribute the i-th cookie to each child, and update answer
        // as the minimum unfairness in these distributions.
        int answer = Integer.MAX_VALUE;
        for (int j = 0; j < k; ++j) {
            zeroCount -= distribute[j] == 0 ? 1 : 0;
            distribute[j] += cookies[i];
            
            // Recursively distribute the next cookie.
            answer = Math.min(answer, dfs(i + 1, distribute, cookies, k, zeroCount));
            
            distribute[j] -= cookies[i];
            zeroCount += distribute[j] == 0 ? 1 : 0;
        }
        
        return answer;
    }
    
    public int distributeCookies(int[] cookies, int k) {
        int[] distribute = new int[k];
        
        return dfs(0, distribute, cookies, k, k);
    }
}