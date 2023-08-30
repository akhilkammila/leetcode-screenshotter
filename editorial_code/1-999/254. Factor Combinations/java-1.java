class Solution {
    public List<List<Integer>> getFactors(int n) {
        final List<List<Integer>> ans = new LinkedList<>();
        final Stack<LinkedList<Integer>> stack = new Stack<>();
        stack.push(new LinkedList<>(new LinkedList<>(Arrays.asList(n))));
        while (!stack.isEmpty()) {
            final LinkedList<Integer> factors = stack.pop();
            final int lastFactor = factors.removeLast();
            for (int i = factors.isEmpty() ? 2 : factors.peekLast(); i <=  lastFactor / i; ++i) {
                if (lastFactor % i == 0) {
                    // Add i and lastFactor / i.
                    LinkedList<Integer> newFactors = new LinkedList<>(factors);
                    newFactors.add(i);
                    newFactors.add(lastFactor / i);
                    stack.push(newFactors);
                    ans.add(new LinkedList<>(newFactors));
                }
            }
        }
        return ans;
    }
}