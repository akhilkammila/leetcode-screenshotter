class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> creditMap = new HashMap<>();
        for (int[] t : transactions) {
            creditMap.put(t[0], creditMap.getOrDefault(t[0], 0) + t[2]);
            creditMap.put(t[1], creditMap.getOrDefault(t[1], 0) - t[2]);
        }
        
        creditList = new ArrayList<>();
        for (int amount : creditMap.values()) {
            if (amount != 0) {
                creditList.add(amount);
            }
        }
        
        int n = creditList.size();
        return dfs(0, n);
    }
    
    List<Integer> creditList;
    private int dfs(int cur, int n) {
        while (cur < n && creditList.get(cur) == 0) {
            cur++;
        }
    
        if (cur == n) {
            return 0;
        }
        
        int cost = Integer.MAX_VALUE;
        for (int nxt = cur + 1; nxt < n; nxt++) {
            // If nxt is a valid recipient, do the following: 
            // 1. add cur's balance to nxt.
            // 2. recursively call dfs(cur + 1).
            // 3. remove cur's balance from nxt.
            if (creditList.get(nxt) * creditList.get(cur) < 0) {
                creditList.set(nxt, creditList.get(nxt) + creditList.get(cur));
                cost = Math.min(cost, 1 + dfs(cur + 1, n));
                creditList.set(nxt, creditList.get(nxt) - creditList.get(cur));
            }
        }
        
        return cost;
    }
}