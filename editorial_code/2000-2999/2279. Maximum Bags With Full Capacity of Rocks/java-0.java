class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length, fullBags = 0;
        
        // Sort bags by the remaining capacity.
        int[] remainingCapacity = new int[n];
        for (int i = 0; i < n; ++i)
            remainingCapacity[i] = capacity[i] - rocks[i];
        Arrays.sort(remainingCapacity);
    
        // Iterate over sorted bags and fill them using additional rocks.
        for (int i = 0; i < n; ++i) {
            // If we can fill the current one, fill it and move on.
            // Otherwise, stop the iteration.
            if (additionalRocks >= remainingCapacity[i]) {
                additionalRocks -= remainingCapacity[i];
                fullBags++;
            }
            else
                break;
        }
        
        // Return `fullBags` after the iteration stops.
        return fullBags;
    }
}