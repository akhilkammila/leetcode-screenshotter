class Solution {
public:
    int maximumRequests(int n, vector<vector<int>>& requests) {
        int answer = 0; 
        
        for (int mask = 0; mask < (1 << requests.size()); mask++) {
            vector<int> indegree(n, 0);
            int pos = requests.size() - 1;
            // Number of set bits representing the requests we will consider.
            int bitCount = __builtin_popcount(mask);
            
            // If the request count we're going to consider is less than the maximum request 
            // We have considered without violating the constraints; then we can return it cannot be the answer.
            if (bitCount <= answer) {
                continue;
            }
            
            // For all the 1's in the number, update the array indegree for the building it involves.
            for (int curr = mask; curr > 0; curr >>= 1, pos--) {
                if (curr & 1) {
                    indegree[requests[pos][0]]--;
                    indegree[requests[pos][1]]++;
                }
            }
            
            int flag = 1;
            // Check if it doesn;t violates the constraints
            for (int i = 0; i < n; i++) {
                if (indegree[i]) {
                    flag = 0;
                    break;
                }
            }
            
            if (flag)  {
                answer = bitCount;
            }
        }
        
        return answer;
    }
};