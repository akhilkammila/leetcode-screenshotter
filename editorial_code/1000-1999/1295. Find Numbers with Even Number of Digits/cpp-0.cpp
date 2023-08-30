class Solution {
public:
    // Helper function to check if the number of digits is even
    bool hasEvenDigits(int num) {
        int digitCount = 0;
        while (num) {
            digitCount++;
            num /= 10;
        }
        return (digitCount & 1) == 0;
    }

    int findNumbers(vector<int>& nums) {
        // Counter to count the number of even digit integers
        int evenDigitCount = 0;

        for (int num : nums) {
            if (hasEvenDigits(num))
                evenDigitCount++;
        }

        return evenDigitCount;
    }
};