class Solution {
public:
    vector<long long> minimumCosts(vector<int>& regular, vector<int>& express, int expressCost) {
        int N = regular.size() + 1;
        
        long prevRegularLane = 0;
        // Need to spend expressCost, as we start from the regular lane initially.
        long prevExpressLane = expressCost;
        
        vector<long long> ans;
        for (int i = 1; i < N; i++) {
            // Use the regular lane; no extra cost to switch to the express lane.
            long regularLaneCost = regular[i - 1] + min(prevRegularLane, prevExpressLane);
            // Use express lane; add extra cost if the previously regular lane was used.
            long expressLaneCost = express[i - 1] + min(expressCost + prevRegularLane, prevExpressLane);
            
            ans.push_back(min(regularLaneCost, expressLaneCost));
            
            prevRegularLane = regularLaneCost;
            prevExpressLane = expressLaneCost;
        }
        
        return ans; 
    }
};