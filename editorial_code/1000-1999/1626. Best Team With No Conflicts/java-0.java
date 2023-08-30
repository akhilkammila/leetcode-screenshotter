class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        final int n = ages.length;
        int[][] ageScorePair = new int[n][2];

        for (int i = 0; i < n; i++) {
            ageScorePair[i][0] = ages[i];
            ageScorePair[i][1] = scores[i];
        }

        // Sort in ascending order of age and then by score.
        Arrays.sort(ageScorePair, (a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        // Initially, all states are null, denoting not yet calculated.
        Integer[][] dp = new Integer[n][n];

        return findMaxScore(dp, ageScorePair, -1, 0);
    }

    private int findMaxScore(Integer[][] dp, int[][] ageScorePair, int prev, int index) {
        // Return 0 if we have iterated over all the players.
        if (index >= ageScorePair.length) {
            return 0;
        }

        // We have already calculated the answer, so no need to go into recursion.
        if (dp[prev + 1][index] != null) {
            return dp[prev + 1][index];
        }

        // If we can add this player, return the maximum of two choices we have.
        if (prev == -1 || ageScorePair[index][1] >= ageScorePair[prev][1]) {
            return dp[prev + 1][index] = Math.max(findMaxScore(dp, ageScorePair, prev, index + 1),
                    ageScorePair[index][1] + findMaxScore(dp, ageScorePair, index, index + 1));
        }

        // This player cannot be added; return the corresponding score.
        return dp[prev + 1][index] = findMaxScore(dp, ageScorePair, prev, index + 1);
    }

}