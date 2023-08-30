class Solution {
public:
    int maxTime = INT_MIN;
    
    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        vector<int> adjList[n];
        
        // Making an adjacent list, each index stores the Ids of subordinate employees.
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                adjList[manager[i]].push_back(i);
            }
        }
        
        queue<pair<int, int>>q;
        q.push({headID, 0});
        
        while (!q.empty()) {
            pair<int, int> manager = q.front();
            q.pop();
            
            int parent = manager.first;
            int time = manager.second;
            // Maximum time for an employee to get the news.
            maxTime = max(maxTime, time);
            
            for (int adjacent : adjList[parent]) {
                q.push({adjacent, time + informTime[parent]});
            }
        }
        
        return maxTime;
    }
};
