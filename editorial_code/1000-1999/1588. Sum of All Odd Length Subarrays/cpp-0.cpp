class Solution {
public:
    int sumOddLengthSubarrays(vector<int>& arr) {
        int n = int(arr.size()), answer = 0;
        
        for (int left = 0; left < n; ++left) {
            for (int right = left; right < n; ++right) {
                if ((right - left + 1) % 2 == 1) {
                    int currentSum = 0;
                    for (int index = left; index < right + 1; ++index) {
                        currentSum += arr[index];    
                    }
                    answer += currentSum;
                }
            }
        }
        return answer;
    }
};