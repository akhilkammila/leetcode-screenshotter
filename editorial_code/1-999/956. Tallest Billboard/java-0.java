class Solution {
    // Helper function to collect every combination `(left, right)`
    Map<Integer, Integer> helper(int[] rods, int leftIndex, int rightIndex) {
        Set<Pair<Integer, Integer>> states = new HashSet<>();
        states.add(new Pair(0, 0));
        for (int i = leftIndex; i < rightIndex; ++i) {
            int r = rods[i];
            Set<Pair<Integer, Integer>> newStates = new HashSet<>();
            for (Pair<Integer, Integer> p : states) {
                newStates.add(new Pair(p.getKey() + r, p.getValue()));
                newStates.add(new Pair(p.getKey(), p.getValue() + r));
            }
            states.addAll(newStates);
        }

        Map<Integer, Integer> dp = new HashMap<>();
        for (Pair<Integer, Integer> p : states) {
            int left = p.getKey(), right = p.getValue();
            dp.put(left - right, Math.max(dp.getOrDefault(left - right, 0), left));
        }
        return dp;
    }
    
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        Map<Integer, Integer> firstHalf = helper(rods, 0, n / 2);
        Map<Integer, Integer> secondHalf = helper(rods, n / 2, n);

        int answer = 0;
        for (int diff : firstHalf.keySet()) {
            if (secondHalf.containsKey(-diff)) {
                answer = Math.max(answer, firstHalf.get(diff) + secondHalf.get(-diff));
            }
        }
        return answer;
    }
}