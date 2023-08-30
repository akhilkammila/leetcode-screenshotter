class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        vector<vector<int>> ans;
        
        // A map from group size to the list of indices that are there in the group.
        vector<int> szToGroup[groupSizes.size() + 1];
        for (int i = 0; i < groupSizes.size(); i++) {
            szToGroup[groupSizes[i]].push_back(i);
            
            // When the list size equals the group size, empty it and store it in the answer.
            if (szToGroup[groupSizes[i]].size() == groupSizes[i]) {
                ans.push_back(szToGroup[groupSizes[i]]);
                szToGroup[groupSizes[i]].clear();
            }
        }
        
        return ans;
    }
};