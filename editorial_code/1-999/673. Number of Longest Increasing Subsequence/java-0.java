class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] length = new int[n];
        int[] count = new int[n];
        
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = 0;
                    }
                    if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }
        
        int maxLength = 0;
        int result = 0;

        for (int len : length) {
            maxLength = Math.max(maxLength, len);
        }

        for (int i = 0; i < n; i++) {
            if (length[i] == maxLength) {
                result += count[i];
            }
        }
        
        return result;
    }
}