class Solution {
    // Can these buses finish 'totalTrips' of trips in 'givenTime'? 
    public boolean timeEnough(int[] time, long givenTime, int totalTrips) {
        long actualTrips = 0;
        for (int t : time) 
            actualTrips += givenTime / t;
        return actualTrips >= totalTrips;
    }
    
    public long minimumTime(int[] time, int totalTrips) {
        // Initialize the left and right boundaries.
        int max_time = 0;
        for (int t : time) {
            max_time = Math.max(max_time, t);
        }
        long left = 1, right = (long) max_time * totalTrips;

        // Binary search to find the minimum time to finish the task.
        while (left < right) {
            long mid = (left + right) / 2;
            if (timeEnough(time, mid, totalTrips)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}