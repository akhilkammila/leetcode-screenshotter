class Solution {
public:
    const static int K = 10000;
        
    int arrayPairSum(vector<int>& nums) {
        // Store the frequency of each element
        int elementToCount[2 * K + 1] = {0};
        for (int element : nums) {
            // Add K to element to offset negative values
            elementToCount[element + K]++;
        }
        
        // Initialize sum to zero
        int maxSum = 0;
        bool isEvenIndex = true;
        for (int element = 0; element <= 2 * K; element++) {
            while (elementToCount[element]) {
                // Add element if it is at even position
                maxSum += (isEvenIndex ? element - K : 0);
                // Flip the value (one to zero or zero to one)
                isEvenIndex = !isEvenIndex;
                // Decrement the frequency count
                elementToCount[element]--;
            }
        }
        return maxSum;
    }
};