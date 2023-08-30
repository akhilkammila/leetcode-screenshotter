class Solution {
public:
    int maximumBags(vector<int>& capacity, vector<int>& rocks, int additionalRocks) {
        int n = int(capacity.size()), fullBags = 0;

        
        // Sort bags by the remaining capacity.
        vector<int> remainingCapacity(n);

        for (int i = 0; i < n; ++i)
            remainingCapacity[i] = capacity[i] - rocks[i];
        sort(remainingCapacity.begin(), remainingCapacity.end());

        // Iterate over sorted bags and fill them using additional rocks.
        for (int i = 0; i < n; ++i) {
            // If we can fill the current one, fill it and move on.
            // Otherwise, stop the iteration.
            if (additionalRocks >= remainingCapacity[i]) {
                additionalRocks -= remainingCapacity[i];
                fullBags++;
            }
            else {
                break;
            }
        }
        
        // Return `fullBags` after the iteration stops.
        return fullBags;
    }
};