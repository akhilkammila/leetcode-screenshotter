
class Solution {
    private int n;
    private int ans;
    private void dfs(int dep, int[] A, List<Long> cur) {
        if (dep == n) {
            if (cur.size() < 3) {
                return;
            }
            long diff = cur.get(1) - cur.get(0);
            for (int i = 1; i < cur.size(); i++) {                
                if (cur.get(i) - cur.get(i - 1) != diff) {
                    return;
                }
            }
            ans ++;
            return;
        }
        dfs(dep + 1, A, cur);
        cur.add((long)A[dep]);
        dfs(dep + 1, A, cur);
        cur.remove((long)A[dep]);
    }
    public int numberOfArithmeticSlices(int[] A) {
        n = A.length;
        ans = 0;
        List<Long> cur = new ArrayList<Long>();
        dfs(0, A, cur);
        return (int)ans;        
    }
}