public class Solution {
    class T {
        float max_val, min_val;
        String min_str, max_str;
    }
    public String optimalDivision(int[] nums) {
        T[][] memo = new T[nums.length][nums.length];
        T t = optimal(nums, 0, nums.length - 1, "", memo);
        return t.max_str;
    }
    public T optimal(int[] nums, int start, int end, String res, T[][] memo) {
        if (memo[start][end] != null)
            return memo[start][end];
        T t = new T();
        if (start == end) {
            t.max_val = nums[start];
            t.min_val = nums[start];
            t.min_str = "" + nums[start];
            t.max_str = "" + nums[start];
            memo[start][end] = t;
            return t;
        }
        t.min_val = Float.MAX_VALUE;
        t.max_val = Float.MIN_VALUE;
        t.min_str = t.max_str = "";
        for (int i = start; i < end; i++) {
            T left = optimal(nums, start, i, "", memo);
            T right = optimal(nums, i + 1, end, "", memo);
            if (t.min_val > left.min_val / right.max_val) {
                t.min_val = left.min_val / right.max_val;
                t.min_str = left.min_str + "/" + (i + 1 != end ? "(" : "") + right.max_str + (i + 1 != end ? ")" : "");
            }
            if (t.max_val < left.max_val / right.min_val) {
                t.max_val = left.max_val / right.min_val;
                t.max_str = left.max_str + "/" + (i + 1 != end ? "(" : "") + right.min_str + (i + 1 != end ? ")" : "");
            }
        }
        memo[start][end] = t;
        return t;
    }
}