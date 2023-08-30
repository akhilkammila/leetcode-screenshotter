class Solution {
public:
    // Can these buses finish 'totalTrips' of trips in 'givenTime'?
    bool timeEnough(vector<int>& time, long long givenTime, int totalTrips) {
        long long actualTrips = 0;
        for (int t : time) {
            actualTrips += givenTime / t;
        }
        return actualTrips >= totalTrips;
    }
    long long minimumTime(vector<int>& time, int totalTrips) {
        // Initialize the left and right boundaries.
        long long left = 1, right = 1LL * *max_element(time.begin(), time.end()) * totalTrips;

        // Binary search to find the minimum time to finish the task.
        while (left < right) {
            long long mid = (left + right) / 2;
            if (timeEnough(time, mid, totalTrips)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
};