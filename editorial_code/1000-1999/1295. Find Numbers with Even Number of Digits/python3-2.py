class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        # Counter to count the number of even digit integers
        even_digit_count = 0

        for num in nums:
            # Compute the number of digits in num
            digit_count = int(math.floor(math.log10(num))) + 1
            if digit_count % 2 == 0:
                even_digit_count += 1

        return even_digit_count