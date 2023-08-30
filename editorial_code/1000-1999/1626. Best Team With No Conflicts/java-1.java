class Solution {
    private int findMaxScore(int[][] ageScorePair) {
        int n = ageScorePair.length;
        int answer = 0;

        int[] dp = new int[n];
        // Initially, the maximum score for each player will be equal to the individual scores.
        for (int i = 0; i < n; i++) {
            dp[i] = ageScorePair[i][1];
            answer = Math.max(answer, dp[i]);
        }


        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // If the players j and i could be in the same team.
                if (ageScorePair[i][1] >= ageScorePair[j][1]) {
                    // Update the maximum score for the ith player.
                    dp[i] = Math.max(dp[i], ageScorePair[i][1] + dp[j]);
                }
            }
            // Maximum score among all the players.
            answer = Math.max(answer, dp[i]);
        }

        return answer;
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int N = ages.length;
        int[][] ageScorePair = new int[N][2];

        for (int i = 0; i < N; i++) {
            ageScorePair[i][0] = ages[i];
            ageScorePair[i][1] = scores[i];
        }

        // Sort in ascending order of age and then by score.
        Arrays.sort(ageScorePair, (a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        return findMaxScore(ageScorePair);
    }
}