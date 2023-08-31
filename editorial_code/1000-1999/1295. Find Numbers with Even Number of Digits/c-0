// Helper function to check if the number of digits is even
bool hasEvenDigits(int num) {
    int digitCount = 0;
    while (num) {
        digitCount++;
        num /= 10;
    }
    return (digitCount & 1) == 0;
}

int findNumbers(int* nums, int numsSize) {
    // Counter to count the number of even digit integers
    int evenDigitCount = 0;

    for (int i = 0; i < numsSize; i++) {
        if (hasEvenDigits(nums[i]))
            evenDigitCount++;
    }

    return evenDigitCount;
};