public class Solution {
    public int tallestBillboard(int[] rods) {
        // dp[taller - shorter] = taller
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        
        for (int r : rods) {
            // newDp means we don't add r to these stands.
            Map<Integer, Integer> newDp = new HashMap<>(dp);
            
            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int diff = entry.getKey();
                int taller = entry.getValue();
                int shorter = taller - diff;
                
                // Add r to the taller stand, thus the height difference is increased to diff + r.
                int newTaller = newDp.getOrDefault(diff + r, 0);
                newDp.put(diff + r, Math.max(newTaller, taller + r));
                
                // Add r to the shorter stand, the height difference is expressed as abs(shorter + r - taller).
                int newDiff = Math.abs(shorter + r - taller);
                int newTaller2 = Math.max(shorter + r, taller);
                newDp.put(newDiff, Math.max(newTaller2, newDp.getOrDefault(newDiff, 0)));
            }
            
            dp = newDp;
        }
        
        // Return the maximum height with 0 difference.
        return dp.getOrDefault(0, 0);
    }
}