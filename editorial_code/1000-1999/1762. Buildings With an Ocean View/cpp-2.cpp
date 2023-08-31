class Solution {
public:
    vector<int> findBuildings(vector<int>& heights) {
        int n = heights.size();
        vector<int> answer;
        int maxHeight = -1;
        
        for (int current = n - 1; current >= 0; --current) {
            // If there is no building higher (or equal) than the current one to its right,
            // push it in the answer array.
            if (maxHeight < heights[current]) {
                answer.push_back(current);
                
                // Update the max building till now.
                maxHeight = heights[current];
            }
        }
        
        reverse(answer.begin(), answer.end());
        return answer;
    }
};