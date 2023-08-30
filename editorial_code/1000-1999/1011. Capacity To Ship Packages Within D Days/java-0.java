class Solution {
    // Check whether the packages can be shipped in less than "days" days with
    // "c" capacity.
    Boolean feasible(int[] weights, int c, int days) {
        int daysNeeded = 1, currentLoad = 0;
        for (int weight : weights) {
            currentLoad += weight;
            if (currentLoad > c) {
                daysNeeded++;
                currentLoad = weight;
            }
        }

        return daysNeeded <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int totalLoad = 0, maxLoad = 0;
        for (int weight : weights) {
            totalLoad += weight;
            maxLoad = Math.max(maxLoad, weight);
        }

        int l = maxLoad, r = totalLoad;

        while (l < r) {
            int mid = (l + r) / 2;
            if (feasible(weights, mid, days)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}