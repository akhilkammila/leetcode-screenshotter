class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {

        long prevRegularLane = 0;
        // Need to spend expressCost, as we start from the regular lane initially.
        long prevExpressLane = expressCost;

        long[] ans = new long[regular.length];
        for (int i = 1; i < regular.length + 1; i++) {
            // Use the regular lane; no extra cost to switch to the express lane.
            long regularLaneCost = regular[i - 1] + Math.min(prevRegularLane, prevExpressLane);
            // Use express lane; add extra cost if the previously regular lane was used.
            long expressLaneCost = express[i - 1] + Math.min(expressCost + prevRegularLane, prevExpressLane);

            ans[i - 1] = Math.min(regularLaneCost, expressLaneCost);

            prevRegularLane = regularLaneCost;
            prevExpressLane = expressLaneCost;
        }

        return ans;

    }
}