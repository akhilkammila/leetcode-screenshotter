class Solution {
    private ArrayList<ArrayList<Integer>> permutations(int[] nums) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        permute(ans, nums, 0);
        return ans;
    }

    private void permute(ArrayList<ArrayList<Integer>> ans, int[] nums, int start) {
        if (start >= nums.length) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            for (int x : nums) cur.add(x);
            ans.add(cur);
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                permute(ans, nums, start+1);
                swap(nums, start, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int numUniqueDiffs(ArrayList<Integer> arr) {
        boolean[] seen = new boolean[arr.size()];
        int ans = 0;

        for (int i = 0; i < arr.size() - 1; i++) {
            int delta = Math.abs(arr.get(i) - arr.get(i+1));
            if (!seen[delta]) {
                ans++;
                seen[delta] = true;
            }
        }
        return ans;
    }

    public int[] constructArray(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        for (ArrayList<Integer> cand : permutations(nums)) {
            if (numUniqueDiffs(cand) == k) {
                int[] ans = new int[n];
                int i = 0;
                for (int x : cand) ans[i++] = x;
                return ans;
            }
        }
        return null;
    }
}