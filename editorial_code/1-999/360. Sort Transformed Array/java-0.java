class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] answer = new int[n];
        for(int i = 0; i < n; ++i) {
            int num = nums[i];
            // Push transformed value in the 'answer' array.
            answer[i] = (a * num * num) + (b * num) + c;
        }
        // Sort the array of transformed values.
        Arrays.sort(answer);
        return answer;
    }
}