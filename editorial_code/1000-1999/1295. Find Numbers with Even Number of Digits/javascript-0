/**
 * @param {number} num
 * @return {boolean}
 */
var hasEvenDigits = function(num) {
    let digitCount = 0;
    while (num) {
        digitCount++;
        num = Math.floor(num / 10);
    }
    return (digitCount & 1) == 0;
};

/**
 * @param {number[]} nums
 * @return {number}
 */
var findNumbers = function(nums) {
    // Counter to count the number of even digit integers
    let evenDigitCount = 0;

    for (let num of nums) {
        if (hasEvenDigits(num))
            evenDigitCount++;
    }

    return evenDigitCount;
};