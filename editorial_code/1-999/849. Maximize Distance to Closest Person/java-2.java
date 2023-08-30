class Solution {
    public int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int K = 0; //current longest group of empty seats
        int ans = 0;

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) {
                K = 0;
            } else {
                K++;
                ans = Math.max(ans, (K + 1) / 2);
            }
        }

        for (int i = 0; i < N; ++i)  if (seats[i] == 1) {
            ans = Math.max(ans, i);
            break;
        }

        for (int i = N-1; i >= 0; --i)  if (seats[i] == 1) {
            ans = Math.max(ans, N - 1 - i);
            break;
        }

        return ans;
    }
}