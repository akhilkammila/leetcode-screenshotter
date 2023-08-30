class Solution {
    int ans = 0;
    Map<Integer, Integer> values;
    public int pathSum(int[] nums) {
        values = new HashMap();
        for (int num: nums)
            values.put(num / 10, num % 10);

        dfs(nums[0] / 10, 0);
        return ans;
    }

    public void dfs(int node, int sum) {
        if (!values.containsKey(node)) return;
        sum += values.get(node);

        int depth = node / 10, pos = node % 10;
        int left = (depth + 1) * 10 + 2 * pos - 1;
        int right = left + 1;

        if (!values.containsKey(left) && !values.containsKey(right)) {
            ans += sum;
        } else {
            dfs(left, sum);
            dfs(right, sum);
        }
    }
}