class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length, answer = 0;

        for (int left = 0; left < n; ++left) {
            int currentSum = 0;  
            for (int right = left; right < n; ++right) {
                currentSum += arr[right];
                answer += (right - left + 1) % 2 == 1 ? currentSum : 0;
            }
        }
        return answer;
    }
}