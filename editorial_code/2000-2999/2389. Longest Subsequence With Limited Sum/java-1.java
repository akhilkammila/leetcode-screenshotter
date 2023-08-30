class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        // Get the prefix sum array of the sorted 'nums'.
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; ++i)
            nums[i] += nums[i - 1];
        
        // For each query, find its insertion index to the prefix sum array.
        int n = queries.length;
        int answer[] = new int[n];
        for (int i = 0; i < n; ++i) {
            int index = binarySearch(nums, queries[i]);
            answer[i] = index;
        }
        
        return answer;
    }
    
    int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid + 1;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return nums[left] > target ? left : left + 1;
    }
}