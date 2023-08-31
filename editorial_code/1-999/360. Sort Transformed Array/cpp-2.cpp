class Solution {
public:
    vector<int> sortTransformedArray(vector<int>& nums, int a, int b, int c) {
        int n = nums.size();
        vector<int> answer(n);

        for(int i = 0; i < n; ++i) {
            int num = nums[i];
            // Push transformed value in 'answer' array.
            answer[i] = (a * num * num) + (b * num) + c;
        }

        // Find the absolute maximum element to find max number of digits.
        int maxElement = nums[0];
        for (int& num : answer) {
            maxElement = max(abs(num), maxElement);
        }
        int maxDigits = 0;
        while (maxElement > 0) {
            maxDigits += 1;
            maxElement /= 10;
        }

        // Radix sort, least significant digit place to most significant.
        int placeValue = 1;
        for (int digit = 0; digit < maxDigits; ++digit) {
            sort(answer, placeValue);
            placeValue *= 10;
        }

        // Seperate out negatives and reverse them. 
        vector<int> negatives, positives;
        for (int& num : answer) {
            if (num < 0) {
                negatives.push_back(num);
            } else {
                positives.push_back(num);
            }
        }
        reverse(negatives.begin(), negatives.end());

        // Final 'answer' will be 'negative' elements, then 'positive' elements.
        merge(negatives.begin(), negatives.end(), positives.begin(), positives.end(), answer.begin());
        return answer;
    }
    
private:
    void sort(vector<int>& array, int placeValue) {
        vector<vector<int>> mapDigits(10, vector<int>());
        for (int& num : array) {
            int digit = abs(num) / placeValue;
            digit = digit % 10;
            mapDigits[digit].push_back(num);
        }

        // Overwrite 'array' in sorted order of current place digits.
        int index = 0;
        for (int digit = 0; digit < 10; ++digit) {
            for (int& num : mapDigits[digit]) {
                array[index] = num;
                index++;
            }
        }
    }
};