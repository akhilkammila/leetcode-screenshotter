class Solution {
    private void backtracking(final LinkedList<Integer> factors, final List<List<Integer>> ans) {
        // Got a solution.
        if (factors.size() > 1) {
            ans.add(new ArrayList(factors));
        }
        final int lastFactor = factors.removeLast();
        for (int i = factors.isEmpty() ? 2 : factors.peekLast(); i <=  lastFactor / i; ++i) {
            if (lastFactor % i == 0) {
                // Add i and lastFactor / i.
                factors.add(i);
                factors.add(lastFactor / i);
                backtracking(factors, ans);
                // Remove the last 2 elements in factors to restore it after the recursion returns.
                factors.removeLast();
                factors.removeLast();
            }
        }
        // Add lastFactor back to factors to restore it.
        factors.add(lastFactor);
    }

    public List<List<Integer>> getFactors(int n) {
        final List<List<Integer>> ans = new LinkedList<>();
        backtracking(new LinkedList<>(Arrays.asList(n)), ans);
        return ans;
    }
}
