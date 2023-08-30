class Solution {
public:
    double timeRequired(vector<int>& dist, int speed) {
        double time = 0.0;
        for (int i = 0 ; i < dist.size(); i++) {
            double t = (double) dist[i] / (double) speed;
            // Round off to the next integer, if not the last ride.
            time += (i == dist.size() - 1 ? t : ceil(t));
        }
        return time;
    }
    
    int minSpeedOnTime(vector<int>& dist, double hour) {
        int left = 1;
        int right = 1e7;
        int minSpeed = -1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            // Move to the left half.
            if (timeRequired(dist, mid) <= hour) {
                minSpeed = mid;
                right = mid - 1;
            } else {
                // Move to the right half.
                left = mid + 1;
            }
        }
        return minSpeed;
    }
};
