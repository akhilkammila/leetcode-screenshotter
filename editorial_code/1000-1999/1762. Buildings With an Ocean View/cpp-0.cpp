class Solution {
public:
    vector<int> findBuildings(vector<int>& heights) {
        int n = heights.size();
        vector<int> answer;
        
        for (int current = 0; current < n; ++current) {
            // If the current building is taller, 
            // it will block the shorter building's ocean view to its left.
            // So we pop all the shorter buildings that have been added before.
            while (!answer.empty() && heights[answer.back()] <= heights[current]) {
                answer.pop_back();
            }
            answer.push_back(current);
        }
        
        return answer;
    }
};