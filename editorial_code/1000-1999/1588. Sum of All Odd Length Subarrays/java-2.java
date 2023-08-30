class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length, answer = 0;
        
        for (int i = 0; i < n; ++i) {
            int left = i, right = n - i - 1;
            answer += arr[i] * (left / 2 + 1) * (right / 2 + 1);
            answer += arr[i] * ((left + 1) / 2) * ((right + 1) / 2);
        }
        
        return answer;
    }
}