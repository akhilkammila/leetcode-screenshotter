class Solution {
public:
    vector<int> longestObstacleCourseAtEachPosition(vector<int>& obstacles) {
        int n = obstacles.size();
        
        // lis[i] records the lowest increasing sequence of length i + 1.
        vector<int> answer(n, 1), lis;
        
        for (int i = 0; i < n; ++i) {
            // Find the rightmost insertion position idx.
            int idx = upper_bound(lis.begin(), lis.end(), obstacles[i]) - lis.begin();
            if (idx == lis.size())
                lis.push_back(obstacles[i]);
            else
                lis[idx] = obstacles[i];
            answer[i] = idx + 1;
        }
        return answer;
    }
};