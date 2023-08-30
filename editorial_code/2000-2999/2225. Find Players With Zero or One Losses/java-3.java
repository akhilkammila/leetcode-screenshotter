class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] lossesCount = new int[100001];
        Arrays.fill(lossesCount, -1);

        for (int[] match : matches) {
            int winner = match[0], loser = match[1];
            if (lossesCount[winner] == -1) {
                lossesCount[winner] = 0;
            }
            if (lossesCount[loser] == -1) {
                lossesCount[loser] = 1;
            } else {
                lossesCount[loser]++;
            }
        }

        List<List<Integer>> answer =
            Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for (int i = 1; i < 100001; ++i) {
            if (lossesCount[i] == 0) {
                answer.get(0).add(i);
            } else if (lossesCount[i] == 1) {
                answer.get(1).add(i);
            }
        }

        return answer;
    }
}