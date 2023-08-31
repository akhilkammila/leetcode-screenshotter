class Solution {
    // Bucket sort function for each place value digit.
    void bucketSort(vector<int>& arr, int placeValue) {
        vector<vector<int>> buckets(10, vector<int>());
        // Store the respective number based on its digit.
        for (int& val : arr) {
            int digit = abs(val) / placeValue;
            digit = digit % 10;
            buckets[digit].push_back(val);
        }

        // Overwrite 'arr' in sorted order of current place digits.
        int index = 0;
        for (int digit = 0; digit < 10; ++digit) {
            for (int& val : buckets[digit]) {
                arr[index] = val;
                index++;
            }
        }
    }
    
    // Radix sort function.
    void radixSort(vector<int>& arr) {
        // Find the absolute maximum element to find max number of digits.
        int maxElement = arr[0];
        for (int& val : arr) {
            maxElement = max(abs(val), maxElement);
        }
        int maxDigits = 0;
        while (maxElement > 0) {
            maxDigits += 1;
            maxElement /= 10;
        }

        // Radix sort, least significant digit place to most significant.
        int placeValue = 1;
        for (int digit = 0; digit < maxDigits; ++digit) {
            bucketSort(arr, placeValue);
            placeValue *= 10;
        }

        // Seperate out negatives and reverse them. 
        vector<int> negatives, positives;
        for (int& val : arr) {
            if (val < 0) {
                negatives.push_back(val);
            } else {
                positives.push_back(val);
            }
        }
        reverse(negatives.begin(), negatives.end());
        // Final 'arr' will be 'negative' elements, then 'positive' elements.
        merge(negatives.begin(), negatives.end(), positives.begin(), positives.end(), arr.begin());
    }

public:
    vector<int> sortArray(vector<int>& nums) {
        radixSort(nums);
        return nums;
    }
};