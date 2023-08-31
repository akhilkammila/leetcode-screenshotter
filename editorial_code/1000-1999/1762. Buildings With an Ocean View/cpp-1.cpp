class Solution {
public:
    vector<int> findBuildings(vector<int>& heights) {
        int n = heights.size();
        vector<int> answer;
        stack<int> st;
        
        for (int current = n - 1; current >= 0; --current) {
            // If the building to the right is smaller, we can pop it.
            while (!st.empty() && heights[st.top()] < heights[current]) {
                st.pop();
            }
            
            // If the stack is empty, it means there is no building to the right 
            // that can block the view of the current building.
            if (st.size() == 0) { 
                answer.push_back(current);
            }
            
            // Push the current building in the stack.
            st.push(current);
        }
        
        reverse(answer.begin(), answer.end());
        return answer;
    }
};