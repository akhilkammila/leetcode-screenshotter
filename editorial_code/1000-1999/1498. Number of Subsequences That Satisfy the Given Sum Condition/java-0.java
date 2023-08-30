class Solution {
    public static int binarySearchRightmost(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int mod = 1_000_000_007;
        Arrays.sort(nums);
        
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; ++i) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        
        int answer = 0;

        // Iterate over each left pointer.
        for (int left = 0; left < n; left++) {
            // Find the insertion position for `target - nums[left]`
            // 'right' equals the insertion index minus 1.
            int right = binarySearchRightmost(nums, target - nums[left]) - 1;
            if (right >= left) {
                answer += power[right - left];
                answer %= mod;
            }
            
        }
        
        return answer;
    }
}