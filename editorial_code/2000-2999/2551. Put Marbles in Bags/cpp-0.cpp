class Solution {
public:
    long long putMarbles(vector<int>& weights, int k) {
        // We collect and sort the value of all n - 1 pairs.
        int n = weights.size();
        vector<int> pairWeights(n - 1, 0);
        for (int i = 0; i < n - 1; ++i) {
            pairWeights[i] += weights[i] + weights[i + 1];
        }
        
        sort(pairWeights.begin(), pairWeights.end());
        
        // Get the difference between the largest k - 1 values and the 
        // smallest k - 1 values.
        long long answer = 0;
        for (int i = 0; i < k - 1; ++i) {
            answer += pairWeights[n - 2 - i] - pairWeights[i];
        }

        return answer;
    }
};