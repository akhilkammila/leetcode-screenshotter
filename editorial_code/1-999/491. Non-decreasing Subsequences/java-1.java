class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        for (int bitmask = 1; bitmask < (1 << n); bitmask++) {
            List<Integer> sequence = new ArrayList<Integer>();
            // check the i-th bit of the bitmask
            for (int i = 0; i < n; i++) {
                if (((bitmask >> i) & 1) == 1) {
                    sequence.add(nums[i]);
                }
            }
            if (sequence.size() >= 2) {
                // check whether the sequence is increasing
                boolean isIncreasing = true;
                for (int i = 0; i < sequence.size() - 1; i++) {
                    isIncreasing &= sequence.get(i) <= sequence.get(i + 1);
                }
                if (isIncreasing) {
                    result.add(sequence);
                }
            }
        }
        return new ArrayList(result);
    }
}