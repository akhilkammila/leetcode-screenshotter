class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        // Distance from source to all other nodes.
        vector<int> dist(n, numeric_limits<int>::max());
        dist[src] = 0;

        // Run only K+1 times since we want shortest distance in K hops.
        for (int i = 0; i <= k; i++) {
            // Create a copy of dist vector.
            vector<int> temp(dist);
            for (auto& flight : flights) {
                if (dist[flight[0]] != numeric_limits<int>::max()) {
                    temp[flight[1]] = min(temp[flight[1]], dist[flight[0]] + flight[2]);
                }
            }
            // Copy the temp vector into dist.
            dist = temp;
        }
        return dist[dst] == numeric_limits<int>::max() ? -1 : dist[dst];
    }
};