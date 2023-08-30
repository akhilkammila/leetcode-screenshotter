class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lossesCount = new HashMap<>();
        for (int[] match : matches) {
            int winner = match[0], loser = match[1];
            lossesCount.put(winner, lossesCount.getOrDefault(winner, 0));
            lossesCount.put(loser, lossesCount.getOrDefault(loser, 0) + 1);
        }

        List<List<Integer>> answer =
            Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for (Integer player : lossesCount.keySet())
            if (lossesCount.get(player) == 0) {
                answer.get(0).add(player);
            } else if (lossesCount.get(player) == 1) {
                answer.get(1).add(player);
            }

        Collections.sort(answer.get(0));
        Collections.sort(answer.get(1));

        return answer;
    }
}